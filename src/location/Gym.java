package location;

import people.*;

public class Gym {
	private String name;
	private GymLeader gymleader;
	
	public Gym(String name, GymLeader gymleader) {
		this.name = name;
		this.gymleader = gymleader;
	}
	
	public String getName() {
		return name;
	}
	
	public GymLeader getGymLeader() {
		return gymleader;
	}
}
