public class Potion extends Item{
	private int heal= 15;
	private String name;
	Potion(String name, int heal){
		this.name=name;
		this.heal=heal;
	}
	
	
	@Override
	public void use(Player thePlayer){
		thePlayer.gainHealth(heal);
		System.out.println("You gain health");
	}
}