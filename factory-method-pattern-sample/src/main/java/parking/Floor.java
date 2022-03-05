package parking;

import java.util.ArrayList;
import java.util.List;

public abstract class Floor {

    protected List<Vehicle> vehicleList = new ArrayList<>();

    public Floor() {
        createFloor();
    }

    protected abstract void createFloor();

    @Override
    public String toString() {
        return "Floor{" +
                "vehicleList=" + vehicleList +
                '}';
    }
}
