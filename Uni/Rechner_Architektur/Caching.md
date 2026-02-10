

Man prüft ob Daten im Cache vorhanden sind, 
falls ja -> Cache hit
falls nein -> Cache miss

Grundsätzlich muss immer das Valid Flag gesetzt sein, sonst ist der Eintrag nicht gültig. 

## Fully associative Cache

Nutzt [[Ersätzungsstartegie]]

Bei Cache Zugriff wird geguckt ob der Tag vorhanden ist, wenn ja -> Cache hit.
Dann wird das Byte des entsprechenden Wortes geladen.

![[Pasted image 20260209164905.png|725]]

## Direct maped Cache

Bei Cache Zugriff wird in die entsprechende LINE gegangen, dann wird geprüft ob TAG vorhanden ist wenn ja -> Cache hit.
Dann wird das Byte des entsprechenden Wortes geladen.

![[Pasted image 20260209170252.png|725]]


## n-Way set-Associative Cache

Nutzt [[Ersätzungsstartegie]]

Quasi mehrere associative Cahces nebeneinander

Bei Cache Zugriff wird erst in die LINE gegangen, dort werden die TAGS geprüft, falls TAG gefunden -> Cache hit.
Dann wird das Byte des entsprechenden Wortes geladen.

![[Pasted image 20260209170525.png|725]]

