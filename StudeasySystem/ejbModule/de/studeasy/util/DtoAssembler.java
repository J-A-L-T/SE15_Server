package de.studeasy.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.studeasy.common.*;
import de.studeasy.dto.*;



@Stateless
public class DtoAssembler {
	
	// Methoden für das übergeben
	
	public ILessonTO makeLessonDTO(ILesson lesson) {
			ILessonTO dto = new LessonTO();
			
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
	
	public IHomeworkTO makeHomeworkDTO(IHomework homework) {
		IHomeworkTO dto = new HomeworkTO();
		
		dto.setDescription(homework.getDescription());
		dto.setHomeworkID(homework.getHomeworkID());
		dto.setLesson(makeLessonDTO(homework.getLesson()));
		
		return dto;
		
	}
	
	public ITeacherTO makeTeacherDTO(ITeacher teacher) {
		ITeacherTO dto = new TeacherTO();
		
		dto.setCourse(makeCourseDTO(teacher.getCourse()));
		dto.setFirstname(teacher.getFirstname());
		dto.setGender(teacher.getGender());
		dto.setLessons(makeLessonDTO(teacher.getLessons()));
		dto.setName(teacher.getName());
		dto.setPassword(teacher.getPassword());
		dto.setPersonID(teacher.getPersonID());
		
		return dto;
	}
	
	public ISubjectTO makeSubjectDTO(ISubject subject) {
		ISubjectTO dto = new SubjectTO();
		
		dto.setDescription(subject.getDescription());
		dto.setSubjectID(subject.getSubjectID());
		
		return dto;
	}
	
	public IRoomTO makeRoomDTO(IRoom room) {
		IRoomTO dto = new RoomTO();
		
		dto.setLessons(makeLessonDTO(room.getLessons()));
		dto.setRoomID(room.getRoomID());
		
		return dto;
	}
	
	public ICourseTO makeCourseDTO(ICourse course) {
		ICourseTO dto = new CourseTO();
		
		dto.setClassTeacher(makeTeacherDTO(course.getClassTeacher()));
		dto.setCourseID(course.getCourseID());
		dto.setDescriptor(course.getDescriptor());
		dto.setGrade(course.getGrade());
		dto.setLessons(makeLessonDTO(course.getLessons()));
		dto.setPupils(makePupilDTO(course.getPupils()));
		
		return dto;
	}
	
	public IPupilTO makePupilDTO(IPupil pupil) {
		IPupilTO dto = new PupilTO();
		
		dto.setCourse(makeCourseDTO(pupil.getCourse()));
		dto.setFirstname(pupil.getFirstname());
		dto.setGender(pupil.getGender());
		dto.setName(pupil.getName());
		dto.setPassword(pupil.getPassword());
		dto.setPersonID(pupil.getPersonID());
		
		return dto;
	}
	
	public List<IPupilTO> makePupilDTO(List<IPupil> pupils) {
		List<IPupilTO> dtoList = new ArrayList<IPupilTO>();
		  for (IPupil a : pupils) {
			  dtoList.add(makePupilDTO(a));
		  }
		  return dtoList;
	}

	/**
	 * Macht aus einer ILesson Liste eien LessonTO Liste
	 */
 	public List<ILessonTO> makeLessonDTO(List<ILesson> lessons) {
		  List<ILessonTO> dtoList = new ArrayList<ILessonTO>();
		  for (ILesson a : lessons) {
			  dtoList.add(makeLessonDTO(a));
		  }
		  return dtoList;
 	}
 	
 	public List<IHomeworkTO> makeHomeworkDTO(List<IHomework> homeworks) {
		  List<IHomeworkTO> dtoList = new ArrayList<IHomeworkTO>();
		  for (IHomework h : homeworks) {
			  dtoList.add((IHomeworkTO) makeHomeworkDTO(h));
		  }
		  return dtoList;
	}
 	
}