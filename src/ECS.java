import Building.Building;
import Building.IBuilding;
import ElevatorSystem.ControlSystem;
import ElevatorSystem.Request.RequestFactory;
import ElevatorSystem.Request.Request;
import ElevatorSystem.Request.Request.CallType;

public class ECS {

	private final IBuilding buildingInfo;
	private final ControlSystem cs;
	private final RequestFactory requestFactory = new RequestFactory();

	public ECS() {
		System.out.println("Design Elevator System");
		buildingInfo = new Building();
		cs = new ControlSystem(buildingInfo);
	}

	public void userRequests() {
		cs.start();

		Request call_1 = requestFactory.buildRequest(CallType.FLOOR).build("floor_call_1", 1);
		cs.callRequest(call_1);

		Request call_2 = requestFactory.buildRequest(CallType.FLOOR).build("floor_call_2", 5);
		cs.callRequest(call_2);

		Request call_3 = requestFactory.buildRequest(CallType.FLOOR).build("floor_call_3", 2);
		cs.callRequest(call_3);

		Request call_4 = requestFactory.buildRequest(CallType.FLOOR).build("floor_call_4", 3);
		cs.callRequest(call_4);


		Request call_5 = requestFactory.buildRequest(CallType.ELEVATOR).build("elevator_call_5", 5);
		cs.callRequest(call_5);

		Request call_6 = requestFactory.buildRequest(CallType.ELEVATOR).build("elevator_call_6", 2);
		cs.callRequest(call_6);

	}

	public static void main(String[] args) throws InterruptedException {

		/**
		 * Use Cases:
		 * 1) User presses a given floor button to summon available elevator, so that he can ride to his destination floor.
		 *
		 * 2) User makes a request to take elevator to his destination floor, so that he can quickly reach to his office.
		 *
		 */
			new ECS().userRequests();
		}
}
