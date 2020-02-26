public class Monster extends GameCharacter{
	private int xP;
	Monster(String name, int health, int attackPower, int xP){
		super(name,health,attackPower);
		this.xP=xP;
	}
	public void attack(Player thePlayer){
		thePlayer.takeDamage(getAttackPower());
	}
	public void takeTurn(Player thePlayer){
		attack(thePlayer);
	}
	public int getXp(){
		return this.xP;
	}
	//public String toString(){

	//}
}