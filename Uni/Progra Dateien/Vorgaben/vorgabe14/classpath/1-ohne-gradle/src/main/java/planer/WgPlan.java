package planer;

import java.util.Arrays;
import java.util.SortedMap;

import static planer.PdfWriter.writeToPdf;

public class WgPlan {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.err.println("Falsche Argumente, erwartet: dateiname.pdf anzahl_wochen person1 quadratmeter_person1 person2 quadratmeter_person2 ...");
            return;
        }
        String outputFilename = args[0];
        int numberOfWeeks = Integer.parseInt(args[1]);

        String[] personsAndAreas = Arrays.stream(args).skip(2).toArray(String[]::new);
        Scheduler scheduler = new Scheduler(personsAndAreas);
        SortedMap<Integer, String> personsPerWeek = scheduler.assignNamesToWeeks(numberOfWeeks);

        writeToPdf(outputFilename, personsPerWeek);
    }

}
