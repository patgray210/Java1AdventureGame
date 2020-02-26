import java.util.Scanner; 
public class Player extends GameCharacter{
	private int mana;
	private Potion potions;
	private Scroll scrolls;
	Player(String name, int health, int attackPower, int mana,Potion potions, Scroll scrolls){
		super(name,health,attackPower);
		this.potions=potions;
		this.mana=mana;
		this.scrolls=scrolls;
	}
		public void attack(Monster theMonster){
			theMonster.takeDamage(getAttackPower());
		}
		public void castSpell(Monster theMonster){
			if(this.mana>=10){
				theMonster.takeDamage(getAttackPower()*2);
				this.mana = this.mana - 10;
			}
			else{
				System.out.println("OOM");
			}
		}
		public  void chargeMana(){
			this.mana += 20;

		}
		public int getMana(){
			return this.mana;
		}
		public Potion getPotions(){
			return this.potions;
		}
		public Scroll getScrolls(){
			return this.scrolls;
		}
		public void setScrolls(int amount){
			
			Scroll dmgScroll = new Scroll("Scroll of dealing big numbers to bad things", 10000); 
			this.scrolls= dmgScroll;
		}
		public void setPotions(int amount){
			Potion healthPot = new Potion("Health potion", 15);
			this.potions=healthPot;
		}
		public void takeTurn(Monster theMonster){
			System.out.println("What do you want to do?");
			System.out.println("Enter 1 to attack, 2 to cast fireball, 3 to charge your mana, 4 to use a potion, or 5 to use a scroll");
			Scanner input = new Scanner(System.in);
			int whatToDo = input.nextInt();
			if(whatToDo == 1){
				attack(theMonster);
			}
			if(whatToDo ==2){
				castSpell(theMonster);
			}
			if(whatToDo==3){
				chargeMana();
			}
			if(whatToDo==4){
				if(this.potions !=null){
					potions.use(AdventureGame.hero);
				}
				else{
					System.out.println("How can you use what you dont have? Try to keep track of what you have so you dont lose your turns!");
				}
			}
			if(whatToDo ==5){
				if(this.scrolls != null){
				scrolls.use(AdventureGame.hero);
				}
				else{
					System.out.println("How can you use what you dont have? Try to keep track of what you have so you dont lose your turns!");
				}
			}
		}
		
		//public String toString(){
			//return 
		//}
}