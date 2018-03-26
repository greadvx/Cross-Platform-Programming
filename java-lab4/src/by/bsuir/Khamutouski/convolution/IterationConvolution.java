package by.bsuir.Khamutouski.convolution;

public class IterationConvolution extends Thread {

    private int result = 0;
    private int[] firstArray;
    private int[] secondArray;
    private int count;

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
    //MARK: running new thread.
     public void run() {
        this.count();
    }
    public void count() {
        for (int i = 0; i < count; i++) {
            result += firstArray[i] * secondArray[i];
        }
    }
    public int getResult()  {
        return this.result;
    }
}
