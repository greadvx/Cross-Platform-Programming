package by.bsuir.Khamutouski;

public class School extends EstablishmentOfEducation {
    private Scholar pupil;

    School(final String nameOfSchool, final Scholar newPupil) {
        super(nameOfSchool);
        this.pupil = newPupil;
    }
    @Override
    public void deductLeaner() {
        this.pupil = null;
    }

    public void enrollLeaner(final Scholar newPupil) {
        this.pupil = newPupil;
    }
}
