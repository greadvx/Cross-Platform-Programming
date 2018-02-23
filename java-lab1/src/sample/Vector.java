package sample;

public class Vector {
    private double firstXCoordinate;
    private double firstYCoordinate;
    private double secondXCoordinate;
    private double secondYCoordinate;

    Vector(double setX1, double setY1, double setX2, double setY2){
        this.firstXCoordinate = setX1;
        this.firstYCoordinate = setY1;
        this.secondXCoordinate = setX2;
        this.secondYCoordinate = setY2;
    }
    /**
     * This is a method that count length of vector
     * @return double This returns arithmetical length of
     * vector inputed by 2 pair of 2 dimensional coordinates.
     * */
    public double countingLengthOfVector() {
        double result = Math.pow(secondXCoordinate - firstXCoordinate, 2)
                + Math.pow(secondYCoordinate - firstYCoordinate, 2);
        return result;
    }

    public double projectionOnX() {
        return secondXCoordinate - firstXCoordinate;
    }

    public double projectionOnY() {
        return secondYCoordinate - firstYCoordinate;
    }

}
