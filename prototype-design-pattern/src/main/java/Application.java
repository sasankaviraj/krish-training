public class Application {

    public static void main(String[] args) {
        Registry registry = new Registry();

        Guitar guitar = (Guitar) registry.getInstrument(InstrumentName.GUITAR);
        System.out.println(guitar);

        guitar.setGuitarType("Classical");
        guitar.setNumberOfStrings(12);
        System.out.println(guitar);

        Guitar guitar1 = (Guitar) registry.getInstrument(InstrumentName.GUITAR);
        System.out.println(guitar1);

    }
}
