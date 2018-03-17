package by.bsuir.Khamutouski.leaners;

import by.bsuir.Khamutouski.establishments.Kindergarten;
/**
 * <h1>Kinder</h1>
 * <p>
 * This class is used to
 * store info about kinder.
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
public class Kinder extends Leaner {
    /**
     * {@value #BEGINNERS_INDEX} Begin index.
     * */
    private static final int BEGINNERS_INDEX = 0;
    /**
     * Array of Strings to change name of group.
     * */
    private static final String[] GROUP_LIST = {"Ясли   ", "Младшая",
            "Средняя", "Старшая"};
    /**
     * {@value #NONE} None value.
     * */
    private static final String NONE = "none";
    /**
     * {@value #IQ_INCREASE} Value to increase iq.
     * */
    private static final int IQ_INCREASE = 1;
    /**
     * {@value #MAXIMAL_YEAR} Maximal value of
     * field index.
     * */
    private static final int MAXIMAL_YEAR = 3;
    /**
     * Private field index - for navigation in
     * GROUP_LIST.
     * */
    private int index;
    /**
     * Private field group.
     * */
    private String group;
    /**
     * Private field Kindergarten.
     * */
    private Kindergarten kindergarten;
    /**
     * Default constructor.
     * */
    public Kinder() {
        super();
        this.group = NONE;
        this.index = BEGINNERS_INDEX;
        this.iq = BEGINNERS_INDEX;
        this.kindergarten = new Kindergarten();
    }
    /**
     * Constructor with params.
     * @param name - Name.
     * @param surname - Surname.
     * @param photo - PhotoPath.
     * */
    public Kinder(final String name, final String surname,
                  final String photo) {
        super (name, surname, photo);
        this.index = BEGINNERS_INDEX;
        this.group = GROUP_LIST[index];
    }
    /**
     * Constructor of copying.
     * @param anotherKinder - Kinder.
     * */
    public Kinder(final Kinder anotherKinder) {
        super(anotherKinder.getName(), anotherKinder.getSurname(),
                anotherKinder.getPhotoPath());
        this.group = anotherKinder.getGroupString();
        this.iq = anotherKinder.iq;
        this.index = anotherKinder.getGroup();
        this.kindergarten = new Kindergarten(anotherKinder.getKindergarten());
    }
    /**
     * Method studying.
     * It increases group and iq.
     * */
    @Override
    public void studying() {
        if (index < MAXIMAL_YEAR) {
            index++;
            this.iq += IQ_INCREASE;
            this.group = GROUP_LIST[index];
        }
    }
    /**
     * Getter getGroup.
     * @return Int - group num.
     * */
    public int getGroup() {
        return this.index;
    }
    /**
     * Getter getGroupString.
     * @return String - name of group.
     * */
    public String getGroupString() {
        return this.group;
    }
    public void leaveKindergarten() {
        this.kindergarten.deductLeaner(this);
    }
    /**
     * Method to attach Kindergarten.
     * @param kindergartenName - Kindergarten.
     * */
    public void attachNusery(final Kindergarten kindergartenName) {
        this.kindergarten = kindergartenName;
    }
    /**
     * Getter for copying.
     * @return Kindergarten.
     * */
    public Kindergarten getKindergarten() {
        return this.kindergarten;
    }
}
