public class Violin extends Instrument{

    private String material;
    private String bowType;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBowType() {
        return bowType;
    }

    public void setBowType(String bowType) {
        this.bowType = bowType;
    }

    @Override
    public String toString() {
        return "Violin{" +
                "material='" + material + '\'' +
                ", bowType='" + bowType + '\'' +
                '}';
    }
}
