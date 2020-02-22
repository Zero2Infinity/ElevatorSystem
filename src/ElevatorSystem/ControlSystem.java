package ElevatorSystem;

import ElevatorSystem.Parts.Elevator;
import ElevatorSystem.Request.Request;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Building.IBuilding;

public class ControlSystem implements Runnable {
	private Queue<Request> requestQueue = new LinkedList<>();
	private List<ElevatorController> elevatorControllers;
	private ExecutorService pool;
	private static boolean running;

	public ControlSystem(IBuilding building) {
		int totalElevators = building.getNumberOfElevators();
		int totalFloors = building.getNumberOfFloors();

		pool = Executors.newFixedThreadPool(totalElevators); // Thread pool
        elevatorControllers = new ArrayList<>(totalElevators); // Build elevators and assigned it to each controller
		 for (int i = 1; i <= totalElevators; i++) {
		 	ElevatorController ec = new ElevatorController("EC_" + i, new Elevator(i, totalFloors));
			elevatorControllers.add(ec);
		 }
	}

	public void start() {
		Thread t = new Thread(this, "Control System");
		System.out.println("initializing...."); sleep(1000);
		t.start();
	}

	public void callRequest(Request request) {
		// System.out.println("> set call request: " + request.name);
		requestQueue.add(request);
	}

	@Override
	public void run() {
		running = true;
		while(running) {
		    if (!requestQueue.isEmpty()) {
		    	Request request = requestQueue.poll();
				System.out.println("> received call request: " + request.getName());
		    	Runnable runnable = waitForNextEC(request);
		    	pool.execute(runnable);
			} else {
				System.out.println("waiting for next request");
				sleep(1000);
			}
		}
	}

	public synchronized void stop() {
	    System.out.println("Stopping Elevator System");
		sleep(500);
		if (requestQueue.isEmpty()) {
			running = false;
			pool.shutdown();
		}
	}

	private ElevatorController waitForNextEC(Request r) {
		ElevatorController ec = next();
	    while(ec == null)  {
	    	sleep(500);
	    	ec = waitForNextEC(r);
		}
	    ec.setRequest(r);
	    return ec;
	}
	// Consider round-robin scheduling algorithm but could apply any scheduling algorithm
	private synchronized ElevatorController next() {
        for (ElevatorController e : elevatorControllers) {
			if (e.isAvailable()) return e;
		}
        return null;
	}

	private void sleep(int milli) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}