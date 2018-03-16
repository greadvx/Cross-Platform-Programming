package by.bsuir.Khamutouski.leaners;

import by.bsuir.Khamutouski.establishments.Kindergarten;

public class Kinder extends Leaner {

    private static final int BEGINNERS_INDEX = 0;
    /**
     * Array of Strings to change name of group.
     * */
    private static final String[] GROUP_LIST = {"Ясли", "Младшая",
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
    private static final int MAXIMAL_YEAR = 4;
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
     * Method studying.
     * It increases group and iq.
     * */
    @Override
    public void studying() {
        if (index < MAXIMAL_YEAR) {
            index++;
            this.iq += IQ_INCREASE;
        }
        this.group = GROUP_LIST[index];
    }
    /**
     * Getter getGroup.
     * @return String - group name.
     * */
    public String getGroup() {
        return this.group;
    }
    public void leaveKindergarten() {
        this.kindergarten.deductLeaner(this);
    }
    /**
     * Method to attach Kindergarten.
     * */
    public void attachNusery(final Kindergarten kindergartenName) {
        this.kindergarten = kindergartenName;
    }
}
