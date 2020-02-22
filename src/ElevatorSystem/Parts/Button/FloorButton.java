package ElevatorSystem.Parts.Button;

public class FloorButton extends Button {

    private int sourceFloor;

    @Override
    protected Button create(int floor) {
        this.sourceFloor = floor;
        this.type = ButtonType.FLOOR;
        this.light = ButtonLight.OFF;
        return this;
    }

	@Override
	public int getFloor() {
		return sourceFloor;
	}

}