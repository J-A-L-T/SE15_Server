package de.studeasy.registries;

import java.util.HashMap;

import de.studeasy.entities.Homework;

public class HomeworkRegistry {
	
	private static HomeworkRegistry singleInstance = new HomeworkRegistry();
	
	private HashMap<Integer,Homework> homeworks;
	
	private HomeworkRegistry() {
		homeworks = new HashMap<>();
	}
	
	public static HomeworkRegistry getInstance() {
		return singleInstance;
	}
	
	public Homework findHomeworkById(int id) {
		return this.homeworks.get(id);
	}
	
	public void addHomework(Homework newHomework) {
		this.homeworks.put(newHomework.getHomeworkID(), newHomework);
	}
}
