package de.studeasy.registries;

import java.util.HashMap;


import de.studeasy.common.ILesson;

public class LessonRegistry {
	
	private static LessonRegistry singleInstance = new LessonRegistry();
	
	private HashMap<Integer,ILesson> lessons;
	
	private LessonRegistry() {
		lessons = new HashMap<>();
	}
	
	public static LessonRegistry getInstance() {
		return singleInstance;
	}
	
	public ILesson findLessonById(int id) {
		return this.lessons.get(id);
	}
	
	public void addLesson(ILesson newLesson) {
		this.lessons.put(newLesson.getLessonID(), newLesson);
	}
}
