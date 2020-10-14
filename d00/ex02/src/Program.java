import java.util.Scanner;

public class Program {

    static public void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num;

        int correctRequestsCalc = 0;

        while ((num = scanner.nextInt()) != 42) {

            if (isPrime(getDigitsSum(num))) {
                correctRequestsCalc++;
            }
        }

        System.out.println("Count of coffee-request - " + correctRequestsCalc);
    }



    static int getDigitsSum(int num) {

        int digitsCalc = 1;

        int result = 0;

        int digitsCalcCalculator = num;


        if (num < 0) {
            num *= -1;
        }

        while (digitsCalcCalculator / 10 != 0) {
            digitsCalcCalculator /= 10;
            digitsCalc *= 10;
        }

        while (digitsCalc > 1) {
            result  += num / digitsCalc;
            num %= digitsCalc;
            digitsCalc /= 10;
        }

        result += num;

        return result;
    }

    static boolean isPrime(final int num) {

        long longNum = num;

        boolean resultFlag = true;

        for (long i = 2; i * i <= longNum; i++) {

            if (longNum % i == 0) {
                resultFlag = false;
                break ;
            }
        }

        return resultFlag;
    }
}

