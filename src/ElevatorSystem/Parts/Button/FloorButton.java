package ElevatorSystem.Components.Button;

public class FloorButton extends Button {

    public int sourceFloor;

    public FloorButton(int floor) {
        this.sourceFloor = floor;
        this.type = Button.TYPE.FLOOR;
        this.lightStatus = LIGHT.OFF;
    }

}