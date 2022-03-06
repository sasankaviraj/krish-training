import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<InstrumentName,Instrument> instruments = new HashMap<>();

    public Registry() {
        initialize();
    }

    public Instrument getInstrument(InstrumentName instrumentName){
        Instrument instrument = null;
        try {
            instrument = (Instrument) instruments.get(instrumentName).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return instrument;
    }

    private void initialize() {

        Piano piano = new Piano();
        piano.setMaterial("Marbel");
        piano.setNoOfKeys(88);
        piano.setInstrumentType("Chordophone");
        piano.setSize("Large");

        Guitar guitar = new Guitar();
        guitar.setGuitarType("Box");
        guitar.setNumberOfStrings(6);
        guitar.setInstrumentType("String");
        guitar.setSize("Medium");

        Violin violin = new Violin();
        violin.setBowType("Carbon Fiber");
        violin.setMaterial("Rosewood");
        violin.setInstrumentType("String");
        violin.setSize("Medium");

        Drum drum = new Drum();
        drum.setDrumType("Bass");
        drum.setInstrumentType("Percussion");
        drum.setMaterial("Wooden");
        drum.setSize("Medium");

        Flute flute = new Flute();
        flute.setHoles(6);
        flute.setLength(26);
        flute.setInstrumentType("Woodwind");
        flute.setSize("Small");

        instruments.put(InstrumentName.DRUM,drum);
        instruments.put(InstrumentName.GUITAR,guitar);
        instruments.put(InstrumentName.PIANO,piano);
        instruments.put(InstrumentName.VIOLIN,violin);
        instruments.put(InstrumentName.FLUTE,flute);
    }

}
