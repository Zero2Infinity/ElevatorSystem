package ElevatorSystem.Parts.Button;

public abstract class Button {

	public enum ButtonType {
		FLOOR, ELEVATOR
	}

	public enum ButtonLight {
		ON, OFF
	}
	public ButtonType type;
	public ButtonLight light;
	
	protected abstract Button create(int floor);
	public abstract int getFloor();
	
}