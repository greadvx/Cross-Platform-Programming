package by.bsuir.Khamutouski;

public class University extends EstablishmentOfEducation {
    private final static double PASSING_SCORE = 8.7;
    private Student student;

    public static boolean conductExam(final Scholar enrollPerson){
        double passingScore = 0;
        for (int mark : enrollPerson.marks) {
            passingScore += mark;
        }

        passingScore /= enrollPerson.marks.length;

        if (passingScore >= PASSING_SCORE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deductLeaner() {
        this.student = null;
    }

    public void enrollLeaner(final Scholar enrollPerson) {
        this.student.setName(enrollPerson.getName());
        this.student.setSurname(enrollPerson.getSurname());
    }
}

