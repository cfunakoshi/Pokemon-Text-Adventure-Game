import java.util.*;
import java.util.Random;

import location.*;
import people.*;
import items.*;

public class Command {
	
	public Command() {
	}
	
	public void help(Location location) {
		if(location.hasTrainer()) {
			System.out.println("Here are your options: " + "\n" + "w: Move North" + "\n" + "a: Move West" + "\n" + "s: Move South" + "\n" + "d: Move East" + "\n" + "search: Search for Items" + "\n" + "battle: Battle the Trainer" + "\n" + "exit: Exit Game");
		}
		else if(location.hasGym()) {
			System.out.println("Here are your options: " + "\n" + "w: Move North" + "\n" + "a: Move West" + "\n" + "s: Move South" + "\n" + "d: Move East" + "\n" + "search: Search for Items" + "\n"  + "enter: Enter the Gym and Battle the Gym Leader" + "\n" + "exit: Exit Game");
		}
		else {
			System.out.println("Here are your options: " + "\n" + "w: Move North" + "\n" + "a: Move West" + "\n" + "s: Move South" + "\n" + "d: Move East" + "\n" + "search: Search for Items" + "\n" + "exit: Exit Game" );
		}
	}
	
	public Location move(String input, Location location) {
		if(input.equals("w") && location.getNorth() != null) {
			return location.getNorth();
		}
		else if(input.equals("s") && location.getSouth() != null) {
			return location.getSouth();
		}
		else if(input.equals("a") && location.getWest() != null) {
			return location.getWest();
		}
		else if(input.equals("d") && location.getEast() != null) {
			return location.getEast();
		}
		else {
			System.out.println("That move is invalid. Choose again: ");
			return location;
		}
	}
	
	public void heal(int input, Trainer player) {
		if(player.getItemNames().contains("Potion")){
			Potion potion = (Potion) player.getItem("Potion");
			player.getPokemon().addHealth(potion.usePotion(30));
		}
		else {
			System.out.println("You have no potion!");
		}
	}
	
	public void battle(String input, Trainer player, Trainer trainer) {
		if( !player.getPokemon().getMoves().contains(input)) {
			System.out.println("That move is invalid. Choose again: ");
		}
		else {
			//Opponents pokemon move list will pick at random
			Set<String> moves = new HashSet<String>();
			moves = trainer.getPokemon().getMoves();
			List<String> op = new ArrayList<String>(moves); 
			Random rand = new Random();
			
			trainer.getPokemon().subtractHealth(player.getPokemon().attack(input));
			System.out.println("You attack " + trainer.getPokemon().getName() + ". " + trainer.getPokemon().getName() + " has " + trainer.getPokemon().getHealth() + " health left.");
			player.getPokemon().subtractHealth(trainer.getPokemon().attack(op.get(rand.nextInt(op.size()))));
			System.out.println(trainer.getPokemon().getName() + " attacks " + player.getPokemon().getName() + ". " + player.getPokemon().getName() + " has " + player.getPokemon().getHealth() + " health left.");
		}
	}
	
	public void search(Location location) {
		if(location.getItems().size() == 0 && location.hasTrainer() == false) {
			System.out.println("There is nothing here.");
		}
		else if(location.hasTrainer() == true) {
			System.out.println("There is " + location.getItems() + " here.");
			System.out.println("The trainer " + location.getTrainer().getName() + " is here.");
		}
		else {
			System.out.println("There is " + location.getItems() + " here.");
		}
		
		if(location.hasGym()) {
			System.out.println(location.getGym().getName() + " is here.");
		}
	}
}
