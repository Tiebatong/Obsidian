interface Sendable {
    // gibt den Absende-Standort zurück
    Location senderLocation();
    // gibt den Empfangs-Standort zurück
    Location receiverLocation();
    // gibt das Gewicht einer Sendung in Gramm (g) zurück
    double weight();
}
