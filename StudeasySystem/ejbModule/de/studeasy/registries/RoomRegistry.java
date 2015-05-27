package de.studeasy.registries;

import java.util.HashMap;

import de.studeasy.entities.Room;

public class RoomRegistry {

	private static RoomRegistry singleInstance = new RoomRegistry();
	
	private HashMap<String,Room> rooms;
	
	private RoomRegistry() {
		rooms = new HashMap<>();
	}
	
	public static RoomRegistry getInstance() {
		return singleInstance;
	}
	
	public Room findRoomById(String id) {
		return this.rooms.get(id);
	}
	
	public void addRoom(Room newRoom) {
		this.rooms.put(newRoom.getRoomID(), newRoom);
	}
}
