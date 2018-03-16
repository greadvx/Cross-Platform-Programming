package by.bsuir.Khamutouski.establishments;

import by.bsuir.Khamutouski.leaners.Kinder;
import java.util.ArrayList;

/**
 * <h1>Kindergarten</h1>
 * <p>
 * This class is used to
 * store info about kindergarten.
 * </p>
 *
 * This class is used in hierarchy of
 * inheritance.
 *
 * @author Yan Khamutouski
 * @version 2.0
 * @since 2018-03-16
 *
 * */
public class Kindergarten extends EstablishmentOfEducation {
    /**
     * {@value #NO} Code of
     *  not success exit operation.
     * */
    private static final int NO = -1;
    /**
     * {@value #NONE} String constant.
     * */
    private static final String NONE = "none";
    /**
     * Private field name of kindergarten.
     * */
    private String nameOfKindergarten;
    /**
     * Private field ArrayList kids –
     * list of Kinder.
     * */
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
    public Kindergarten(final Kindergarten anotherKindergarten) {
        super();
        if (anotherKindergarten != null) {
            this.nameOfKindergarten =
                    anotherKindergarten.getNameOfKindergarten();
            this.kids = new ArrayList<>(anotherKindergarten.getKids());
        }
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
    /**
     * Getter of name of kindergarten.
     * */
    public String getNameOfKindergarten() {
        return nameOfKindergarten;
    }
    /**
     * Method to enroll Leaner.
     * @param newPupil - New Kinder.
     * */
    public void enrollLeaner (final Kinder newPupil) {
        this.kids.add(newPupil);
    }
    /**
     * Method to deduct Leaner.
     * @param personToDeduct - Kinder for deduct.
     * */
    public void deductLeaner(Kinder personToDeduct) {
        int index = this.searchAroundKids(personToDeduct);
        if (index == NO) {
            return;
        } else {
            this.kids.remove(index);
        }
    }
    /**
     * Getter of IQ of Kinder.
     * @param kinder - Kinder.
     * @return String - IQ.
     * */
    public String iqOfChild(final Kinder kinder) {
        int index = this.searchAroundKids(kinder);
        if (index == NO) {
            return NONE;
        } else {
            return this.kids.get(index).getIQValue();
        }
    }
    /**
     * Getter for copying.
     * */
    public ArrayList<Kinder> getKids() {
        return this.kids;
    }
    /**
     * Method to feed kids.
     * */
    public void feedKids(final Kinder kinder) {
        int index = this.searchAroundKids(kinder);
        if (index == NO) {
            return;
        } else {
            this.kids.get(index).studying();
        }
    }
}
