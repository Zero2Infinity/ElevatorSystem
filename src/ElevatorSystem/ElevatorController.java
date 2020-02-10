package ElevatorSystem;

import ElevatorSystem.Components.Elevator;

// This class knows how to operate elevator
public class ElevatorController implements Runnable {
    public String name;
    private Elevator elevator;
    private Request request;

    public ElevatorController(String n, Elevator e) {
        this.name = n;
        this.elevator = e;
    }

    public void setRequest(Request r) {
        this.request = r;
        this.elevator.setCurrState(Elevator.STATE.REQUESTED);
    }

    public boolean isAvailable() {
        return this.elevator.getCurrState() == Elevator.STATE.IDLE;
    }

    @Override
    public void run() {
        System.out.println(">>> " + name + ": started request: " + request.name);
        if (request != null) {
            if (request.type == Request.CALL_TYPE.FLOOR) {
                elevator.moveTo(false, request.floorButton.sourceFloor);
            } else if (request.type == Request.CALL_TYPE.ELEVATOR) {
                elevator.moveTo(true, request.elevatorButton.destinationFloor);
            }
            completed(request);
        }
    }

    private synchronized void completed(Request request) {
        System.out.println(">>> " + name + ": completed request: " + request.name);
        this.elevator.setCurrState(Elevator.STATE.IDLE);
    }

}
