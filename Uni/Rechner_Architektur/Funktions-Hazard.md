
Hazards entstehen, wenn eine Schaltung den Funktionswert kurzzeitig falsch ausgibt, aufrund von Verzögerungen in der Schaltung, dieser falsche Ausgabewert ist aber temporär.
Aufgrund dieser Hazards ist es nötig einen takt zu verwenden, und die Signale erst dann weiterzuverarbeiten, wenn ein falscher Wert durch einen Hazard ausgeschlossen ist.



### statischer Hazard

Das korrekte Ausgangssignal bleibt gleich, switcht aber kurzzeitig.
statischer 1-er Hazard von 1 zu 1
![[Pasted image 20260326113306.png]]

### dynamischer Hazard

Das korrekte Ausgangssignal wechselt, switcht aber kurzzeitig.
dynamischer 1-0-er Hazard von 1 zu 0
![[Pasted image 20260326113320.png]]


### Funktions-Hazard

Liegt in der Struktur der Funktion selbst, kann nicht durch anpassen der Schaltung vermieden werden. bsp. adder.

#### Erkennung

Struktur-Hazards kann man am [[KV Diagram]] erkennen.

![[Pasted image 20260326114457.png]]

Beide Funktionswerte sind = 1. Beim Wechsel geht das Signal allerdings über eine 0, also liegt ein statische 1-Hazard vor.
Es werden sich alle möglichen Pfade angeguckt, über den der Funktionswechsel laufen kann, ein einziger Fehler reicht aus.

### Struktur-Hazard

Liegt in der umgesetzten Schaltung begründet, kann durch umbauen der Schaltung behoben werden.
#### Behebung

Bei der Umsetzung von [[KV Diagram]] zu einer Schaltung werden alle nicht Kernprimimplikanten weggelassen, da sich nicht nötig sind.
Wenn man die Primimplikanten wieder in die Schaltung hinzufügt werden die Hazards behoben. 

![[Pasted image 20260326115407.png]]

Der rot markierte Primimplikant ist zwar eigentlich nicht nötig, wird aber wieder in die Schaltung hinzugefügt, um den Hazard zu umgehen.