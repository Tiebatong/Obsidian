Das Internet wird in den *Kern* und den *Rand* aufgeteilt.

Die Host (Rand) werden über Zugangsnetzwerke (access network) mit dem Kern.
Die Komplexität des Internets liegt am Rand.

Komplizierte Dinge sollten am Rand des Internets berechnet werden, nicht im Kern, wo alle Routing-Entscheidungen möglichst einfach und schnell getroffen werden sollten.

Das Internet kann als network of networks verstanden werden, es gibt kein einzelnes großes Netz, es gibt viele einzelne miteinander verbundene Netze.

### 1.3

Die Nutzer am rand der Internets sind durch Zugangsnetzwerke mit dem Kern verbunden, der Kern selber ist allerdings kein homogenes Netzwerk.

*Routing* bezeichnet eine globale Aktion, bei der mithilfe eines Routing-Algorithmus ein Weg von der Quelle zum Ziel bestimmt wird.

Ein Paket der Größe *L* auf einer Leitung mit Bandbreite *R* hat eine Sendezeit (transmission delay) von L/R. ^40aa0d

#### packet switching

Nachrichten werden in Packages aufgeteilt, die einzeln verschickt werden, erst wenn das gesamte package beim Router/Switch angekommen ist kann es weitergesendet werden (store and forward). 
Dafür hat jeder Router/Switch eine *Forwarding Tabelle* die regelmäßig global neu berechnet und an die Router/Switches verteilt werden. Die Forwarding Tabelle weist jeder Zieladresse einen Ausgangslink zu.

Wenn die Rate mit der die Packages weitergeschickt werden größer ist, als die Rate mit der neue Packages ankommen füllt sich der Buffer, wenn dieser voll ist (Buffer Overflow) werden packages gelöscht, nicht alle Protokolle teilen das mit.

#### circuit switching

Hier wird jedem Sender einer ganze Leitung reserviert, Buffer overflow und Package loss sind hier kein Problem mehr, dafür werden die einzelnen Leitungen aber nur sehr selten tatsächlich genutzt, es ist also recht ineffizient.


### 1.4  Leistung: Verzögerung, Verlust und Durchsatz in Computernetzwerken

Delay meint hier immer Zeitdauer, nicht Verzögerung.

Kommt ein package bei einem Router an muss dieser die Zieladresse im Header nachgucken, die Zeit die dafür benötigt wird nennt man *processing delay*. 

Bevor der Router das Paket verschickt muss es in der output queue warten, diese Zeit nennt man *queuing delay*.
*a* = durchschnittliche Auslastung des Routers, *aL/R* = *queuing delay*.

*L/R* = *transmission delay* [[Kapitel 1#^40aa0d]] 

*d/v* = *propagation delay*, *d* = Länge des Links und *v* = Geschwindigkeit nach Beginn der Übertragung. Die Zeit die die Bits auf der Leitung brauchen.

Die Summe dieser 4 Delays ist die Gesamtzeit die ein Paket braucht um von Sender zu Empfänger zu kommen.

### 1.5 Protokollschichten

Das Internet wird in verschiedene Schichten (protocol layers) unterteilt.

Jede Schicht hat eigene Protokolle, die über Schnittstellen mit den darunter liegenden Schichten kommunizieren.

Dabei wird der Nachricht ein Header der tieferen Schicht vorangestellt, die Nachricht der höheren Schicht wird in eine Nachricht der tieferen Schicht verpackt (encapsulated).

Oben liegt der transport layer, in der Mitte liegt der network layer, hier werden datagrams von Sender zu Empfänger geroutet, darunter liegt der link layer (Sicherungsschicht), dieser Layer kümmert sich um den transport von frames zwischen benachbarten Knoten.

Ganz unten liegt dann die physische Schicht.