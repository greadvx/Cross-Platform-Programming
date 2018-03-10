package by.bsuir.Khamutouski;

public class University extends EstablishmentOfEducation {
    private final static double PASSING_SCORE = 4.7;
    private Student student;

    University(final String nameOfUniversity){
        super(nameOfUniversity);
        this.student = null;
    }
    public boolean conductExam(final Scholar enrollPerson){

        if (enrollPerson.voutes() >= PASSING_SCORE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deductLeaner() {
        this.student = null;
    }

    public void enrollLeaner(final Student newStudent) {
        this.student = newStudent;
    }
}

