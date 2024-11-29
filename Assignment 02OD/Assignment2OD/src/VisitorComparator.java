import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    public int compare(Visitor v1, Visitor v2) {
        // Compare by name first
        int nameCompare = v1.getName().compareTo(v2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }

        // If names are equal, compare by age
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
