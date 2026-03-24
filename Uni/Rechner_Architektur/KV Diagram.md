KV Diagramme werden genutzt um die Anzahl von Logic Gates in einer Schaltung zu minimieren.

Man kann aus einer Wahrheitstabelle ein KV Diagram bilden, und aus dem Diagram wird dann eine Schaltung gebildet.

![[Pasted image 20260324200038.png]]


Jedes 1-Feld steht für einen Minterm, jedes 0-Feld steht für einen Maxterm

1-Blöcke oder 0-Blöcke der Größe 2^k können zusammengefasst werden.
Also Blöcke der Größe 1, 2, 4, 8 etc.

### Implikanten
![[Pasted image 20260324201345.png]]

Jeder Block ist ein Implikant, wenn der Block nicht mehr vergrößert werden kann ist ein ein Primimplikant, wenn der Primimplikant eine 1 abdeckt, die sonst von keinem anderen Primimplikant abgedeckt wird ist ein Kernprimimplikant.

![[Pasted image 20260324201706.png]]


+ Blau ist nur ein Implikant 0ter Ordnung, da der Block noch nach links oder nach oben vergrößert werden könnte.
+ Rot ist Primimplikant 2ter Ordnung, es ist kein Kernprimimplikant, da jede 1 auch von anderen Blöcken eingeschlossen werden könnte.
+ Grün ist ein Kernprimimplikant 1er Ordnung, da es eine 1 einschließt, die sonst von keinem anderen Block eingeschlossen wird, oder werden könnte.

