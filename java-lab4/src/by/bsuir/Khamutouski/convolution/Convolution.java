package by.bsuir.Khamutouski.convolution;

public class Convolution {

    private static final String SPACE = " ";

    private String firstSignal;
    private String secondSignal;
    private int countFirst;
    private int countSecond;
    private int count;
    private int[] valuesOfFirstSignal;
    private int[] valuesOfSecondSignal;
    private int result = 0;

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
    public String compute() {
        this.fillArrays();
        this.modifyArrays();

        for (int move = 0; move < count; move++) {
            IterationConvolution iterationConvolution
                    = new IterationConvolution(valuesOfFirstSignal,
                    valuesOfSecondSignal, count
            );
            try {
                iterationConvolution.join();
            }catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            synchronized (iterationConvolution) {
                result += iterationConvolution.getResult();
            }
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
