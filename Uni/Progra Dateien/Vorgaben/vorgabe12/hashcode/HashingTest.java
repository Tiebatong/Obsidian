import java.util.Set;
import java.util.HashSet;

class HashingTest {

    static void main() {
        Person[] personen = {
            new Person("Lian"),
            new Person("Niklas"),
            new Person("Kata"),
            new Person("Markus"),
            new Person("Mareike"),
            new Person("Kim"),
        };
        
        Set<Person> set = new HashSet<Person>();
        
        for(Person p: personen) {
            System.out.println(set.contains(p)); // sollte immer false sein
            set.add(p);
            System.out.println(set);
            System.out.println(set.contains(p)); // sollte immer true sein
            System.out.println(set.contains(new Person(p.name()))); // sollte immer true sein (zwei Personen sind gleich, wenn ihr Name gleich ist)
            System.out.println("--");
        }
        
        System.out.println(set.contains(personen[0])); // sollte immer noch true sein
        set.add(personen[0]);
        System.out.println(set); // sollte sich nicht verändert haben, da Lian schon im Hashset ist
        
        for(Person p: personen) {
            System.out.print(set.contains(p) + " "); // sollte immer noch true sein
        }
    }

}
