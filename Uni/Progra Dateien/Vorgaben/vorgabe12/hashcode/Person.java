import java.util.Objects;

final class Person {
    private final String name;
    private long objectAccessTimes = 0;

    Person(String name) {
        this.name = Objects.requireNonNull(name);
        this.objectAccessTimes++;
    }
    
    String name() {
        return name;
    }
    
    @Override
    public String toString() {
        this.objectAccessTimes++;
        return "Person: %s".formatted(name);
    }
    
    @Override
    public boolean equals(Object other) {
        this.objectAccessTimes++;
        if(!(other instanceof Person otherPerson)) {
            return false;
        }
        return this.name.equals(otherPerson.name);
    }

    @Override
    public int hashCode() {
        this.objectAccessTimes++;
        return Objects.hash(this.name, objectAccessTimes);
    }
}
