package people;

import items.*;
import pokemon.*;

public class GymLeader extends Trainer {
	private Badge badge;
	private boolean badgeStatus;
	
	public GymLeader(String name, Pokemon p, Badge badge) {
		super(name, p);
		this.badge = badge;
		this.badgeStatus = true;
	}
	
	public Badge getBadge() {
		return badge;
	}
	
	public void lost() {
		badge = null;
	}
	
	public boolean hasBadge() {
		return badgeStatus;
	}
	
	public void takeBadge() {
		badgeStatus = false;
	}
}
