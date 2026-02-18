Teilt ein unsortiertes Array rekursiv in TeilArrays auf, bis die TeilArrays nur noch aus einem Element bestehen, dann werden wieder 2 benachbarte TeilArrays miteinander verglichen uns sortiert.![[Pasted image 20260218142456.png|425]]  

Das Array wird mit Hilfe von 2 Hilfsmethoden  in eine erste und eine zweite Hälfte aufgeteilt, das wird so lange gemacht, bis die Länge == 1. Dann hat man quasi 2 sortierte Arrays, diese werden dann sortiert zusammengefügt. Dadurch erhält man ein sortiertes Array mit Länge = 2, diese 2-er Arrays werden jetzt wieder mit einander verglichen und zusammengefügt, bis das ganze Array sortiert ist.


![[Pasted image 20260218143529.png|383]]

Die merge Methode funktioniert indem sie 2 bereits sortierte Arrays mit einander vergleicht und ein neues Array erstellt.  Dabei werden die jeweiligen Elemente der beiden Arrays verglichen und das kleinere wird in das neue Array gespeichert. Wenn eins der beiden Arrays leer ist wird das gesamte andere Array ans neue dran gehangen.

![[Pasted image 20260218143837.png]]
