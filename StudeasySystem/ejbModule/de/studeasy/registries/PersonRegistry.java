package de.studeasy.registries;

import java.util.HashMap;

import de.studeasy.entities.Person;

public class PersonRegistry {

	private static PersonRegistry singleInstance = new PersonRegistry();
	
	private HashMap<Integer,Person> persons;
	
	private PersonRegistry() {
		persons = new HashMap<>();
	}
	
	public static PersonRegistry getInstance() {
		return singleInstance;
	}
	
	public Person findPersonById(int id) {
		return this.persons.get(id);
	}
	
	public void addPerson(Person newPerson) {
		this.persons.put(newPerson.getPersonID(), newPerson);
	}
}
