package by.bsuir.Khamutouski;

import java.util.Random;

public class Leaner {

    private final int COUNT_OF_MARKS = 3;
    private final int DEFAULT_MARK = 0;
    private final int MAXIMAL_MARK = 10;
    private final String NONE = "none";

    private String name;
    private String surname;

    private int marks[] = new int[COUNT_OF_MARKS];

    Leaner(){
        this.name = NONE;
        this.surname = NONE;
        for (int i = 0; i < COUNT_OF_MARKS; i++){
            this.marks[i] = DEFAULT_MARK;
        }
    }
    Leaner(String newName, String newSurname){
        this.name = newName;
        this.surname = newSurname;
        for (int i = 0; i < COUNT_OF_MARKS; i++){
            this.marks[i] = DEFAULT_MARK;
        }
    }

    public void studying() {
        Random randNumber = new Random();
        for (int i = 0; i < COUNT_OF_MARKS; i++) {
            this.marks[i] = randNumber.nextInt(MAXIMAL_MARK);
        }
    }
}
