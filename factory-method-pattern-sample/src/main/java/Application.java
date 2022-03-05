import parking.Floor;
import parking.FloorFactory;
import parking.FloorNumber;

public class Application {

    public static void main(String[] args) {
        Floor floor1 = FloorFactory.createFloor(FloorNumber.FLOOR_ONE);
        System.out.println(floor1);

        Floor floor2 = FloorFactory.createFloor(FloorNumber.FLOOR_TWO);
        System.out.println(floor2);

        Floor floor3 = FloorFactory.createFloor(FloorNumber.FLOOR_THREE);
        System.out.println(floor3);
    }
}
