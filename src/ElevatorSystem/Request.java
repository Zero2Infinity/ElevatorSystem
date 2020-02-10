package ElevatorSystem;

import ElevatorSystem.Components.Button.ElevatorButton;
import ElevatorSystem.Components.Button.FloorButton;

public class Request {

	public enum CALL_TYPE {
		FLOOR, ELEVATOR
	}

	public String name;
	public CALL_TYPE type;
	public FloorButton floorButton;
	public ElevatorButton elevatorButton;

	public Request buildFloorCallRequest(String name, int floor) {
		Request request = new Request();
		request.name = name;
		request.type = CALL_TYPE.FLOOR;
		request.floorButton = new FloorButton(floor);

		return request;
	}

	public Request buildElevatorCallRequest(String name, int floor) {
		Request request = new Request();
		request.name = name;
		request.type = CALL_TYPE.ELEVATOR;
		request.elevatorButton = new ElevatorButton(floor);

		return request;
	}

}