package ElevatorSystem.Request;

import ElevatorSystem.Parts.Button.Button;
import ElevatorSystem.Parts.Button.ButtonFactory;
import ElevatorSystem.Parts.Button.Button.ButtonType;

public interface Request {

	public enum CallType {
		FLOOR, ELEVATOR
	}

	public Request build(String name, int floor);
	public String getName();
	public CallType getType();
	public Button getButton();
}