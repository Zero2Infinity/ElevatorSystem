package ElevatorSystem;

import ElevatorSystem.Parts.Elevator;
import ElevatorSystem.Request.Request;

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
        System.out.println(">>> " + name + ": started request: " + request.getName());
        if (request != null) {
			elevator.moveTo(request.getButton().getFloor());
            completed(request);
        }
    }

    private synchronized void completed(Request request) {
        System.out.println(">>> " + name + ": completed request: " + request.getName());
        this.elevator.setCurrState(Elevator.STATE.IDLE);
    }

}
