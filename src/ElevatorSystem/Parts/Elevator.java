package ElevatorSystem.Components;

import ElevatorSystem.Components.Button.ElevatorButton;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

	public enum STATE {
		IDLE, REQUESTED, OPEN, RUNNING
	}

	public int id;
	Door door;
	List<ElevatorButton> floorButtons;
	STATE currState;
	int currFloor;
	boolean isLoaded; 	// is loaded with passengers

	public Elevator(int id, int totalFloors) {
		floorButtons = new ArrayList<>(totalFloors);
		for (int i = 0; i < totalFloors; i++) {
			this.floorButtons.add(new ElevatorButton(i));
		}
		this.id = id;
		this.currState = STATE.IDLE;
		this.door = new Door();
		this.currFloor = 1;
		this.isLoaded = false;
	}

	public void setFloorButtons(List<ElevatorButton> buttons) {
		this.floorButtons = buttons;
	}

	public STATE getCurrState() {
		return currState;
	}

	public void setCurrState(STATE currentState) {
		this.currState = currentState;
	}

	public void moveTo(boolean isLoaded, int to) {
		this.currState = STATE.RUNNING;
		if (currFloor == to) {
			open();
			// if (isLoaded == true) unload(); else load();
			close();
		} else {
			System.out.println(">>>> move elevator(" + id + ") from: " + currFloor + " to: " + to);
			open();
			// if (isLoaded == true) unload(); else load();
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

	private void unload() {
		System.out.println(">>>> unloading passengers");
	}

	private void load() {
		System.out.println(">>>> loading passengers");
	}
}