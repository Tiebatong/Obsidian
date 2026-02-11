public class Newton {

    public static void main(String[] args) {
        if (args.length = 0) {
            System.out.println("ERROR: keine Argumente übergeben")
            return;
        }

        if (c <= 0) {
            System.out.println("ERROR: kann keine Wurzel aus negativen Zahlen ziehen");
        }

        double c = Integer.parseInt(args[1]);

        while (Math.abs(t * t - c) < 0.0001) {
            double t = c;
            t = t + (c / t) / 2;
        }

        System.out.println(t);
    }
    
}
