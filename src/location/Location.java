package location;

import java.util.*;

import items.Item;
import pokemon.*;
import people.*;

public class Location {
	private String name;
	private Location north;
	private Location south;
	private Location west;
	private Location east;
	private Gym gym;
	private HashMap<String,Item> items = new HashMap<String,Item>();
	private ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
	private Trainer trainer;
	
	public Location(String name) {
		this.name = name;
		this.gym = null;
	}
	
	public Location(String name, Trainer trainer) {
		this.name = name;
		this.trainer = trainer;
	}
	
	public Location(String name, Gym gym) {
		this.name = name;
		this.gym = gym;
	}
	
	public String getName() {
		return name;
	}
	
	public Gym getGym() {
		return gym;
	}
	
	public boolean hasGym() {
		if(gym != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Set<String> getItems() {
		return items.keySet();
	}
	
	public void addItem(String name, Item item) {
		items.put(name, item);
	}
	
	public Item takeItem(String item) {
		Item temp = items.get(item);
		items.remove(item);
		return temp;
	}
	
	public Collection<Pokemon> getPokemon() {
		return pokemon;
	}
	
	public boolean hasPokemon() {
		if(pokemon.size() != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addPokemon(Pokemon p) {
		pokemon.add(p);
	}
	
	public Trainer getTrainer() {
		return trainer;
	}
	
	public boolean hasTrainer() {
		if(trainer != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void trainerLost() {
		trainer = null;
	}
	
	public Location getNorth() {
		return north;
	}
	
	public void setNorth(Location location) {
		this.north = location;
		location.returnNorth(this);
	}
	
	public void returnNorth(Location location) {
		this.south = location;
	}
	
	public Location getSouth() {
		return south;
	}
	
	public void setSouth(Location location) {
		this.south = location;
		location.returnSouth(this);
	}
	
	public void returnSouth(Location location) {
		this.north = location;
	}
	
	public Location getWest() {
		return west;
	}
	
	public void setWest(Location location) {
		this.west = location;
		location.returnWest(this);
	}
	
	public void returnWest(Location location) {
		this.east = location;
	}
	
	public Location getEast() {
		return east;
	}
	
	public void setEast(Location location) {
		this.east = location;
		location.returnEast(this);
	}
	
	public void returnEast(Location location) {
		this.west = location;
	}
}
