public class GameCharacter{

	private String name;
	private  int health;
	private int attackPower;

	public GameCharacter(String name, int health, int atk){
		this.name = name;
		this.health = health;
		this.attackPower = atk;
	}

	public void takeDamage(int damage){
		if(this.health > damage){
			this.health -= damage;
			System.out.printf("%s takes %d damage\n",this.name, damage);
		}else{
			this.health = 0;
		}
	}//end method
	public void gainHealth(int heal){
		this.health +=heal;
	}
	public String getName(){ 
		return this.name; 
	}
	public int getAttackPower(){ 
		return this.attackPower; 
	}
    public int getHealth(){ 
    	return this.health; 
    }
    public void setAP(int boost){
    	this.attackPower+=boost;
    }
	public String toString(){ return String.format("Name: [%s], Health: [%s], Attack: [%s]",this.name, this.health, this.attackPower);}

}