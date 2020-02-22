package ElevatorSystem.Parts.Button;

public class ElevatorButton extends Button {

    private int destinationFloor;

    @Override
    protected Button create(int floor) {
        this.destinationFloor = floor;
        this.type = ButtonType.ELEVATOR;
        this.light = ButtonLight.OFF;
        return this;
    }

	@Override
	public int getFloor() {
		return destinationFloor;
	}

}