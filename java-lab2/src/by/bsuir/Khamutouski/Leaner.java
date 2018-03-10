package by.bsuir.Khamutouski;

import java.util.Random;

public class Leaner {

    public final int COUNT_OF_MARKS = 3;
    private final int DEFAULT_MARK = 0;
    private final String NONE = "none";
    private final String DEFAULT_PHOTO = "/Users/greadvx/Desktop/ScholarImageProfile.jpg";

    private String name;
    private String surname;
    private String photoPath;
    public int marks[] = new int[COUNT_OF_MARKS];

    Leaner(){
        this.name = NONE;
        this.surname = NONE;
        this.photoPath = DEFAULT_PHOTO;
        for (int i = 0; i < COUNT_OF_MARKS; i++){
            this.marks[i] = DEFAULT_MARK;
            this.photoPath = DEFAULT_PHOTO;
        }
    }
    Leaner(String newName, String newSurname, String photo){
        this.name = newName;
        this.surname = newSurname;
        for (int i = 0; i < COUNT_OF_MARKS; i++) {
            this.marks[i] = DEFAULT_MARK;
        }
        if (photo == "") {
            this.photoPath = DEFAULT_PHOTO;
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
    public void setPhotoPath(final String newPhotoPath) {
        this.photoPath = newPhotoPath;
    }
    public void setMark(final int atIndex, final int mark){
        this.marks[atIndex] = mark;
    }
    public void studying() {

    }
}
