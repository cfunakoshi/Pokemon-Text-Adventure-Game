import java.util.*;

import items.*;
import location.*;
import pokemon.*;
import people.*;

public class Driver {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean gameOver = false;
		
		//Create Pokemon objects
		Pokemon pikachu = new Pokemon("Pikachu", "Electric");
		Pokemon onix = new Pokemon("Onix", "Rock");
		Pokemon geodude = new Pokemon("Geodude", "Rock");
		Pokemon magikarp = new Pokemon("Magikarp", "Water");
		
		//Give Pokemon initial moves
		pikachu.addMoves("Thunderbolt", 30);
		pikachu.addMoves("Thunder", 50);
		onix.addMoves("Rock Throw", 40);
		onix.addMoves("Crunch", 30);
		onix.addMoves("Smash", 20);
		onix.addMoves("Tackle", 10);
		magikarp.addMoves("Splash", 0);
		magikarp.addMoves("Watergun", 25);
		magikarp.addMoves("Hyperbeam", 80);
		geodude.addMoves("Smash", 20);
		geodude.addMoves("Tackle", 10);
		
		//Create badges
		Badge badge1 = new Badge("Boulder Badge", "Rock");
		ArrayList<Badge> badgeList = new ArrayList<Badge>();
		badgeList.add(badge1);
		
		//Create items
		Potion potion1 = new Potion();
		
		//Create Trainers and Gym Leaders
		Trainer trainer1 = new Trainer("Fisherman", magikarp);
		GymLeader leader1 = new GymLeader("Brock", onix, badge1);
		
		Gym gym1 = new Gym("Boulder Gym", leader1);
		
		Location start = new Location("Hometown");
		Location area1 = new Location("Route 1", trainer1);
		Location area2 = new Location("Route 2");
		Location area3 = new Location("Pewter City", gym1);
		
		area2.addPokemon(geodude);
		area2.addItem("Potion", potion1);
		
		start.setNorth(area1);
		area1.setEast(area2);
		area2.setSouth(area3);
		area3.setWest(start);
		
		//Player of text adventure game
		Trainer player = new Trainer();
		player.takePokemon(pikachu);
		
		Location current = start;
		Command play = new Command();
		
		while(!gameOver) {
			System.out.println("----------------------------------------");
			System.out.println("You are in " + current.getName());
			System.out.println("What would you like to do? (type help for list of commands)");
			
			String input = in.nextLine();
			if(input.equals("help")) {
				play.help(current);
			}
			else if(current.hasTrainer() && input.equals("battle")) {				
				while(player.getPokemon().getHealth() > 0 && current.getTrainer().getPokemon().getHealth() > 0) {
					System.out.println(player.getPokemon().getMoves());
					System.out.println("Pick a move, or heal: ");
					input = in.nextLine();
					if(input == "heal") {
						System.out.println("Pick the amount you want to heal your pokemon by: " );
						int next = in.nextInt();
						play.heal(next, player);
					}
					else {
						play.battle(input, player, current.getTrainer());
					}
				}
				if(player.getPokemon().getHealth() <= 0) {
					System.out.println(player.getPokemon() + " has fainted! You lose.");
					gameOver = true;
				}
				else if(leader1.getPokemon().getHealth() <= 0) {
					System.out.println("You beat " + leader1.getName());
					player.addBadge(leader1.getBadge());
					leader1.lost();
				}
				else {
					System.out.println("You beat " + current.getTrainer().getName());
					current.trainerLost();
				}
			}
			else if(input.equals("enter")) {
				GymLeader currentleader = current.getGym().getGymLeader();
				System.out.println("Time to battle with " + currentleader.getName());				
				
				while(player.getPokemon().getHealth() > 0 && currentleader.getPokemon().getHealth() > 0) {			
					System.out.println(player.getPokemon().getMoves());
					System.out.println("Pick a move, or heal: ");
					input = in.nextLine();
					if(input == "heal") {
						System.out.println("Pick the amount you want to heal your pokemon by: " );
						int next = in.nextInt();
						play.heal(next, player);
					}
					else {
						play.battle(input, player, currentleader);
					}
				}
				if(player.getPokemon().getHealth() <= 0) {
					System.out.println(player.getPokemon() + " has fainted! You lose.");
					gameOver = true;
				}
				else {
					System.out.println("You beat " + currentleader.getName() + ". You win the " + currentleader.getBadge().getName());
					player.addBadge(currentleader.getBadge());
					currentleader.lost();
				}				
			}
			/*
			 * 
			 * Plan to add a method that allows players to catch random pokemon
			 * 
			 */
			//else if(current.hasPokemon() && input == "catch") {				
			//}
			else if(input.equals("search")) {
				play.search(current);
			}
			else if(input.equals("take")) {
					System.out.println("What item do you want?");
					input = in.nextLine();
					if(current.getItems().contains(input)) {
						player.addItem(input, current.takeItem(input));
					}
			}
			else if(input.equals("exit")) {
				gameOver = true;
			}
			else {
				current = play.move(input, current);
			}
			
			if(player.hasAllBadges(badgeList)) {
				System.out.println("You got all the badges... You win!");
				gameOver = true;
			}
		}
		in.close();
	}

}
