package uz.elmurodov.security.organization;

/**
 * @author Nodirbek Jureav, Wed 7:13 PM. 1/19/2022
 */
public class Point extends org.postgresql.geometric.PGpoint {
    public Point(double x, double y) {
        super(x, y);
    }
}
