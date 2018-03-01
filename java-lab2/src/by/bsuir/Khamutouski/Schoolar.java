package by.bsuir.Khamutouski;

public class Schoolar extends Leaner {
    private final int MAXIMAL_FORM = 11;
    private final int DEFAULT_FORM = 1;
    private int form;

    Schoolar(){
        super();
        this.form = DEFAULT_FORM;
    }

    Schoolar(String name, String surname){
        super(name, surname);
        this.form = DEFAULT_FORM;
    }

    @Override
    public void studying(){
        if (this.form == MAXIMAL_FORM) {
            leaveSchool();
        }else {
            form++;
        }

    }
    private void leaveSchool(){
        //вызывает метод отчислить учащегося из школы
    }
    public void passTheExam(){
        //сдать экзамен
    }
}
