class Delivery {
    private Sendable[] sendables;
    
    Delivery(Sendable[] sendables) {
        java.util.Objects.requireNonNull(sendables);
        for(Sendable s: sendables) {
            java.util.Objects.requireNonNull(s);
        }
        this.sendables = sendables.clone();
    }
    
    Delivery(Sendable sendable) {
        java.util.Objects.requireNonNull(sendable);
        this.sendables = new Sendable[]{sendable};
    }

    private static int postage(Sendable sendable) {
        int countryPostage = 0;
        if(!sendable.senderLocation().country().equals(sendable.receiverLocation().country())) {
            countryPostage = 1;
        }
        if(sendable.weight() < 100) {
            return 1 + countryPostage;
        }
        return 2 + countryPostage;
    }
    
    int postage() {
        int postage = 0;
        for(Sendable sendable: sendables) {
            postage += postage(sendable);
        }
        return postage;
    }
}
