package parking;

public class FloorThree extends Floor{
    @Override
    protected void createFloor() {
        vehicleList.add(new MotorBike());
        vehicleList.add(new ThreeWheeler());
    }
}
