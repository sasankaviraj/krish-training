public class Meal {

    private final String refreshment;
    private final String rice;
    private final String dessert;
    private final String shortEat;

    public Meal(Builder builder) {
        this.refreshment = builder.refreshment;
        this.shortEat = builder.shortEat;;
        this.dessert = builder.dessert;;
        this.rice = builder.rice;
    }

    public static class Builder{
        private String refreshment;
        private String rice;
        private String dessert;
        private String shortEat;

        public Builder() {
        }

        public Meal build(){
            return new Meal(this);
        }

        public Builder refreshment(String refreshment){
            this.refreshment = refreshment;
            return this;
        }

        public Builder rice(String rice){
            this.rice = rice;
            return this;
        }

        public Builder dessert(String dessert){
            this.dessert = dessert;
            return this;
        }

        public Builder shortEat(String shortEat){
            this.shortEat = shortEat;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Meal{" +
                "refreshment='" + refreshment + '\'' +
                ", rice='" + rice + '\'' +
                ", dessert='" + dessert + '\'' +
                ", shortEat='" + shortEat + '\'' +
                '}';
    }
}
