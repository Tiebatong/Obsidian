
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



### Hamming Code

Hamming Codes sind die effizienteste Art Daten zu sichern.

Das *i*te Prüfbit steht an der Position 2^i - 1. Also 1, 2, 4, 8, 16...

#### Erstellung

Beispiel mit gerader Parität:
![[Pasted image 20260328133855.png]]

An den Stellen mit 2er Potenzen, hier 1, 2, 4 werden die Prüfbits geschrieben.
Um die Prüfbits auszurechnen werden sich alle Stellen angeguckt, an denen das bit an der Prüfbit Position gesetzt ist. An der Position 1 ist das erste (rechte) bit gesetzt, also wird die gerade Parität über alle bits bei deren Position das erste bit gesetzt ist.

#### Überprüfung

Bei der Überprüfung werden zuerst die Prüfbits ausgerechnet und vermerkt ob die tatsächlichen Prüfbits korrekt sind. Falls ein Fehler gefunden wurde werden die Positionen der fehlerhaften Prüfbits addiert, an dieser Position steht dann das fehlerhafte bit.

bsp:

![[Pasted image 20260328135206.png]]

Die Prüfbits 1 und 4 sind fehlerhaft, also ist das bit an der Position 1 + 4 das fehlerhafte Datenbit. 
