package de.studeasy.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.studeasy.common.*;
import de.studeasy.systeminterfaces.ICourse;
import de.studeasy.systeminterfaces.IHomework;
import de.studeasy.systeminterfaces.ILesson;
import de.studeasy.systeminterfaces.IPupil;
import de.studeasy.systeminterfaces.IRoom;
import de.studeasy.systeminterfaces.ISubject;
import de.studeasy.systeminterfaces.ITeacher;

/**
 * DTOAssembler wird zum füllt die TO Objekte jeweils mit den notwendigen Daten.
 * @author Andreas Prischep
 *
 */
@Stateless
public class DtoAssembler {
	
	// Methoden für das übergeben
	
	public LessonTO makeLessonDTO(ILesson lesson) {
			LessonTO dto = new LessonTO();
			
			dto.setLessonID(lesson.getLessonID());
			dto.setLessonHour(lesson.getLessonHour());
			dto.setDate(lesson.getDate());
			dto.setTeacher(makeTeacherDTO(lesson.getTeacher()));
			dto.setSubject(makeSubjectDTO(lesson.getSubject()));
			dto.setRoom(makeRoomDTO(lesson.getRoom()));
			dto.setHomeworks(makeHomeworkDTO(lesson.getHomeworks())); //Arraylist
			dto.setCourse(makeCourseDTO(lesson.getCourse()));
		  
		  return dto;
	  }
	
	public HomeworkTO makeHomeworkDTO(IHomework homework) {
		HomeworkTO dto = new HomeworkTO();
		
		dto.setDescription(homework.getDescription());
		dto.setHomeworkID(homework.getHomeworkID());
		dto.setLesson(makeLessonDTO(homework.getLesson()));
		
		return dto;
		
	}
	
	public TeacherTO makeTeacherDTO(ITeacher teacher) {
		TeacherTO dto = new TeacherTO();
		
		dto.setCourse(makeCourseDTO(teacher.getCourse()));
		dto.setFirstname(teacher.getFirstname());
		dto.setGender(teacher.getGender());
		dto.setLessons(makeLessonDTO(teacher.getLessons()));
		dto.setName(teacher.getName());
		dto.setPassword(teacher.getPassword());
		dto.setPersonID(teacher.getPersonID());
		
		return dto;
	}
	
	public SubjectTO makeSubjectDTO(ISubject subject) {
		SubjectTO dto = new SubjectTO();
		
		dto.setDescription(subject.getDescription());
		dto.setSubjectID(subject.getSubjectID());
		
		return dto;
	}
	
	public RoomTO makeRoomDTO(IRoom room) {
		RoomTO dto = new RoomTO();
		
		dto.setLessons(makeLessonDTO(room.getLessons()));
		dto.setRoomID(room.getRoomID());
		
		return dto;
	}
	
	public CourseTO makeCourseDTO(ICourse course) {
		CourseTO dto = new CourseTO();
		
		dto.setClassTeacher(makeTeacherDTO(course.getClassTeacher()));
		dto.setCourseID(course.getCourseID());
		dto.setDescriptor(course.getDescriptor());
		dto.setGrade(course.getGrade());
		dto.setLessons(makeLessonDTO(course.getLessons()));
		dto.setPupils(makePupilDTO(course.getPupils()));
		
		return dto;
	}
	
	public PupilTO makePupilDTO(IPupil pupil) {
		PupilTO dto = new PupilTO();
		
		dto.setCourse(makeCourseDTO(pupil.getCourse()));
		dto.setFirstname(pupil.getFirstname());
		dto.setGender(pupil.getGender());
		dto.setName(pupil.getName());
		dto.setPassword(pupil.getPassword());
		dto.setPersonID(pupil.getPersonID());
		
		return dto;
	}
	
	public List<PupilTO> makePupilDTO(List<IPupil> pupils) {
		List<PupilTO> dtoList = new ArrayList<PupilTO>();
		  for (IPupil a : pupils) {
			  dtoList.add(makePupilDTO(a));
		  }
		  return dtoList;
	}

	/**
	 * Macht aus einer ILesson Liste eien LessonTO Liste
	 */
 	public List<LessonTO> makeLessonDTO(List<ILesson> lessons) {
		  List<LessonTO> dtoList = new ArrayList<LessonTO>();
		  for (ILesson a : lessons) {
			  dtoList.add(makeLessonDTO(a));
		  }
		  return dtoList;
 	}
 	
 	public List<HomeworkTO> makeHomeworkDTO(List<IHomework> homeworks) {
		  List<HomeworkTO> dtoList = new ArrayList<HomeworkTO>();
		  for (IHomework h : homeworks) {
			  dtoList.add(makeHomeworkDTO(h));
		  }
		  return dtoList;
	}
 	
}