package de.studeasy.registries;

import java.util.HashMap;

import de.studeasy.entities.Subject;

public class SubjectRegistry {

	private static SubjectRegistry singleInstance = new SubjectRegistry();
	
	private HashMap<Integer,Subject> subjects;
	
	private SubjectRegistry() {
		subjects = new HashMap<>();
	}
	
	public static SubjectRegistry getInstance() {
		return singleInstance;
	}
	
	public Subject findSubjectById(int id) {
		return this.subjects.get(id);
	}
	
	public void addSubject(Subject newSubject) {
		this.subjects.put(newSubject.getSubjectID(), newSubject);
	}
}
