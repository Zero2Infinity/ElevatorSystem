import ElevatorSystem.IBuilding;

public class Building implements IBuilding {
    public static final int totalFloors = 5;
	public static final int totalElevators = 4;

	@Override
	public int getNumberOfElevators() {
	    return totalElevators;
	}

	@Override
	public int getNumberOfFloors() {
	    return totalFloors;
	}
}
