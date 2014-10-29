 

import java.util.*;

/**
 *
 * @author DELL
 */
public class ArrayListOfObjects {

    public static void main(String[] args) {

        ArrayList<point> list = new ArrayList<point>();

        Set<point> set = new HashSet<point>();
        set.add(new point(2, 3, 4));
        set.add(new point(2, 3, 3));
        set.add(new point(2, 1, 3));
        set.add(new point(5, 1, 1));

        System.out.println(set.size());
        point[] df = set.toArray(new point[set.size()]);
 
        System.out.println(Arrays.toString(df));

        list.add(new point(2, 3, 4));
        list.add(new point(4, 3, 3));
        list.add(new point(1, 1, 3));
        list.add(new point(5, 1, 1));

        System.out.println(list.size());
        System.out.println(list.contains(new point(2, 3, 4)));

        point dff[] = list.toArray(new point[list.size()]);
        System.out.println(Arrays.toString(dff));

        Collections.sort(list, new Comparator<point>() {

            public int compare(point o1, point o2) {
                //return o2.getScores().get(0).compareTo(o1.getScores().get(0));
                int x1 = o1.x;
                int x2 = o2.x;
                if (x1 > x2) {
                    return 1;
                } else if (x1 < x2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        point dff2[] = list.toArray(new point[list.size()]);
        System.out.println(Arrays.toString(dff2));

    }
}

class point {

    int x;
    int y;
    int r;

    public point(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof point && ((point) o).x == this.x && ((point) o).y == this.y) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.x;
        return hash;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}