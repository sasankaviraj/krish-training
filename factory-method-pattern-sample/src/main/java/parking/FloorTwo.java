package parking;

public class FloorTwo extends Floor{
    @Override
    protected void createFloor() {
        vehicleList.add(new Car());
        vehicleList.add(new Van());
        vehicleList.add(new Jeep());
    }
}
