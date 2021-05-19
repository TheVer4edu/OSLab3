import java.util.stream.IntStream;

public class Main {


    public static class SampleMean extends Thread {

        private static StateInt result = new StateInt(0);
        private static StateInt count = new StateInt(1);
        private static final int N = 10;
        private static final int neX = deemNeX();

        @Override
        public void run() {
            int x;
            super.run();
            while ((x = count.increment()) <= N) {
                result.add((int) Math.pow((x - neX), 2));
                System.out.println(String.format("X = %d, RES = %d", x,  result.getValue()));
            }
        }

        public static int getResult() {
            return result.getValue();
        }

        private static int deemNeX() {
            return (int) IntStream.rangeClosed(count.getValue(), N).average().getAsDouble();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        SampleMean sm = new SampleMean();
        SampleMean sm2 = new SampleMean();
        sm.start();
        sm2.start();
        sm.join();
        sm2.join();
        System.out.println(String.format("RESULT IS: %d", SampleMean.getResult()));
    }

}
