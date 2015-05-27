package de.studeasy.registries;

import java.util.HashMap;

import de.studeasy.entities.Pupil;

public class PupilRegistry {
	
	private static PupilRegistry singleInstance = new PupilRegistry();
	
	private HashMap<Integer,Pupil> pupils;
	
	private PupilRegistry() {
		pupils = new HashMap<>();
	}
	
	public static PupilRegistry getInstance() {
		return singleInstance;
	}
	
	public Pupil findPupilById(int id) {
		return this.pupils.get(id);
	}
	
	public void addPupil(Pupil newPupil) {
		this.pupils.put(newPupil.getPersonID(), newPupil);
	}
}
