package by.bsuir.Khamutouski;

import java.util.Random;

public class Leaner {

    public final int COUNT_OF_MARKS = 3;
    private final int DEFAULT_MARK = 0;
    private final String NONE = "none";

    private String name;
    private String surname;

    public int marks[] = new int[COUNT_OF_MARKS];

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
        for (int i = 0; i < COUNT_OF_MARKS; i++) {
            this.marks[i] = DEFAULT_MARK;
        }
    }
    public void setName(final String newName) {
        this.name = newName;
    }
    public void setSurname(final String newSurname) {
        this.surname = newSurname;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public void setMark(final int atIndex, final int mark){
        this.marks[atIndex] = mark;
    }
    public void studying() {

    }
}
