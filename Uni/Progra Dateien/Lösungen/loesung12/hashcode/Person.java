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
        // return Objects.hash(this.name, objectAccessTimes);
        return Objects.hash(this.name); // es muss gelten a.equals(b) ⇒ a.hashCode() == b.hashCode(); da der hashCode von einer zusätzlichen Eigenschaft abhing, die unabhängig vom Namen ist, war diese Regel verletzt. Daher konnte es sein, dass 1. zwei eigentliche gleiche Objekte doppelt im Hashset waren und 2. gleiche Objekte nicht mehr im Hashset gefunden wurden, da sich ihr Hashwert (also der Index im internen Array) verändert hat.
    }
}
