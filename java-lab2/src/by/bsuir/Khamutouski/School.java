package by.bsuir.Khamutouski;

public class School extends EstablishmentOfEducation {
    private Scholar pupil;
    @Override
    public void deductLeaner() {
        this.pupil = null;
    }

    public void enrollLeaner(final Scholar newPupil) {
        this.pupil = newPupil;
    }
}
