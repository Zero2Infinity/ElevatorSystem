import ElevatorSystem.ControlSystem;
import ElevatorSystem.Request;

public class Solution {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Design Elevator System");

		/**
		 * Use Cases:
		 * 1) User presses a given floor button to summon available elevator, so that he can ride to his destination floor.
		 *
		 * 2) User makes a request to take elevator to his destination floor, so that he can quickly reach to his office.
		 *
		 */

		Building buildingInfo = new Building();
		ControlSystem cs = new ControlSystem(buildingInfo);
		cs.start();

		Request call_1 = new Request().buildFloorCallRequest("floor_call_1", 1);
		cs.callRequest(call_1);

		Request call_2 = new Request().buildFloorCallRequest("floor_call_2", 5);
		cs.callRequest(call_2);

		Request call_3 = new Request().buildFloorCallRequest("floor_call_3", 2);
		cs.callRequest(call_3);

		Request call_4 = new Request().buildFloorCallRequest("floor_call_4", 3);
		cs.callRequest(call_4);


		Request call_5 = new Request().buildElevatorCallRequest("elevator_call_5", 5);
		cs.callRequest(call_5);

		Request call_6 = new Request().buildElevatorCallRequest("elevator_call_6", 2);
		cs.callRequest(call_6);
	}
}
