class Parcel implements Sendable {
    private final Location sender;
    private final Location receiver;
    private final double weight;

    Parcel(Location sender, Location receiver, double weight) {
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
    }
    
    public Location senderLocation() {
        return sender;
    }
    
    public Location receiverLocation() {
        return receiver;
    }
    
    public double weight() {
        return weight;
    }
}
