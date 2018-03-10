package by.bsuir.Khamutouski;

import sun.awt.AWTAccessor;

public class School extends EstablishmentOfEducation {
    private Scholar pupil;
    School(){
        super();
        this.pupil = null;
    }
    School(final String nameOfSchool) {
        super(nameOfSchool);
        this.pupil = null;
    }
    public String getPhotoPath() {
        return this.pupil.getPhotoPath();
    }
    @Override
    public void deductLeaner() {
        this.pupil = null;
    }

    public void enrollLeaner(final Scholar newPupil) {
        this.pupil = newPupil;
    }
    public String surnameOfScholar() {
        return this.pupil.getSurname();
    }
    public String nameOfScholar() {
        return this.pupil.getName();
    }
    public int formOfScholar() {
        return this.pupil.getForm();
    }
    public String marksOfScholar() {
        return this.pupil.getAllMarksValue();
    }
    public String nameOfSchool() {
        return this.getNameOfEstablishment();
    }
    public void teachPupil() {
        this.pupil.studying();
    }
    public Scholar thisPupil() {
        return this.pupil;
    }
}
