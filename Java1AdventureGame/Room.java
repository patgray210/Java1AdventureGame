public class Room{
	private String description;
	private Room north;
	private Room east;
	private Room west;
	private Room south;

	Room(String description){
		this.description= description;
	}
	public void setNorth(Room north){
		this.north = north;
	}
	public void setEast(Room east){
		this.east = east;
	}
	public void setWest(Room west){
		this.west= west;
	}
	public void setSouth(Room south){
		this.south= south;
	}
	
	public void setExits(Room n,Room e, Room w,Room s){
		this.north = n;
		this.east = e;
		this.west = w;
		this.south =s;
	}
	public Room getNorth(){
		return this.north;
	}
	public Room getEast(){
		return this.east;
	}
	public Room getWest(){
		return this.west;
	}
	public Room getSouth(){
		return this.south;
	}
	public String getDescription(){
		return this.description;
	}
	public String getExits(){
		String northExit= "";
		String eastExit= "";
		String westExit= "";
		String southExit="";

		if(north != null){
			northExit= "The north: " + north.getDescription();
		}
		if(north == null){
			northExit= "The north: Nothing";
		}
		if(east != null){
			eastExit = "The east: " + east.getDescription();
		}
		if(east == null){
			eastExit = "The east: Nothing";
		}
		if(west != null){
			westExit = "The west: " + west.getDescription();
		}
		if(west ==null){
			westExit = "The west: Nothing"; 
		}
		if(south != null){
			southExit = "The south: " + south.getDescription();
		}
		if(south ==null){
			southExit = "The south: Absolutely nothing";
		}
		String exits = "\n"+northExit+"\n"+eastExit+"\n"+westExit+"\n"+southExit;
		return exits;
	}
	public String toString(){
		String vari = getDescription() + " " + getExits();
		return vari;
	}
}