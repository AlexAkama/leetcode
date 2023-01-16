package interview.hashcode_n_equals.points;

public class LoaderControl {

    public static void main(String[] args) {
        Point point = new Point(1, 2);
        Point colorPoint = new ColourPoint(1, 2, "red");

//        System.out.println(point.equals(colorPoint));
        System.out.println(colorPoint.equals(point));

//        System.out.println(colorPoint instanceof Point);
    }

}
