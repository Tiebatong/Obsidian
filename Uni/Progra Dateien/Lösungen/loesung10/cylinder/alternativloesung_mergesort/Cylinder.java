record Cylinder(double radius, double height) {
    double volume() {
        return Math.pow(radius, 2) * height * Math.PI;
    }
    
    private static void mergesort(Cylinder cylіnders[]) {
      mergesort(cylіnders, 0, cylіnders.length);

    }

    private static void mergesort(Cylinder cylinders[], int startIndex, int endIndex) {
        int size = endIndex - startIndex;
        if(size <= 1) {
            return;
        }
        int middleIndex = startIndex + size / 2;
        mergesort(cylinders, startIndex, middleIndex);
        mergesort(cylinders, middleIndex, endIndex);
        merge(cylinders, startIndex, middleIndex, endIndex);
    }

    private static void merge(Cylinder cylinders[], int start, int middle, int end) {
        int indexA = start;
        int indexB = middle;
        Cylinder[] merged = new Cylinder[end - start];
        int indexMerged = 0;

        while(indexA < middle || indexB < end) {
            if(indexA == middle) {
                merged[indexMerged] = cylinders[indexB];
                indexB++;
            } else if(indexB == end) {
                merged[indexMerged] = cylinders[indexA];
                indexA++;
            } else if(cylinders[indexB].volume() <= cylinders[indexA].volume()) {
                merged[indexMerged] = cylinders[indexB];
                indexB++;
            } else if(cylinders[indexA].volume() <= cylinders[indexB].volume()) {
                merged[indexMerged] = cylinders[indexA];
                indexA++;
            }
            indexMerged++;
        }

        for(int i = 0; i < merged.length; i++) {
            cylinders[start + i] = merged[i];
        }
    }

    static Cylinder[] sorted(Cylinder[] cylinders) {
        // Kopiere Zylinder in neues Array. Das neue Array wird sortiert, das alte bleibt unverändert.
        Cylinder[] sortedCylinders = new Cylinder[cylinders.length];
        for(int i = 0; i < cylinders.length; i++) {
            sortedCylinders[i] = java.util.Objects.requireNonNull(cylinders[i]);
        }

        // Merge Sort, basierend auf den Vorlesungsfolien

        mergesort(sortedCylinders);

        return sortedCylinders;
    }
}
