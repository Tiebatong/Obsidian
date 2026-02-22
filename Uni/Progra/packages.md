In größeren Projekten werden verschiedene Dateien oft in verschiedenen Ordnern sortiert.
Java weiß jetzt aber nicht mehr wo die Funktionen und Klassen liegen, die man aufruft.
Die Klasse FakeNames im Ordner benchmark hat jetzt den voll qualifizierten Namen: benchmark.FakeNames.
Dazu muss in der Klasse der Ordner als package angegeben werden.
Wenn eine Klasse package private ist, heißt das, dass sie nur im package sichtbar ist.
Das heißt, dass diese Objekte auch nur mit ihrem voll qualifizierten Namen aufgerufen werden können:
![[Pasted image 20260219151331.png]]

Das gilt auch, wenn man eine kompilierte class Datei die Teil eines Packages ist ausführen möchte.
bsp:
java benchmark.SizeBenchmark

![[Screenshot 2026-02-19 150449.png]]

### umgekehrte url Notation
So Können die beiden Klassen point eindeutig voneinander unterschieden werden, das Packe wird wie eine url strukturiert, da diese eindeutig sind und so auch Kollisionen mit anderen Packages von anderen Entwicklern vermieden werden.

Der Package "Pfad" wird ind er Java Datei selber mit "." getrennt, beim Kompilieren in der Konsole wird der Pfad aber mit "/" angegeben.
Beim Ausführen in der Konsole aber wieder mit "."
![[Pasted image 20260219152115.png]]

### Klassen aus Packages nutzen

![[Pasted image 20260219152559.png]]
 
