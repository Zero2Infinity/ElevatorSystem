package ElevatorSystem.Components.Button;

public class ElevatorButton extends Button {

    public int destinationFloor;

    public ElevatorButton(int floor) {
        this.destinationFloor = floor;
        this.type = Button.TYPE.ELEVATOR;
        this.lightStatus = Button.LIGHT.OFF;
    }

}