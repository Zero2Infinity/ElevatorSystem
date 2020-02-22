package ElevatorSystem.Components;

public class Door {

	enum STATE {
		OPEN, CLOSE
	}

	STATE status;

	public Door() {
		status = STATE.CLOSE;
	}

	public void open() {
		status = STATE.OPEN;
	}

	public void close() {
		status = STATE.CLOSE;
	}
}