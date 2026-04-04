---
aliases:
  - Adder
  - adder
---

### half adder

Ein half adder hat nur 3 Eingänge, nämlich die beiden Operanden, der Carry in fehlt.
Die beiden Ausgänge für Ergebnis und Carry out bit sind wie beim full adder.

### full adder

Ein full adder hat 3 Eingänge und 2 Ausgänge.
Carry in und die beiden Operanden bits. Carry out und das Ergebnis bit.

### carry ripple adder

Besteht aus mehreren in reihe geschalteten full addern. 

das Carry out wird jeweils in des Carry in des nächsten adders geleitet, deswegen "ripple".
Das führt dazu, dass im schlimmsten Fall ein Carry vom ersten adder bis ganz zum letzten adder wandert, wodurch die Berechnungszeit sehr hoch wird, deswegen muss lange gewartet werden, bis das Ergebnis ausgelesen werden kann.

![[Pasted image 20260401131550.png]]
![[Pasted image 20260401131731.png]]
