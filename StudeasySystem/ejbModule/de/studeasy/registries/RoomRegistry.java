package de.studeasy.registries;

import java.util.HashMap;


import de.studeasy.common.IRoom;

public class RoomRegistry {

	private static RoomRegistry singleInstance = new RoomRegistry();
	
	private HashMap<String,IRoom> rooms;
	
	private RoomRegistry() {
		rooms = new HashMap<>();
	}
	
	public static RoomRegistry getInstance() {
		return singleInstance;
	}
	
	public IRoom findRoomById(String id) {
		return this.rooms.get(id);
	}
	
	public void addRoom(IRoom newRoom) {
		this.rooms.put(newRoom.getRoomID(), newRoom);
	}
}
