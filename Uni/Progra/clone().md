
### shallow copy: 
Kopiert nur die Referenz auf das [[Objekt]], beide Objekte haben jetzt die selbe Adresse im [[Heap]]

object_A = object_B;

Da beide Objekte die selbe Adresse haben wird jede Veränderung auch beim anderen [[Objekt]] übernommen.
### deep copy (defensive copy):

#### clone():
Übernimmt alle Atribute des Objektes behält aber seine individuelle Adresse bei.
Eine Änderung des einen Objektes führt nicht mehr zu einer Änderung des anderen Objektes.

object_A = object_B.clone();

#### loop:

Mit einer [[Schleife]] werden einzeln alle Atribute des Objektes kopiert.