public class Dungeon{
	private Room bigBathroom;
	private Room kitchen;
	private Room masterBedroom;
	private Room hallway;
	private Room walkInCloset;
	private Room diningRoom;
	private Room livingRoom;
	Dungeon(){
		 this.bigBathroom = new Room(" a big bathroom");
		 this.kitchen = new Room(" a kitchen!");
		 this.masterBedroom	= new Room(" a massive bedroom");	
		 this.hallway = new Room(" a normal hallway");
		 this.walkInCloset = new Room(" a closet");
		 this.diningRoom = new Room (" a dining room");
		 this.livingRoom = new Room (" a living room");
	}
	public void setRoom(){
		bigBathroom.setExits(masterBedroom,null, null,null);
		kitchen.setExits(hallway,null,null,null);
		masterBedroom.setExits(walkInCloset,hallway,null,bigBathroom);
		hallway.setExits(diningRoom,livingRoom,masterBedroom,kitchen);
		walkInCloset.setExits(null,null,null,masterBedroom);
		diningRoom.setExits(null,null,null,hallway);
		livingRoom.setExits(null,null,hallway,null);

	}
	public Room getRoom0(){
		return this.masterBedroom;
	}

	public Room getBigBathroom(){
		return bigBathroom;
	}
	public Room getWalkInCloset(){
		return walkInCloset;
	}
	public Room getKitchen(){
		return kitchen;
	}
}