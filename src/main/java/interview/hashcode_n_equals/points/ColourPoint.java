package interview.hashcode_n_equals.points;

public class ColourPoint extends Point {

    private final String colour;

    public ColourPoint(int x, int y, String colour) {
        super(x, y);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColourPoint)) return false;

        ColourPoint other = (ColourPoint) o;

        return this.getX() == other.getX() &&
                this.getY() == other.getY() &&
                this.colour.equals(other.colour);
    }

}
