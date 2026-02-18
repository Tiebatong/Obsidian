[[Datenstruktur]] mit Key  value Paaren.

Eine Hash map besteht aus 2 internen Arrays, einem Array, dass die keys speichert, und einem, dass die values speichert.
Außerdem hat die hash map noch die Variable SIZE, diese wird bei der Initialisierung bestimmt und definiert die maximale Größe der internen Arrays.

Hash maps sind extrem schnell darin einen abgefragten Wert oder Schlüssel zurück zu geben.

Der Index an dem die key value Paare gespeichert werden werden bestimmt, indem man  den key hasht, und dieses Ergebnis % SIZE rechnet. Math.abs() sorgt lediglich dafür, dass man keine negativen Indexe erhält.

int index = Math.abs(key.hashCode() % this.SIZE);

Es ist sinnvoll eine HilfsMethode für das Errechnen des Index zu schreiben. 

Es kann passieren, dass zwei verschiedene keys den selben index generieren, dann muss ein neuer noch freier Index bestimmt werden.

### lineares Sondieren:

Falls der index schon belegt ist wird einfach der nächst höchste freie Index genommen.
Das führt dazu, dass bei der Suche in einer hash map nicht nur der durch den key generierte Index abgefragt werden darf, sondern dass auch noch die darüber liegenden Indexe, da es seien könnte, dass der gesuchte Wert da gespeichert werden musst.

Es reicht dabei, die höheren Indexe abzusuchen, die nicht null sind, sobald auf null getroffen wird kann die Suche abgebrochen werden.

![[Pasted image 20260218125110.png]]

### andere Lösungen:

Es gibt auch andere Ansätze Kollisionen zu verhindern, man kann beispielsweise bei einer Kollision eine [[verkettete Liste]] anlegen oder ähnliches.

