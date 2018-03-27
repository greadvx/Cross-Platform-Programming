package by.bsuir.Khamutouski.convolution;
/**
 * <h1>IterationConvolution - new Thread</h1>
 *
 * <p>
 * This is a class of application
 * that extend build- in class Thread.
 * Used to compute math expressions.
 * </p>
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-03-27
 *
 * */
public class IterationConvolution extends Thread {
    /**
     * Field result of computing.
     * */
    private int result = 0;
    /**
     * Field firstArray contains data to compute.
     * */
    private int[] firstArray;
    /**
     * Field secondArray contains data to compute.
     * */
    private int[] secondArray;
    /**
     * Field count contains quantity of iterations.
     * */
    private int count;

    /**
     * Constructor with params.
     * @param count - count of iterations.
     * @param firstArray - data to compute.
     * @param secondArray - data to compute.
     * */
    public IterationConvolution(final int[] firstArray,
                                final int[] secondArray,
                                final int count
    ) {
        super();
        this.firstArray = firstArray;
        this.secondArray = secondArray;
        this.count = count;
        start();
    }
    /**
     * Defining the method run() to process
     * multithreading computing operations.
     * */
     public void run() {
        this.count();
    }
    /**
     * Method of computing.
     * Process the data.
     * @since 1.0
     * */
    public void count() {
        for (int i = 0; i < count; i++) {
            result += firstArray[i] * secondArray[i];
        }
    }
    /**
     * Getter of field result.
     * @return int - result.
     * @since 1.0
     * */
    public int getResult()  {
        return this.result;
    }
}
