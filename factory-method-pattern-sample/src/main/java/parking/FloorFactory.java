package parking;

public class FloorFactory {

    public static Floor createFloor(FloorNumber floorNumber){
        switch (floorNumber){
            case FLOOR_ONE:
                return new FloorOne();
            case FLOOR_TWO:
                return new FloorTwo();
            case FLOOR_THREE:
                return new FloorThree();
            default:
                return null;
        }
    }
}
