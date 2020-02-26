public class Scroll extends Item{
	private int boostDmg;
	private String name;
	Scroll(String name,int boostDmg){
		this.name=name;
		this.boostDmg=boostDmg;
	}
	
	@Override
	public void use(Player thePlayer){
		thePlayer.setAP(boostDmg);
		System.out.println("Thoughts and prayers for the next thing you happen to attack");
	}
}
