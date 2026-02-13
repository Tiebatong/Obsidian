
Gib eine Zufallszahl zwischen 0 und 1 (ausschließlich) zurück.
Falls man eine Zufallszahl benötigt, die größer als 1 sein muss / darf muss man das Ergebnis von Math.random() mit der oberen Grenze + 1 multiplizieren.

float zufallszahl = Math.random() * (obere_grenze + 1);

Falls man einen int braucht ist es wichtig Math.random() vor der Zuweisung zu int zu casten.

int zufallszahl = (int) (Math.random() * m);

Die Klammern sind hier sehr wichtig, das sonst Math.random() direkt zu int gecastet wird, das führt immer zu einer 0.