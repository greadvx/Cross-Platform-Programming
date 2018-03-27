package by.bsuir.Khamutouski.convolution;

/**
 * <h1>Convolution</h1>
 *
 * <p>
 * This is a class of operation convolution(see mathematics)
 * </p>
 *
 *
 * @author Yan Khamutouski
 * @version 1.0
 * @since 2018-03-27
 *
 * */

public class Convolution {
    /**
     * {@value #SPACE} used to parse data into the string.
     * */
    private static final String SPACE = " ";
    /**
     * Field firstSignal - value of signal.
     * */
    private String firstSignal;
    /**
     * Field secondSignal - value of signal.
     * */
    private String secondSignal;
    /**
     * Field countFirst - count of measurements.
     * */
    private int countFirst;
    /**
     * Field countSecond - count of measurements.
     * */
    private int countSecond;
    /**
     * Field count - count of measurements plus system
     * count in architecture.
     * */
    private int count;
    /**
     * Field valuesOfFirstSignal - array of
     * measurements of first signal.
     * */
    private int[] valuesOfFirstSignal;
    /**
     * Field valuesOfSecondSignal - array of
     * measurements of second signal.
     * */
    private int[] valuesOfSecondSignal;
    /**
     * Field result - contains result of
     * computing.
     * */
    private int result = 0;
    /**
     * Constructor with params.
     * @param countFirst  - int.
     * @param countSecond - int.
     * @param firstSignal - String.
     * @param secondSignal -String.
     * */
    public Convolution(final String firstSignal,
                       final int countFirst,
                       final String secondSignal,
                       final int countSecond
    ) {
        this.firstSignal = firstSignal;
        this.secondSignal = secondSignal;
        this.countFirst = countFirst;
        this.countSecond = countSecond;
        this.count = countFirst + countSecond - 1;
        valuesOfFirstSignal = new int[countFirst];
        valuesOfSecondSignal = new int[countSecond];
    }
    /**
     * Method compute.
     * @return String - value of field result.
     * @since 1.0
     * */
    public String compute() {
        this.fillArrays();
        this.modifyArrays();
        /**
         * Cycle for computing data in array
         * in another thread.
         * */
        for (int move = 0; move < count; move++) {
            /**
             * Creating new thread to compute.
             * */
            IterationConvolution iterationConvolution
                    = new IterationConvolution(valuesOfFirstSignal,
                    valuesOfSecondSignal, count
            );
            /**
             * Block of sync.
             * */
            try {
                iterationConvolution.join();
            }catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            synchronized (iterationConvolution) {
                result += iterationConvolution.getResult();
            }
            /**
             * Moving data in array.
             * */
            int i = 0;
            int j = i + 1;
            int[] buffer = new int[count];
            for (; j < count; i++, j++) {
                buffer[j] = valuesOfSecondSignal[i];
            }
            buffer[0] = valuesOfSecondSignal[i];
            valuesOfSecondSignal = buffer.clone();
            buffer = null;
        }
        return Integer.toString(result);
    }
    /**
     * Method to fill arrays.
     * It converts String value into
     * array of int.
     * @since 1.0
     * */
    private void fillArrays() {
        String[] firstSubString;
        firstSubString = this.firstSignal.split(SPACE);
        for (int i = 0; i < this.countFirst; i++) {
            this.valuesOfFirstSignal[i] = Integer.valueOf(
                    firstSubString[i]);
        }

        String[] secondSubString;
        secondSubString = this.secondSignal.split(SPACE);
        for (int i = 0; i < this.countSecond; i++) {
            this.valuesOfSecondSignal[i] = Integer.valueOf(
                    secondSubString[i]);
        }
    }
    /**
     * Method of system modifying arrays.
     * It adds a zero elements.
     * @since 1.0
     * */
    private void modifyArrays() {
        int[] buffer = new int[count];
        int j = 0;
        for (int i = 0; i <= count - countFirst; i++) {
            buffer[i] = 0;
            j = i;
        }
        for (int i = 0; i < countFirst; i++, j++) {
            buffer[j] = valuesOfFirstSignal[i];
        }
        valuesOfFirstSignal = buffer.clone();

        j = 0;
        for (int i = 0; i <= count - countSecond; i++) {
            buffer[i] = 0;
            j = i;
        }
        for (int i = 0; i < countSecond; i++, j++) {
            buffer[j] = valuesOfSecondSignal[i];
        }
        valuesOfSecondSignal = buffer.clone();
        for (int i = 0, y = count - 1; i < count; i++, y--) {
            valuesOfSecondSignal[i] = buffer[y];
        }
    }
}
