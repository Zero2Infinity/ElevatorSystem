package ElevatorSystem.Request;

import ElevatorSystem.Request.Request.CallType;

public class RequestFactory {
	public Request buildRequest(CallType type) {
		Request r = null;
		switch (type) {
			case FLOOR:
				r = new FloorCallRequest();
				break;
			case ELEVATOR:
				r = new ElevatorCallRequest();
				break;
		}
		return r;
	}
}
