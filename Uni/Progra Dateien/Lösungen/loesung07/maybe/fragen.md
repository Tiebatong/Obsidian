1. Alle Konstruktoren von `MaybeInt` sind privat. Wie können andere Klassen wie `ArrayTools` trotzdem Instanzen von `MaybeInt` erstellen?

Die statischen Methoden `of` und `empty` können benutzt werden. Diese rufen dann den privaten Konstruktor auf.

Hinweis: Diese Konstruktion nennt man „statische Factorymethode“. Diese sind gegenüber Konstruktoren etwas flexibler:
- Der Name der Factorymethode kann beliebig gewählt werden.
- Factorymethoden, deren Signatur sich nur im Namen unterscheidet, können existieren. (Beides wäre z. B. bei unserem CartesianPoint praktisch gewesen: Da hätten wir fromCartesian(int, int) und fromPolar(int, int) anbieten können.)
- Factorymethoden müssen kein neues Objekt zurückgeben. (Bspw. könnte MaybeInt.empty() auch immer dasselbe, leere MaybeInt-Objekt zurückgeben, anstatt ein neues zu erstellen.)
- Factorymethoden müssen kein Objekt der Klasse selbst zurückgeben. (Denkbar wären, je nach Signatur, auch Unter- oder Obertypen. Bspw. könnte Resisors.of(1,2) zwei in Reihe geschaltete Widerstände zurückgeben.)
Factorymethode schauen wir uns im Programmierpraktikum noch ganauer an.


2. Welchen Wert haben die Instanzvariablen von `this` in der Methode `modified` garantiert, wenn der `return this`-Fall eintritt? Finden Sie, dass der Code an dieser Stelle gut nachvollziehbar ist?

`0` bzw. `false`. Das `false` ist durch die if-Verzweigung an sich garantiert. Da der Konstruktor privat ist, können auch nur innerhalb der Maybe-Klasse selbst Maybe-Objekte erzeugt werden. Die einzige Stelle, wo ein Maybe-Objekt mit `false` erzeugt wird, setzt `value` auf `0`.


3. Erklären Sie, warum der Ausdruck `avg.modified(add5).orDefault(-1)` den Wert 9 hat. Gehen Sie dazu auf den Datentyp und den Wert der Teilausdrücke `avg` und `avg.modified(add5)` ein.

- `avg`: Typ `MaybeInt`, Wert `MaybeInt[4]` (Hinweis: Notation beliebig gewählt, sodass wir verstehen, was gemeint ist.)
    - Mittelwert mit abeschnittenen Nachkommastellen
- `avg.modified(add5)`: Typ `MaybeInt`, Wert `MaybeInt[9]`
    - Wir erhalten hier ein neues `MaybeInt`-Objekt. In der Instanzmethode `modified` landen wir im else-Fall. Dort wird der `value` von `avg` (also `4`) genommen und an die `run`-Methode von `add5` übergeben. Diese Methode rechnet `4 + 5` und gibt diesen Wert zurück. Aus diesem Rückgabewert wird dann ein neuer `MaybeInt` gebaut und dieser zurückgegeben.
- `avg.modified(add5).orDefault(-1)`: Typ `int`, Wert `9`
    - In `orDefault` landen wir im else-Fall, da der `MaybeInt` nicht leer ist. Dort wird der Wert 9 zurückgegeben.


4. Zum Knobeln: Warum hat ArrayTools einen privaten Konstruktor? Was wäre, wenn wir den Konstruktor einfach weglassen?

Wenn der Konstruktor nicht in der Klasse stünde, gäbe es automatisch den Default-Konstruktor. Von der Person, die `ArrayTools` geschrieben hat, ist aber nicht vorgesehen worden, dass es Instanzen der Klasse gibt: `ArrayTools`-Objekte haben kein sinnvolles Verhalten.

Hinweis: `new Math()` können Sie z. B. auch aus diesem Grund nicht aufrufen.


5. _Bonusaufgabe:_ In der Übungsaufgabe mit den Widerständen haben wir Ihnen vom OCP erzählt. Inwiefern ist `MaybeInt` in dieser Aufgabe offen für neue Möglichkeiten gewesen, seinen Inhalt auf neue Arten zu modifizieren (quadrieren, zu Boolean umwandeln)? Wo ging das ohne Modifikation von `MaybeInt`, wo nicht? Warum ging es ggf. nicht ohne Veränderung an MaybeInt?

`MaybeInt` konnte mit beliebigen Implementierungen von `Int2IntFunction` umgehen: Wenn man eine neue Berechnung auf `MaybeInt` mit `modified` anwenden wollte, musste man nur eine neue Implementierung von `Int2IntFunction` schreiben. Die Klasse `MaybeInt` musste aber nicht angepasst werden.

`MaybeInt` musste aber angepasst werden, um eine grundsätzlich andere Operation, nämlich die Umwandlung in einen Boolean-Wert, hinzuzufügen.

--

Hinweis: Die hier gezeigte Strategie zum Umgang mit „nicht vorhandenen“ Werten gibt es in Java wirklich. Wir zeigen Ihnen die im JDK eingebauten Klassen erst nächstes Semester. Wenn Sie sich aber mal selbst damit beschäftigen wollen, sind hier die Entsprechungen im JDK:

- `MaybeInt` → `OptionalInt`
- `hasValue()` → `isPresent()`
- `modified(..)` → `stream().map(..).findFirst()`
- `fulfills(..)` → `stream().anyMatch(..)`
- `orDefault(..)` → `orElse(..)`

- `Int2IntFunction` → `IntUnaryOperator`
- `Int2BooleanFunction` → `IntPredicate`

Um diese Klasse nutzen zu können, müssen wir Ihnen noch ein paar Techniken beibringen. Für Interessierte ist in `TestVorschau` eine Variante des Codes mit den JDK-Klassen.

Was Sie hieraus aber mitnehmen können: Interface-Typen sind in Java allgegenwärtig. Sie ermöglichen es uns hier, neue Operationen auf fertige Datentypen anzuwenden.
