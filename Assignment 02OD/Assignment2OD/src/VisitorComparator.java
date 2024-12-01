import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    /**
     * Compares two Visitor objects first by their names. If the names are identical,
     * it then compares them by their ages.
     *
     * @param v1 the first Visitor to compare
     * @param v2 the second Visitor to compare
     * @return a negative integer, zero, or a positive integer as the first Visitor
     *         is less than, equal to, or greater than the second Visitor
     */
    public int compare(Visitor v1, Visitor v2) {
        // First, compare the Visitors by their names
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            // If the names are not the same, return the result of the name comparison
            return nameComparison;
        }

        // If the names are identical, compare the Visitors by their ages
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
