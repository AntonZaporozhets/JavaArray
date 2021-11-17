import java.util.Arrays;


class Mass implements Runnable{
    private final int[] arr;
    private int s;
    public int sum;

    Mass(int[] a) {
        this.arr = a;
    }

    public void run() {
        for (int j : arr) {
            s += j;
            //System.out.printf("%s: %s \n", Thread.currentThread().getName(), s);
        }
        this.sum = s;
    }

    public int getSum() {
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            //(int) Math.round((Math.random()*200 - 100));
        }

        Mass thr1 = new Mass(Arrays.copyOfRange(array, 0, 25));
        Thread obj1 = new Thread(thr1);
        obj1.start();
        Mass thr2 = new Mass(Arrays.copyOfRange(array, 25, 50));
        Thread obj2 = new Thread(thr2);
        obj2.start();
        Mass thr3 = new Mass(Arrays.copyOfRange(array, 50, 75));
        Thread obj3 = new Thread(thr3);
        obj3.start();
        Mass thr4 = new Mass(Arrays.copyOfRange(array, 75, 100));
        Thread obj4 = new Thread(thr4);
        obj4.start();
        try {
            obj1.join();
            obj2.join();
            obj3.join();
            obj4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int res = thr1.getSum()+thr2.getSum()+thr3.getSum()+thr4.getSum();
        System.out.println(res);

    }
}