package by.bsuir.Khamutouski;
/**
 * Class Vector.
 * It uses to make easy understanding of
 * arithmetical operations of Vector
 * @since 1.0
 * */
public class Vector {
    /**
     * {@value #RATE} Rate for pow the equation.
     * */
    static final int RATE = 2;
    /**
     * First X coordinate on the plane.
     * */
    private double firstXCoordinate;
    /**
     * First Y coordinate on the plane.
     * */
    private double firstYCoordinate;
    /**
     * Second X coordinate on the plane.
     * */
    private double secondXCoordinate;
    /**
     * Second Y coordinate on the plane.
     * */
    private double secondYCoordinate;
    /**
     * This is a constructor for class Vector.
     * It used to build a vector.
     * @param setX1 First x coordinate
     * @param setX2 Second x coordinate
     * @param setY1 First y coordinate
     * @param setY2 Second y coordinate
     * */
    Vector(final double setX1, final double setY1,
           final double setX2, final double setY2) {
        this.firstXCoordinate = setX1;
        this.firstYCoordinate = setY1;
        this.secondXCoordinate = setX2;
        this.secondYCoordinate = setY2;
    }
    /**
     * This is a method that count length of vector.
     * @return double This returns arithmetical
     * length of vector inputed by 2 pair
     * of 2 dimensional coordinates.
     * */
    public double countingLengthOfVector() {
        double result = Math.pow(secondXCoordinate
                - firstXCoordinate, RATE)
                + Math.pow(secondYCoordinate
                - firstYCoordinate, RATE);
        return result;
    }
    /**
     * This is a method that compute projection of vector on the X.
     * @return double This returns difference of the length by substraction
     * secondXCoordinate and firstXCoordinate.
     * */
    public double projectionOnX() {
        return secondXCoordinate - firstXCoordinate;
    }
    /**
     * This is a method that compute projection of vector on the Y.
     * @return double This returns difference of the length by substraction
     * secondYCoordinate and firstYCoordinate.
     * */
    public double projectionOnY() {
        return secondYCoordinate - firstYCoordinate;
    }

}
