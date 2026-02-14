Ein Interface bestimmt welche Funktionen eine Klasse implementieren muss.

Interfaces werden von Klassen implementiert, diese Klasse muss dann die im Interface angegebenen Funktionen implementieren.

Im Interface selber wird nicht die ganze Funktion selbst geschrieben, sondern nur der Rückgabetyp und der Name der Funktion.

bsp aus [[blatt06.pdf]]:

![[Pasted image 20260214173901.png]]

Das Interface setzt die Funktion double resistance()
und die Funktion int resistorCount() voraus.


![[Pasted image 20260214173950.png]]


Der [[Konstruktor]] SeriesCircuit nimmt jetzt jedes Objekt entgegen, das das Interface implementiert.
Dadurch kann man sicherstellen, dass jedes Objekt das in SeriesCircuit gespeichert wird die nötigen [[Instanzvariablen]] / Funktionen hat.
