Wird genutzt um eine defensive copy anzulegen. 

Wenn man ein [[Objekt]] kopieren möchte gibt es 2 Option
### shallow copy: 
kopiert nur die Referenz auf das [[Objekt]], beide Objekte haben jetzt die selbe Adresse im [[Heap]]

object_A = object_B;

Da beide Objekte die selbe Adresse haben wird jede Veränderung auch beim anderen [[Objekt]] übernommen.
### deep copy:

anlegen.
