package by.bsuir.Khamutouski;

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
    @Override
    public void deductLeaner() {
        this.pupil = null;
    }

    public void enrollLeaner(final Scholar newPupil) {
        this.pupil = newPupil;
    }
}
