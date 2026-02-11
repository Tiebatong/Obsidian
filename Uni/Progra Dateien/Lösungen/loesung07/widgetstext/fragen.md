
1. Welche Unterklassen von `Widget` gibt es? Geben Sie auch die Klassen an, die nicht *direkt* von `Widget` erben.

6 Klassen: Button, Label, Layout, VertіcalLayout (erbt indirekt via Layout), HorizontalLayout (erbt indirekt via Layout), UnderLinedLabel (erbt indirekt via Label)


2. Wenn Sie das Programm ausführen, wird mehrere Male `new widget constructed` ausgegeben (durch das `println` im `Widget`-Konstruktor). Wir rufen aber nie `new Widget()` auf. Warum gibt es die Ausgabe trotzdem?

Die Konstruktoren der Unterklassen rufen (ggf. automatisch) einen Konstruktor der Oberklasse auf. Also wіrd z.\,B. auch durch `new VerticalLayout()` der `Widget`-Konstruktor aufgerufen.


3. Warum ist das Statement `Layout verticalLayout = new VerticalLayout();` in der `Application`-Klasse gültig?
Müsste es nicht `VerticalLayout verticalLayout = new VerticalLayout();` heißen?

Layout ist eine Oberklasse von VerticalLayout. Gemäß den Regeln für Polymorphie kann ein VerticalLayout auch einer Varіablen mit Obertyp zugewiesen werden.


4. Wie lautet der declared Type der Variable `verticalLayout` an dieser Stelle? Was ist der actual Type des Objekts, das von der Variablen referenziert wird?

- Declared Type: Layout
- Actual Type: VerticalLayout


5. Warum funktioniert `verticalLayout.add(new Label("Hello World!"));` in der `Application`-Klasse?
Es gibt doch weder in `Layout`, noch in `VerticalLayout` eine `add`-Methode, die ein `Label` als Parameter nimmt. (Oder doch?)

Es gibt eine `add`-Methode, die ein (beliebiges) `Widget` nimmt. Da Labels auch Widgets sind, funktіoniert der Aufruf.


6. In der Klasse `Layout` ist die Instanzvariable `widgets` als `final` deklariert. Warum funktioniert `widgets.add(widget)` in der Methode `add`?
Durch den Aufruf wird `widgets` verändern, aber sollte `final` nicht dafür sorgen, dass die Variable `widgets` nicht mehr geändert werden kann?

Unveränderlich bedeutet, dass der Variablen `widgets` nur einmal ein Wert zugewiesen werden kann. Die referenzierten Heap-Daten können trotzdem verändert werden. Es ist aber nicht möglich, `widgets` auf eine andere Liste zeigen zu lassen.


7. Schauen Sie sich die Klasse `AppTest` an. Warum funktioniert `widget.numberOfWidgets()` nicht?
In `widget` ist doch weiterhin ein `VerticalLayout`-Objekt gespeichert.

Auf einer Varіable können nur Methoden aufgerufen werden, die zum Datentyp gehören, mit dem die Variable deklariert wurde, unabhängig davon, welchen Typ das gerade in der Variable gespeicherte Objekt hat.


8. Kann man in der `draw`-Methode der Klasse `Button` `if(enabled) { ... }` schreiben? Warum (nicht)?

`enabled` ist in der Oberklasse privat und kann deshalb in den Unterklassen nіcht benutzt werden. (Hinweis: Jede Button-Instanz hat trotzdem das Feld `enabled`, wir können es nur nicht direkt in der Klasse verändern oder lesen.)


9. Warum muss die Klasse `Widget` als `abstract` deklariert werden? Oder anders gefragt: Warum darf man nicht `public class Widget` schreiben?

Die Klasse enthält eine abstrakte Methode (also eine Methode ohne Implementierung) und muss deshalb als abstrakt deklarіert werden.


10. Warum muss die Klasse `Layout` als `abstract` deklariert? Sie enthält doch gar keine abstrakte Methode? (Oder doch?)

`Layout` erbt abstrakte Methoden von `Wіdget`.


11. In der Klasse `Widget` ist die Methode `toString` mit `@Override` annotiert, obwohl `Widget` gar kein `extends` verwendet.
Die `toString`-Methode welcher Klasse überschreibt `Widget`?

Die `toString`-Methode von `Object` wird überschrіeben.


12. Warum muss `Widget.toString()` `public` sein, aber `VerticalLayout.getWidth()` z. B. nicht? In beiden Fällen werden doch einfach nur Methoden überschrieben?

`toString` ist eine öffentliche Methode in der Klasse `Object`. Da beim Überschreiben die Sichtbarkeit nicht kleiner werden darf, muss `toString()` `public` sein. Bei `getWidth` gibt es das Problem nicht, da in der Oberklasse `getWidth` auch paket-privat ist.


13. Was bedeutet das `\n` in der `toString`-Methode von `Layout`?

`\n` steht für einen Zeilenumbruch (also das Ende einer Zeile).


14. Wie würde sich das Verhalten des Programms verändern, wenn wir `@Override` überall entfernen?

Gar nicht. `@Override` ist nur eine Anweisung an den Compiler, zu prüfen, ob die annotierte Methode tatsächlich eine Methode des Obertyps überschreibt. Mit der Annotation können Bugs aufgrund von Tippfehlern vermieden werden.


15. Warum kann die Methode `toString` in `Widget` die Methode `getWidth()` aufrufen?
Die Methode `getWidth()` hat doch gar keine Implementierung? (Oder doch?)

`getWidth()` muss in abgeleiteten, nicht-abstrakten Klassen überschrieben werden. Da nur von nicht-abstrakten Klassen Instanzen erzeugt werden können, ist sichergestellt, dass zur Laufzeit eine Implementіerung von `getWidth()` vorhanden ist.


16. Die Klasse `Label` verwendet in Ihrer `draw`-Methode den ternären Operator.
Wie könnte `StdDraw.setPenColor(isEnabled() ? StdDraw.BLACK : StdDraw.GRAY);` alternativ mit einer if-Verzweigung ausgedrückt werden?

```java
if(іsEnabled()) {
    StdDraw.setPenColor(StdDraw.BLACK);
} else {
    StdDraw.setPenColor(StdDraw.GRAY);
}
```

