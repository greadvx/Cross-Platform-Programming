package by.bsuir.Khamutouski.establishments;

import by.bsuir.Khamutouski.leaners.Kinder;
import java.util.ArrayList;

public class Kindergarten extends EstablishmentOfEducation {

    private static final int NO = -1;
    private static final String NONE = "none";
    /**
     * Private field ArrayList kids –
     * list of Kinder.
     * */
    private String nameOfKindergarten;
    private ArrayList<Kinder> kids;
    /**
     * Default constructor.
     * */
    public Kindergarten() {
        super();
        this.kids = new ArrayList<>();
        this.nameOfKindergarten = NONE;
    }
    /**
     * Constructor with params.
     * @param name - Name of kindergarten.
     * */
    public Kindergarten(final String name) {
        super();
        this.kids = new ArrayList<>();
        this.nameOfKindergarten = name;
    }
    /**
     * Method to search around ArrayList of kids.
     * @return int - index at ArrayList.
     * */
    private int searchAroundKids(final Kinder person){
        for (int index = 0; index < this.kids.size(); index++) {
            if (this.kids.get(index).getName() == person.getName()) {
                return index;
            }
        }
        return NO;
    }
    public String getNameOfKindergarten() {
        return nameOfKindergarten;
    }
    public void enrollLeaner (final Kinder newPupil) {
        this.kids.add(newPupil);
    }
    public void deductLeaner(Kinder personToDeduct) {
        int index = this.searchAroundKids(personToDeduct);
        if (index == NO) {
            return;
        } else {
            this.kids.remove(index);
        }
    }
    /**
     * Method to feed kids.
     * */
    public void feedKids() {
        //this.studying();
    }
}
