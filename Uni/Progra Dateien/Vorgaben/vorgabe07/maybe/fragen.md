1. Alle Konstruktoren von `MaybeInt` sind privat. Wie können andere Klassen wie `ArrayTools` trotzdem Instanzen von `MaybeInt` erstellen?



2. Welchen Wert haben die Instanzvariablen von `this` in der Methode `modified` garantiert, wenn der `return this`-Fall (Zeile 24) eintritt? Finden Sie, dass der Code an dieser Stelle gut nachvollziehbar ist?



3. Erklären Sie, warum der Ausdruck `avg.modified(add5).orDefault(-1)` den Wert 9 hat (Zeile 15 in der Klasse `Test`). Gehen Sie dazu auf den Datentyp und den Wert der Teilausdrücke `avg` und `avg.modified(add5)` ein.



4. Zum Knobeln: Warum hat ArrayTools einen privaten Konstruktor? Was wäre, wenn wir den Konstruktor einfach weglassen?



5. _Bonusaufgabe (beantworten, nachdem Sie die Code-Aufgaben gemacht haben):_ In der Übungsaufgabe mit den Widerständen haben wir Ihnen vom OCP erzählt. Inwiefern ist `MaybeInt` in dieser Aufgabe offen für neue Möglichkeiten gewesen, seinen Inhalt auf neue Arten zu modifizieren (quadrieren, zu Boolean umwandeln)? Wo ging das ohne Modifikation von `MaybeInt`, wo nicht? Warum ging es ggf. nicht ohne Veränderung an MaybeInt?

