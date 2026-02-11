
1. Welche Unterklassen von `Widget` gibt es? Geben Sie auch die Klassen an, die nicht *direkt* von `Widget` erben.



2. Wenn Sie das Programm ausführen, wird mehrere Male `new widget constructed` ausgegeben (durch das `println` im `Widget`-Konstruktor). Wir rufen aber nie `new Widget()` auf. Warum gibt es die Ausgabe trotzdem?



3. Warum ist das Statement `Layout verticalLayout = new VerticalLayout();` in der `Application`-Klasse gültig?
Müsste es nicht `VerticalLayout verticalLayout = new VerticalLayout();` heißen?



4. Wie lautet der declared Type der Variable `verticalLayout` an dieser Stelle? Was ist der actual Type des Objekts, das von der Variablen referenziert wird?

- Declared Type: 
- Actual Type: 


5. Warum funktioniert `verticalLayout.add(new Label("Hello World!"));` in der `Application`-Klasse?
Es gibt doch weder in `Layout`, noch in `VerticalLayout` eine `add`-Methode, die ein `Label` als Parameter nimmt. (Oder doch?)



6. In der Klasse `Layout` ist die Instanzvariable `widgets` als `final` deklariert. Warum funktioniert `widgets.add(widget)` in der Methode `add`?
Durch den Aufruf wird `widgets` verändern, aber sollte `final` nicht dafür sorgen, dass die Variable `widgets` nicht mehr geändert werden kann?



7. Schauen Sie sich die Klasse `AppTest` an. Warum funktioniert `widget.numberOfWidgets()` nicht?
In `widget` ist doch weiterhin ein `VerticalLayout`-Objekt gespeichert.



8. Kann man in der `draw`-Methode der Klasse `Button` `if(enabled) { ... }` schreiben? Warum (nicht)?



9. Warum muss die Klasse `Widget` als `abstract` deklariert werden? Oder anders gefragt: Warum darf man nicht `public class Widget` schreiben?



10. Warum muss die Klasse `Layout` als `abstract` deklariert? Sie enthält doch gar keine abstrakte Methode? (Oder doch?)



11. In der Klasse `Widget` ist die Methode `toString` mit `@Override` annotiert, obwohl `Widget` gar kein `extends` verwendet.
Die `toString`-Methode welcher Klasse überschreibt `Widget`?



12. Warum muss `Widget.toString()` `public` sein, aber `VerticalLayout.getWidth()` z. B. nicht? In beiden Fällen werden doch einfach nur Methoden überschrieben?



13. Was bedeutet das `\n` in der `toString`-Methode von `Layout`?



14. Wie würde sich das Verhalten des Programms verändern, wenn wir `@Override` überall entfernen?



15. Warum kann die Methode `toString` in `Widget` die Methode `getWidth()` aufrufen?
Die Methode `getWidth()` hat doch gar keine Implementierung? (Oder doch?)



16. Die Klasse `Label` verwendet in Ihrer `draw`-Methode den ternären Operator.
Wie könnte `StdDraw.setPenColor(isEnabled() ? StdDraw.BLACK : StdDraw.GRAY);` alternativ mit einer if-Verzweigung ausgedrückt werden?


