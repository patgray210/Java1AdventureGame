import java.util.Scanner;
public class AdventureGame{
	private static Monster monster;
	private static Potion healthPot;
	private static Scroll dmgScroll;
	private static int winCon = 0;
	//had to make it out of the main method so the use methods in the player class could use it
	public static Player hero = new Player("You", 100, 10, 25,null,null);
	//vars to make sure you can fight the monsters a bunch of times
	private static int didTheyBeatTheClosetMonster;
	private static int didTheyBeatTheKitchenMonster;
	private static int didTheyBeatTheBathroomMonster;
	//loop for combat
	public static boolean combat(){
		while(hero.getHealth()> 0 && monster.getHealth()>0){
			hero.takeTurn(monster);
			monster.takeTurn(hero);
			System.out.println("The hero's health is "+hero.getHealth());
			System.out.println("The hero's mana is "+hero.getMana());
			System.out.println("The opponents health is "+ monster.getHealth());
		}
		if(hero.getHealth()==0){
			System.out.println("You have died.");
		}else{
			System.out.printf("You defeated %s\nYou gain %d exp.\n",monster.getName(),monster.getXp());
			winCon += 1;
		}
		return false;
	}


	public static void main(String[] args){
		boolean playGame =true;
		Scanner input = new Scanner(System.in);
		Dungeon dung= new Dungeon();
		Room currentRoom = dung.getRoom0();
		//Win condition
		System.out.println("Find and beat all 3 monsters to win");
		
		while(playGame == true){
			//setting up the rooms and the movement system 
			dung.setRoom();
			Room nextRoom = null;
			System.out.println("You're in" +currentRoom);
			System.out.println("Which direction would you like to go? or would you like to quit");
			System.out.println("Enter N for North S for South E for East W for West or Q to quit");
			char whatToDo = input.next().charAt(0);
			if( whatToDo == 'n'){
				nextRoom = currentRoom.getNorth();
			}
			else if( whatToDo == 'e'){
				nextRoom = currentRoom.getEast();
				}
			else if(whatToDo == 'w'){
				nextRoom = currentRoom.getWest();
			}
			else if(whatToDo == 's'){
				nextRoom = currentRoom.getSouth();
			}
			
			else if(whatToDo == 'q'){
				System.out.println("Sorry cant do that find and beat up the monsters instead");
				}
			else{
				System.out.println("Something went wrong");
			}
			if(nextRoom != null){
				currentRoom = nextRoom;
			}
			if(winCon==3){
				playGame = false;
			}

			//setting monsters depending on the room and checking to see if you are in that room to start the fight
			//could be much cleaner and moved into other classes but in the interest of time was left as is
			if(currentRoom == dung.getBigBathroom() && didTheyBeatTheBathroomMonster==0){
				monster = new Monster("big bad bathroom bad guy", 30, 7, 15);		
				boolean combat = true;
		
				System.out.println("You encounter a vicious big bad bathroom bad guy and he attacks!!");
				while(combat){
				combat = combat();
				System.out.println("You find a Red Potion amoung the goop");
				hero.setPotions(1);
				didTheyBeatTheBathroomMonster +=1;
				}
			}
			if(currentRoom == dung.getWalkInCloset()&& didTheyBeatTheClosetMonster==0){
				monster = new Monster("creepy thing hiding in your clothes", 30, 7, 15);		
				boolean combat = true;
		
				System.out.println("You encounter a creepy thing hiding in your clothes and it attacks!!");
				while(combat){
				combat = combat();
				}
				didTheyBeatTheClosetMonster+=1;
			}
			if(currentRoom == dung.getKitchen()&& didTheyBeatTheKitchenMonster==0){
				monster = new Monster("the glutton ghost from ghostbusters", 1, 7, 15);		
				boolean combat = true;
		
				System.out.println("You encounter the glutton ghost from ghostbusters and it attacks!!");
				while(combat){
				combat = combat();
				System.out.println("He was weak but he has this strange scroll");
				hero.setScrolls(1);
				didTheyBeatTheKitchenMonster +=1;
				}

			}
			
			
		}
		System.out.println("Thanks for playing");
	
	}
	
}		
