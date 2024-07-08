import java.util.Scanner;

class Avg extends Thread {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < Multithreading.numbers.length; i++) {
            sum += Multithreading.numbers[i];
        }
        int average = sum / Multithreading.numbers.length;
        System.out.println("Average: " + average);
    }
}

class MaxNo implements Runnable {
    @Override
    public void run() {
        int max = Multithreading.numbers[0];
        for (int i = 1; i < Multithreading.numbers.length; i++) {
            if (Multithreading.numbers[i] > max) {
                max = Multithreading.numbers[i];
            }
        }
        System.out.println("Max number: " + max);
    }
}

class MinNo implements Runnable {
    @Override
    public void run() {
        int min = Multithreading.numbers[0];
        for (int i = 1; i < Multithreading.numbers.length; i++) {
            if (Multithreading.numbers[i] < min) {
                min = Multithreading.numbers[i];
            }
        }
        System.out.println("Min number: " + min);
    }
}

public class Multithreading {
    public static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n = scanner.nextInt();
        numbers = new int[n];
        System.out.println("Enter the numbers : ");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Thread averageThread = new Avg();
        Thread maxThread = new Thread(new MaxNo());
        Thread minThread = new Thread(new MinNo());

        averageThread.start();
        maxThread.start();
        minThread.start();
    }
}
