package by.bsuir.Khamutouski;

public class EstablishmentOfEducation {

    private final static String DEFAULT_NAME = "none";

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

    }
    public void enrollLeaner(){

    }

}
