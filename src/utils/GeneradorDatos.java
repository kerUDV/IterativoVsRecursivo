package utils;

import java.util.Random;

public class GeneradorDatos {

    public static int[] arregloAleatorio(int n, long seed) {
        Random r = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(n * 10);
        return a;
    }

    public static int valorExistente(int[] a) {
        return a[a.length / 2];
    }
}