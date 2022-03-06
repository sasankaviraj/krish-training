public class Piano extends Instrument{

    private int noOfKeys;
    private String material;

    public int getNoOfKeys() {
        return noOfKeys;
    }

    public void setNoOfKeys(int noOfKeys) {
        this.noOfKeys = noOfKeys;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Piano{" +
                "noOfKeys=" + noOfKeys +
                ", material='" + material + '\'' +
                '}';
    }
}
