package ElevatorSystem.Request;

import ElevatorSystem.Parts.Button.Button;
import ElevatorSystem.Parts.Button.ButtonFactory;
import ElevatorSystem.Parts.Button.Button.ButtonType;

public class FloorCallRequest implements Request {

	private String name;
	private CallType type;
	private Button button;
	private ButtonFactory buttonFactory = new ButtonFactory();

	@Override
	public Request build(String name, int floor) {
		FloorCallRequest request = new FloorCallRequest();
		request.name = name;
		request.type = CallType.FLOOR;
		request.button = buttonFactory.getButton(ButtonType.FLOOR, floor);
		return request;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public CallType getType() {
		return type;
	}

	@Override
	public Button getButton() {
		return button;
	}



}
