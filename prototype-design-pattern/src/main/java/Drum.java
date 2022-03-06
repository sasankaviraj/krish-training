public class Drum extends Instrument{
    private String drumType;
    private String material;

    public String getDrumType() {
        return drumType;
    }

    public void setDrumType(String drumType) {
        this.drumType = drumType;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Drum{" +
                "drumType='" + drumType + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
