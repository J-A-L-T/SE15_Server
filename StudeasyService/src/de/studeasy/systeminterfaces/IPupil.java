package de.studeasy.systeminterfaces;

/**
 * Interface für die Pupil-Entity
 * @author Andreas Prischep
 *
 */
public interface IPupil extends IPerson {
	public ICourse getCourse();
	public void setCourse(ICourse course);
}
