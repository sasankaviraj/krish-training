public class Flute extends Instrument{

    private int holes;
    private double length;

    public int getHoles() {
        return holes;
    }

    public void setHoles(int holes) {
        this.holes = holes;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Flute{" +
                "holes=" + holes +
                ", length=" + length +
                '}';
    }
}
