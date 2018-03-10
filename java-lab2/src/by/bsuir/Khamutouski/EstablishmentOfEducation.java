package by.bsuir.Khamutouski;

public class EstablishmentOfEducation {

    private final static String DEFAULT_NAME = "none";
    private Leaner leaner;
    private String nameOfEstablishment;

    EstablishmentOfEducation(){
        this.nameOfEstablishment = DEFAULT_NAME;
    }
    EstablishmentOfEducation(final String name){
        this.nameOfEstablishment = name;
    }
    public void setNameOfEstablishment(String newName){
        this.nameOfEstablishment = newName;
    }
    public void deductLeaner(){
        leaner = null;
    }
    public void enrollLeaner(){

    }
    public String getNameOfEstablishment() {
        return this.nameOfEstablishment;
    }
}
