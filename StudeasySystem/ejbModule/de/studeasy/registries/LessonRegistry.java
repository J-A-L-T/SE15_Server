package de.studeasy.registries;

import java.util.HashMap;

import de.studeasy.entities.Lesson;

public class LessonRegistry {
	
	private static LessonRegistry singleInstance = new LessonRegistry();
	
	private HashMap<Integer,Lesson> lessons;
	
	private LessonRegistry() {
		lessons = new HashMap<>();
	}
	
	public static LessonRegistry getInstance() {
		return singleInstance;
	}
	
	public Lesson findLessonById(int id) {
		return this.lessons.get(id);
	}
	
	public void addLesson(Lesson newLesson) {
		this.lessons.put(newLesson.getLessonID(), newLesson);
	}
}
