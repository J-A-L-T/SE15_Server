package de.studeasy.registries;

import java.util.HashMap;


import de.studeasy.common.IHomework;

public class HomeworkRegistry {
	
	private static HomeworkRegistry singleInstance = new HomeworkRegistry();
	
	private HashMap<Integer,IHomework> homeworks;
	
	private HomeworkRegistry() {
		homeworks = new HashMap<>();
	}
	
	public static HomeworkRegistry getInstance() {
		return singleInstance;
	}
	
	public IHomework findHomeworkById(int id) {
		return this.homeworks.get(id);
	}
	
	public void addHomework(IHomework newHomework) {
		this.homeworks.put(newHomework.getHomeworkID(), newHomework);
	}
	
	public void removeHomeworkById(int id) {
		//Die Referenz auf das Homework-Objekt muss auch in der ArrayList in Lesson gelöscht werden
		this.homeworks.get(id).getLesson().removeHomework(id);
		this.homeworks.remove(id);
	}
}
