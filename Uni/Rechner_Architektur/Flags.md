
Flags werden genutzt um später gewisse Fehler zu überprüfen, oder um Sprungbedingungen abzufragen.

![[Pasted image 20260307160734.png]]

F0 = [[Carry Flag]], wird gesetzt, wenn ein Übertrag aus dem Wertebereich hinausgeht, das Ergebnis ist nicht mehr akkurat, wenn das Carry Flag gesetzt ist.

F1 = Overflow Flag, wird gesetzt, wenn einer der beiden letzten C*out* gesetzt ist (exklusiv also XOR):

F2 = nichts

F3 = Zero Flag, wird gesetzt, wenn alle Ausgänge = 0 sind, wird mit NOR umgesetzt. Diese Flag wird bei Sprüngen abgrefragt.