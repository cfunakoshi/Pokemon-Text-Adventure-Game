package people;

import java.util.*;

import items.*;
import pokemon.*;

public class Trainer {
	private String name;
	private Pokemon pokemon;
	private HashSet<Badge> badge = new HashSet<Badge>();
	private HashMap<String,Item> items;
	
	public Trainer() {
	}
	
	public Trainer(String name) {
		this.name = name;
	}
	
	public Trainer(String name, Pokemon p) {
		this.name = name;
		this.pokemon = p;
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem(String name) {
		return items.get(name);
	}
	
	public Set<String> getItemNames() {
		return items.keySet();
	}
	
	public void addItem(String name, Item item) {
		items.put(name, item);
	}
	
	public Pokemon getPokemon() {
		return pokemon;
	}
	
	public void takePokemon(Pokemon p) {
		pokemon = p;
	}
	
	public boolean hasAllBadges(ArrayList<Badge> list) {
		if(badge.size() == list.size()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addBadge(Badge b) {
		badge.add(b);
	}
}
