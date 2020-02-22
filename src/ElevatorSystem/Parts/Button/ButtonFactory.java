package ElevatorSystem.Parts.Button;

import ElevatorSystem.Parts.Button.Button.ButtonType;

public class ButtonFactory {
	
	public Button getButton(ButtonType t, int floor) {
		Button btn = null;
		switch (t) {
			case FLOOR: 
				btn = new FloorButton().create(floor);
				break;
			case ELEVATOR:
				btn = new ElevatorButton().create(floor);
				break;
		}
		
		return btn;
	}

}
