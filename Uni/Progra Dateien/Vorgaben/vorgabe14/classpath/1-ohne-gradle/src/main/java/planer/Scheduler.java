package planer;

import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

class Scheduler {
    private final String[] names;
    private final double[] areaSharePerPerson;

    private final Random random = new Random();

    public Scheduler(String[] personsAndAreas) {
        if (personsAndAreas.length % 2 != 0) {
            throw new IllegalArgumentException("even number of Strings expected, containing pairs of names and area");
        }

        names = parseNames(personsAndAreas);
        int[] areaPerPerson = parseAreaPerPerson(personsAndAreas);

        int totalArea = Arrays.stream(areaPerPerson).sum();
        areaSharePerPerson = Arrays.stream(areaPerPerson).mapToDouble(areaOfPerson -> areaOfPerson / (double) totalArea).toArray();
    }

    private String[] parseNames(String[] personsAndAreas) {
        String[] parsedNames = new String[personsAndAreas.length / 2];
        for (int i = 0; i < personsAndAreas.length / 2; i++) {
            parsedNames[i] = personsAndAreas[2 * i];
        }
        return parsedNames;
    }

    private int[] parseAreaPerPerson(String[] personsAndAreas) {
        int[] areaPerPerson = new int[personsAndAreas.length / 2];
        for (int i = 0; i < personsAndAreas.length / 2; i++) {
            String areaString = personsAndAreas[2 * i + 1];
            try {
                areaPerPerson[i] = Integer.parseInt(areaString);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(areaString + " could not be parsed as area, integer expected");
            }
        }
        return areaPerPerson;
    }

    private int getWeeksForPerson(int personNumber, int numberOfWeeks) {
        return (int) (areaSharePerPerson[personNumber] * numberOfWeeks);
    }

    public SortedMap<Integer, String> assignNamesToWeeks(int numberOfWeeks) {
        if (numberOfWeeks < 0) {
            throw new IllegalArgumentException("number of weeks may not be negative");
        }

        SortedMap<Integer, String> assignment = assignFirstWeeks(numberOfWeeks);
        assignRemainingWeeks(numberOfWeeks, assignment);
        return assignment;
    }

    private SortedMap<Integer, String> assignFirstWeeks(int numberOfWeeks) {
        SortedMap<Integer, String> assignment = new TreeMap<Integer, String>();

        int nextWeekNumber = 1;
        for (int personNumber = 0; personNumber < names.length; personNumber++) {
            for (int weekOfPerson = 0; weekOfPerson < getWeeksForPerson(personNumber, numberOfWeeks); weekOfPerson++) {
                String name = names[personNumber];
                assignment.put(nextWeekNumber, name);
                nextWeekNumber++;
            }
        }

        return assignment;
    }

    private void assignRemainingWeeks(int numberOfWeeks, SortedMap<Integer, String> assignment) {
        int nextWeekNumber = assignment.size() + 1;
        int nextPersonIndex = random.nextInt(names.length);
        while (nextWeekNumber <= numberOfWeeks) {
            assignment.put(nextWeekNumber, names[nextPersonIndex % names.length] + " (Pech gehabt)");
            nextWeekNumber++;
            nextPersonIndex++;
        }
    }
}
