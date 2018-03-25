package by.bsuir.Khamutouski.convolution;

import java.util.Arrays;
import java.util.Collections;

public class Convolution {

    private static final String SPACE = " ";

    private String firstSignal;
    private String secondSignal;
    private int countFirst;
    private int countSecond;
    private int[] valuesOfFirstSignal;
    private int[] valuesOfSecondSignal;

    public Convolution(final String firstSignal,
                       final int countFirst,
                       final String secondSignal,
                       final int countSecond
    ) {
        this.firstSignal = firstSignal;
        this.secondSignal = secondSignal;
        this.countFirst = countFirst;
        this.countSecond = countSecond;
        valuesOfFirstSignal = new int[countFirst];
        valuesOfSecondSignal = new int[countSecond];
    }
    public String compute() {
        this.fillArrays();
        Collections.reverse(Arrays.asList(valuesOfSecondSignal));

        //TODO: Algorithm. New Threads to compute.


        return "none";
    }
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
}
