package de.studeasy.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.studeasy.common.*;
import de.studeasy.systeminterfaces.IHomework;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IPerson;
import de.studeasy.systeminterfaces.ISubject;

/**
 * DTOAssembler wird zum füllt die TO Objekte jeweils mit den notwendigen Daten.
 * @author Andreas Prischep, Tobias Riegel
 *
 */
@Stateless
public class DtoAssembler {
	
	// Methoden für das übergeben
	
	public LessonTO makeLessonDTO(ILesson lesson) {
			LessonTO dto = new LessonTO();
			if(lesson!=null) {
				dto.setLessonID(lesson.getLessonID());
				dto.setLessonHour(lesson.getLessonHour());
				dto.setDate(DateStringConverter.makeDateToString(lesson.getDate()));
				dto.setTeacher(makePersonDTO(lesson.getTeacher()));
				dto.setSubject(makeSubjectDTO(lesson.getSubject()));
				dto.setRoom(lesson.getRoom().getRoomID());
				dto.setHomeworks(makeHomeworkDTO(lesson.getHomeworks())); //Arraylist
			}
			else
				dto = null;
			
		  return dto;
	  }
	
	public HomeworkTO makeHomeworkDTO(IHomework homework) {
		HomeworkTO dto = new HomeworkTO();
		
		dto.setDescription(homework.getDescription());
		dto.setHomeworkID(homework.getHomeworkID());
		
		return dto;
		
	}
	
	public PersonTO makePersonDTO(IPerson person) {
		PersonTO dto = new PersonTO();
		
		dto.setPersonID(person.getPersonID());
		dto.setFirstname(person.getFirstname());
		dto.setGender(person.getGender());
		dto.setName(person.getName());
		
		return dto;
	}
	
	public SubjectTO makeSubjectDTO(ISubject subject) {
		SubjectTO dto = new SubjectTO();
		
		dto.setDescription(subject.getDescription());
		dto.setSubjectID(subject.getSubjectID());
		
		return dto;
	}
 	
 	public List<HomeworkTO> makeHomeworkDTO(List<IHomework> homeworks) {
		  List<HomeworkTO> dtoList = new ArrayList<HomeworkTO>();
		  for (IHomework h : homeworks) {
			  dtoList.add(makeHomeworkDTO(h));
		  }
		  return dtoList;
	} 	
}