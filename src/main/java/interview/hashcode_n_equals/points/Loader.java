package interview.hashcode_n_equals.points;

public class Loader {

    public static void main(String[] args) {

        Point point0 = new ColourPoint(1, 2,"red");
        ColourPoint colourPoint0 = new ColourPoint(1, 2, "red");

        System.out.println("-- Pефлексивность --");
        System.out.println(point0.equals(point0));
        System.out.println(colourPoint0.equals(colourPoint0));
        System.out.println();

        Point point1 = new ColourPoint(1, 2,"red");
        ColourPoint colourPoint1 = new ColourPoint(1, 2, "red");

        System.out.println("-- Симметричность --");
        System.out.println(point0.equals(point1) + " " + point1.equals(point0));
        System.out.println(colourPoint0.equals(colourPoint1) + " " + colourPoint1.equals(colourPoint0));
        System.out.println();

        Point point2 = new ColourPoint(1, 2,"red");
        ColourPoint colourPoint2 = new ColourPoint(1, 2, "red");

        System.out.println("-- Транзитивность --");
        System.out.println(point0.equals(point1) + " " + point1.equals(point2) + " " + point0.equals(point2));
        System.out.println(colourPoint0.equals(colourPoint1) + " " + colourPoint1.equals(colourPoint2) + " " + colourPoint0.equals(colourPoint2));
        System.out.println();

        System.out.println("-- NULL --");
        System.out.println(point0.equals(null));
        System.out.println(point0.equals(null));

    }

}
