package pokemon;

import java.util.*;

public class Pokemon {
	private String name;
	private String type;
	private int health;
	private HashMap<String,Integer> moves = new HashMap<String,Integer>();
	
	public Pokemon(String name, String type) {
		this.name = name;
		this.type = type;
		this.health = 100;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void subtractHealth(int sub) {
		health = health - sub;
	}
	
	public void addHealth(int add) {
		health = health + add;
	}
	
	public void addMoves(String moveName, int moveValue ) {
		moves.put(moveName, moveValue);
	}
	
	public Set<String> getMoves() {
		return moves.keySet();
	}
	
	public int attack(String move) {
		return moves.get(move);
	}
}
