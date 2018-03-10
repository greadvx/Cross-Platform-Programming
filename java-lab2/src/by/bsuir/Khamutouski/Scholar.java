package by.bsuir.Khamutouski;

import java.util.Random;

public class Scholar extends Leaner {
    private final static int MAXIMAL_FORM = 11;
    private final static int DEFAULT_FORM = 1;
    public final int MAXIMAL_MARK = 10;
    private int form;

    Scholar(){
        super();
        this.form = DEFAULT_FORM;
    }
    Scholar(String name, String surname, String photo){
        super(name, surname, photo);
        this.form = DEFAULT_FORM;
    }

    @Override
    public void studying(){
        if (this.form == MAXIMAL_FORM) {
            leaveSchool();
        }else {
            form++;
            Random randNumber = new Random();
            for (int index = 0; index < COUNT_OF_MARKS; index++) {
                this.setMark(index,randNumber.nextInt(MAXIMAL_MARK));
            }
        }

    }
    public int getForm() {
        return this.form;
    }
    private void leaveSchool(){
        //вызывает метод отчислить учащегося из школы
    }
    public void passTheExam(){
       // final boolean passed = University.conductExam(this);
    }
}
