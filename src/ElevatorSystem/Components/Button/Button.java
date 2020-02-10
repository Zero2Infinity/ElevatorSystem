package ElevatorSystem.Components.Button;

public abstract class Button {

	public enum TYPE {
		FLOOR, ELEVATOR
	}

	public enum LIGHT {
		ON, OFF
	}

	public TYPE type;
	public LIGHT lightStatus;
}