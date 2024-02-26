package exercise;

// BEGIN
public interface Home extends Comparable<Home> {
    double getArea();
    default int compareTo(Home other) {
        return Double.compare(getArea(), other.getArea());
    }
}
// END
