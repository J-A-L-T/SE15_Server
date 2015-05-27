package de.studeasy.registries;

import java.util.HashMap;

import de.studeasy.entities.Teacher;

public class TeacherRegistry {

	private static TeacherRegistry singleInstance = new TeacherRegistry();
	
	private HashMap<Integer,Teacher> teachers;
	
	private TeacherRegistry() {
		teachers = new HashMap<>();
	}
	
	public static TeacherRegistry getInstance() {
		return singleInstance;
	}
	
	public Teacher findTeacherById(int id) {
		return this.teachers.get(id);
	}
	
	public void addTeacher(Teacher newTeacher) {
		this.teachers.put(newTeacher.getPersonID(), newTeacher);
	}
}
