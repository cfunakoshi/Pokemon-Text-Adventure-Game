package items;

public class Potion extends Item {
	private int points;
	
	public Potion() {
		super("Potion");
		this.points = 100;
	}
	
	public int getPointsLeft() {
		return points;
	}
	
	public int usePotion(int amount) {
		if(amount > points || amount < 0) {
			System.out.println("This potion does not have that amount");
			return 0;
		}
		else {
			System.out.println("Okay!");
			points = points - amount;
			return amount;
		}
	}
}
