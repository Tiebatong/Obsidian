
Die Overflow Flag wird in ALUs verwendet und ist nur bei der Verwendung vom [[2-er Komplement]] nötig. Beim Rechnen mit positiven Zahlen wird das [[Carry Flag]] genutzt.


Overflow entsteht dann, wenn:
	positiv + positiv = negativ
		Wenn ein Carry in den letzten [[Adder]] rein geht, er selber aber keinen raus gibt
	negativ + negativ = positiv
		Wenn aus dem letzten [[Adder]] ein Carry raus geht, aber keiner rein.

Das heisst also, dass man den Carry out des vorletzten [[Adder]]s und den Carry out des letzten [[Adder]] mit einem XOR Gatter verbinden kann um damit die [[Overflow Flag]] zu setzen.

![[Pasted image 20260208192500.png]]

