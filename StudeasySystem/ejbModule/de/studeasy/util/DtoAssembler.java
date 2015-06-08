package de.studeasy.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import de.studeasy.common.IHomework;
import de.studeasy.common.IHomeworkTO;
import de.studeasy.dto.HomeworkTO;

import de.studeasy.common.ILesson;
import de.studeasy.common.ILessonTO;
import de.studeasy.dto.LessonTO;



@Stateless
public class DtoAssembler {
	
	// Methoden für das übergeben
	
	public LessonTO makeDTO(ILesson lesson) {
			LessonTO dto = new LessonTO();
			
			dto.setLessonID(lesson.getLessonID());
			dto.setLessonHour(lesson.getLessonHour());
			dto.setDate(lesson.getDate());
			dto.setTeacher(lesson.getTeacher());
			dto.setSubject(lesson.getSubject());
			dto.setRoom(lesson.getRoom());
			dto.setHomeworks(lesson.getHomeworks()); //Arraylist
			dto.setCourse(lesson.getCourse());
	  
		  	/*
		  	public int getLessonID();
			public int getLessonHour();
			public Date getDate();
			public ITeacher getTeacher();
			public ISubject getSubject();
			public IRoom getRoom();
			public ArrayList<IHomework> getHomeworks();
			public ICourse getCourse();*/
		  
		  return dto;
	  }
	
	public HomeworkTO makeHomeworkDTO(IHomework homework) {
		HomeworkTO dto = new HomeworkTO();
		
		dto.setDescription(homework.getDescription());
		dto.setHomeworkID(homework.getHomeworkID());
		dto.setLesson(homework.getLesson());
		
		return dto;
		
	}
	
	
	
	
	/**
	 * Macht aus einer ILesson Liste eien LessonTO Liste
	 */
 	public List<ILessonTO> makeDTO(List<ILesson> lesson) {
		  ArrayList<ILessonTO> dtoList = new ArrayList<ILessonTO>();
		  for (ILesson a : lesson) {
			  dtoList.add(makeDTO(a));
		  }
		  return dtoList;
 	}
 	
 	public List<IHomeworkTO> makeHomeworkDTO(List<IHomework> homework) {
		  ArrayList<IHomeworkTO> dtoList = new ArrayList<IHomeworkTO>();
		  for (IHomework h : homework) {
			  dtoList.add((IHomeworkTO) makeHomeworkDTO(h));
		  }
		  return dtoList;
	}

 	
 	
 	
 	
}