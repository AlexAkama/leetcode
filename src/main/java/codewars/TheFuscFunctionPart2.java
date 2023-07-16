package codewars;


import java.math.BigInteger;

//
// https://www.codewars.com/kata/57040e445a726387a1001cf7/java
//
//fusc(0) = 0
//fusc(1) = 1
//fusc(2n) = fusc(n)
//fusc(2n + 1) = fusc(n) + fusc(n + 1)
public class TheFuscFunctionPart2 {

    public static BigInteger fusc(BigInteger n) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.ONE;
        for (int i = 0; i < n.bitLength(); i++) {
            if (n.testBit(i)) left = left.add(right);
            else right = right.add(left);
        }
        return left;
    }


}
