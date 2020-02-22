package ElevatorSystem.Parts;

import java.util.ArrayList;
import java.util.List;

import ElevatorSystem.Parts.Button.Button;
import ElevatorSystem.Parts.Button.ButtonFactory;
import ElevatorSystem.Parts.Button.ElevatorButton;
import ElevatorSystem.Parts.Button.Button.ButtonType;

public class Elevator {

	public enum STATE {
		IDLE, REQUESTED, OPEN, RUNNING
	}

	public int id;
	private Door door;
	private List<Button> floorButtons;
	private STATE currState;
	private int currFloor;
	private boolean isLoaded; 	// is loaded with passengers

	public Elevator(int id, int totalFloors) {
		floorButtons = new ArrayList<>(totalFloors);
		for (int i = 0; i < totalFloors; i++) {
			this.floorButtons.add(new ButtonFactory().getButton(ButtonType.FLOOR, i));
			
		}
		this.id = id;
		this.currState = STATE.IDLE;
		this.door = new Door();
		this.currFloor = 1;
		this.isLoaded = false;
	}

	public void setFloorButtons(List<Button> buttons) {
		this.floorButtons = buttons;
	}

	public STATE getCurrState() {
		return currState;
	}

	public void setCurrState(STATE currentState) {
		this.currState = currentState;
	}

	public void moveTo(int to) {
		this.currState = STATE.RUNNING;
		if (currFloor == to) {
			open();
			close();
		} else {
			System.out.println(">>>> move elevator(" + id + ") from: " + currFloor + " to: " + to);
			open();
			close();
			this.currFloor = to;
		}
		this.currState = STATE.IDLE;
	}

	private void open() {
		System.out.println(">>>> Elevator(" + id + ") open doors");
		currState = STATE.OPEN;
		door.open();
	}

	private void close() {
		System.out.println(">>>> Elevator(" + id + ") close doors");
		door.close();
	}

}