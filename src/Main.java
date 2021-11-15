class Mass implements Runnable{
    private final int left;
    private final int right;
    private static int s = 0;

    public int[] input_mass() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            //(int) Math.round((Math.random() + 30) - 15);
        }
        return array;
    }

    Mass(int l, int r) {
        this.left = l;
        this.right = r;
    }

    public void run() {
        for(int i = left; i < right; i++) {
            s += input_mass()[i];
        }
    }

    public static int getS() {
        return s;
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread obj = new Thread(new Mass(i*25, (i+1)*25));
            obj.start();
            try {
                obj.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Mass.getS());

    }
}