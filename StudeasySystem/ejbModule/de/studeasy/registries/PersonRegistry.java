package de.studeasy.registries;

import java.util.HashMap;


import de.studeasy.common.IPerson;

public class PersonRegistry {

	private static PersonRegistry singleInstance = new PersonRegistry();
	
	private HashMap<Integer,IPerson> persons;
	
	private PersonRegistry() {
		persons = new HashMap<>();
	}
	
	public static PersonRegistry getInstance() {
		return singleInstance;
	}
	
	public IPerson findPersonById(int id) {
		return this.persons.get(id);
	}
	
	public void addPerson(IPerson newPerson) {
		this.persons.put(newPerson.getPersonID(), newPerson);
	}
}
