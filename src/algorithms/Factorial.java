package algorithms;

import java.math.BigInteger;

public class Factorial {

    public static BigInteger iterativo(int n) {
        if (n < 0) throw new IllegalArgumentException("n no puede ser negativo");

        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static BigInteger recursivo(int n) {
        if (n < 0) throw new IllegalArgumentException("n no puede ser negativo");

        if (n == 0 || n == 1) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(recursivo(n - 1));
    }
}