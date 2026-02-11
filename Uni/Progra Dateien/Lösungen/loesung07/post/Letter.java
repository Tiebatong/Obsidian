class Letter implements Sendable {
    private final Location sender;
    private final Location receiver;

    Letter(Location sender, Location receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
    
    public Location senderLocation() {
        return sender;
    }
    
    public Location receiverLocation() {
        return receiver;
    }
    
    public double weight() {
        return 80;
    }
}
