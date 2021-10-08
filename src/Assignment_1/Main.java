package Assignment_1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        System.out.println(number);
    }
}
