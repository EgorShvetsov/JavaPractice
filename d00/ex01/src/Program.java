import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        if (num <= 1) {
            System.out.println("Illegal Argument");
            System.exit(-1);
        }

        else {
            isPrime(num);
        }
    }

    static void isPrime(final int num) {

        int stepsCalc = 1;

        long longNum = num;

        boolean resultFlag = true;

        for (long i = 2; i * i <= longNum; i++) {

            if (longNum % i == 0) {
                resultFlag = false;
                break ;
            }
            stepsCalc++;
        }

        System.out.println(resultFlag + " " + stepsCalc);
    }
}
