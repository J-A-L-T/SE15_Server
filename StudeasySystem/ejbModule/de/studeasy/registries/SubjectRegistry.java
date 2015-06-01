package de.studeasy.registries;

import java.util.HashMap;


import de.studeasy.common.ISubject;

public class SubjectRegistry {

	private static SubjectRegistry singleInstance = new SubjectRegistry();
	
	private HashMap<Integer,ISubject> subjects;
	
	private SubjectRegistry() {
		subjects = new HashMap<>();
	}
	
	public static SubjectRegistry getInstance() {
		return singleInstance;
	}
	
	public ISubject findSubjectById(int id) {
		return this.subjects.get(id);
	}
	
	public void addSubject(ISubject newSubject) {
		this.subjects.put(newSubject.getSubjectID(), newSubject);
	}
}
