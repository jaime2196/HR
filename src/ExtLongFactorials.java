import java.math.BigInteger;

public class ExtLongFactorials {

    public static void main(String[] arg){
        extraLongFactorials(5);
    }

    public static void extraLongFactorials(int n) {
        System.out.println(factorial(n));

    }

    public static BigInteger factorial(int num){
        BigInteger res =BigInteger.valueOf(num);
        for(int i=1;i!=num;i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
