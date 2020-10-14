public class Program {

    public static void main(String[] args) {

        int num = 479598;

        int result = num / 100000;

        num %= 100000;

        result += num / 10000;

        num %= 10000;

        result += num / 1000;

        num %= 1000;
        
        result += num / 100;
        
        num %= 100;
        
        result += num / 10;
        
        num %= 10;

        result += num;
        
        System.out.println(result);
    }
}
