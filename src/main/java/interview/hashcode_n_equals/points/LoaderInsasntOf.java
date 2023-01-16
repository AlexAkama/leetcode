package interview.hashcode_n_equals.points;

public class LoaderInsasntOf {

    public static void main(String[] args) {

        Point point0 = new Point(1, 2);
        ColourPoint colourPoint0 = new ColourPoint(1, 2, "red");

        System.out.println(point0 instanceof Point);
        System.out.println(point0 instanceof ColourPoint);
        System.out.println(colourPoint0 instanceof Point);
        System.out.println(colourPoint0 instanceof ColourPoint);

        System.out.println();

        point0 = new ColourPoint(1, 2, "red");
        System.out.println(point0 instanceof Point);
        System.out.println(point0 instanceof ColourPoint);
        System.out.println(colourPoint0 instanceof Point);
        System.out.println(colourPoint0 instanceof ColourPoint);


    }

}
