public class Resistors {

    public static void main(String[] args) {
        SingleResistor r1 = new SingleResistor(100);
        SingleResistor r2 = new SingleResistor(200);
        SingleResistor r3 = new SingleResistor(300);
        SingleResistor r4 = new SingleResistor(400);
        SingleResistor r5 = new SingleResistor(500);
        SingleResistor r6 = new SingleResistor(600);
        SingleResistor r7 = new SingleResistor(700);
        
        ParallelCircuit r23 = new ParallelCircuit(r2, r3);
        SeriesCircuit r123 = new SeriesCircuit(r1, r23);
        
        ParallelCircuit r45 = new ParallelCircuit(r4, r5);
        SeriesCircuit r456 = new SeriesCircuit(r45, r6);
        
        ParallelCircuit r123456 = new ParallelCircuit(r123, r456);
        
        SeriesCircuit r1234567 = new SeriesCircuit(r123456, r7);
        
        System.out.println(r1234567.resistance());
        System.out.println(r1234567.resistorCount());
    }

}
