package parking;

public class FloorOne extends Floor{
    @Override
    protected void createFloor() {
        vehicleList.add(new Bus());
        vehicleList.add(new Truck());
    }
}
