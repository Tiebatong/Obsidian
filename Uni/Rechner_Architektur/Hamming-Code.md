
Es kann passieren, dass Bits flippen, dadurch wird der gespeicherte oder übertragene Wert falsch.
Um diese Fehler erkennen und korrigieren zu können nutzt man Redundanzbits.

Ein Codewort besteht aus n Datenbits und k Redundanzbits, mit der Gesamtlänge n + k.
Die Menge aller gültigen Codeworte nennt man Code.


### Hamming-Distanz

#### Codeworte

Die Hamming-Distanz zweier Codewörter ist die Anzahl an Stellen, an denen die Codewörter sich unterscheiden.

bsp:

1100101
0100011
xoooxxo

Distanz = 3

#### Codes

Die Hamming-Distanz eines Codes ist die kleinste Hamming-Distanz zweier beliebiger Codeworte des Codes


### Erkennung / Korrektur

Es können c-bit Fehler erkannt werden, wenn die Hamming-Distanz = c + 1.

Es können c-bit Fehler korrigiert werden, wenn die Hamming-Distanz = 2c + 1.

Wird ein Fehler erkannt ist klar, dass auch ein Fehler vorliegt, wird kein Fehler erkannt ist nur unwahrscheinlich, dass kein Fahler passiert ist.


![[Pasted image 20260326124352.png]]


Beispiel:

Es soll ein Code mit 3 bit Codewörtern und gerader Parität erstellt werden.

Alle 2 bit Codewörter: 00, 01, 10, 11

Paritätsbit hinzufügen: 000, 011, 101, 110

Alle gültigen Worte des Codes: 000, 011, 101, 110

#### zweidimensionale Parität

![[Pasted image 20260326125212.png]]
