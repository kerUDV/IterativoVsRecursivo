package benchmark;

import algorithms.*;
import utils.GeneradorDatos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    private static final int[] TAMANOS_PEQUENOS = {5, 10, 15, 20, 25, 30};
    private static final int[] TAMANOS_GRANDES = {100, 500, 1000, 5000, 10000};

    private static final String CSV_PATH = "resultados/tiempos.csv";
    private static final long SEED = 12345L;

    public static void main(String[] args) {
        imprimirBanner();

        StringBuilder csv = new StringBuilder();
        csv.append("Algoritmo,Version,n,Ej1_ms,Ej2_ms,Ej3_ms,Ej4_ms,Ej5_ms\n");

        correrFactorial(csv);
        correrFibonacci(csv);
        correrBusquedaLineal(csv);
        correrBurbuja(csv);

        exportarCSV(csv.toString());

        System.out.println("\n============================================================");
        System.out.println("  Resultados exportados → " + CSV_PATH);
        System.out.println("============================================================");
    }

    private static void correrFactorial(StringBuilder csv) {
        System.out.println("\n  A1 - FACTORIAL");
        Medidor.imprimirEncabezado();

        for (int n : TAMANOS_PEQUENOS) {
            //if (n > 20) continue; // factorial max 20
            final int fn = n;

            double[] it = Medidor.medirDetalle(() -> Factorial.iterativo(fn));
            double[] re = Medidor.medirDetalle(() -> Factorial.recursivo(fn));

            Medidor.imprimirFila("Factorial", "Iterativo", n, promedio(it));
            Medidor.imprimirFila("Factorial", "Recursivo", n, promedio(re));

            csv.append(filaCSV("A1 - Factorial", "Iterativo", n, it));
            csv.append(filaCSV("A1 - Factorial", "Recursivo", n, re));
        }
    }

    private static void correrFibonacci(StringBuilder csv) {
        System.out.println("\n  A2 - FIBONACCI");
        Medidor.imprimirEncabezado();

        for (int n : TAMANOS_PEQUENOS) {
            final int fn = n;

            double[] it = Medidor.medirDetalle(() -> Fibonacci.iterativo(fn));
            double[] re = Medidor.medirDetalle(() -> Fibonacci.recursivo(fn)); // <= 30

            Medidor.imprimirFila("Fibonacci", "Iterativo", n, promedio(it));
            Medidor.imprimirFila("Fibonacci", "Recursivo", n, promedio(re));

            csv.append(filaCSV("A2 - Fibonacci", "Iterativo", n, it));
            csv.append(filaCSV("A2 - Fibonacci", "Recursivo", n, re));
        }
    }

    private static void correrBusquedaLineal(StringBuilder csv) {
        System.out.println("\n  A3 - BUSQUEDA LINEAL");
        Medidor.imprimirEncabezado();

        for (int n : TAMANOS_GRANDES) {
            int[] arr = GeneradorDatos.arregloAleatorio(n, SEED);
            int target = GeneradorDatos.valorExistente(arr);

            final int[] a = arr;
            final int t = target;

            double[] it = Medidor.medirDetalle(() -> BusquedaLineal.iterativa(a, t));
            double[] re = Medidor.medirDetalle(() -> BusquedaLineal.recursiva(a, t));

            Medidor.imprimirFila("Busqueda", "Iterativo", n, promedio(it));
            Medidor.imprimirFila("Busqueda", "Recursivo", n, promedio(re));

            csv.append(filaCSV("A3 - Busqueda Lineal", "Iterativo", n, it));
            csv.append(filaCSV("A3 - Busqueda Lineal", "Recursivo", n, re));
        }
    }

    private static void correrBurbuja(StringBuilder csv) {
        System.out.println("\n  A4 - ORDENAMIENTO BURBUJA");
        Medidor.imprimirEncabezado();

        for (int n : TAMANOS_GRANDES) {
            int[] base = GeneradorDatos.arregloAleatorio(n, SEED);

            // OJO: cada ejecución debe ordenar una copia fresca
            double[] it = Medidor.medirDetalle(() -> {
                int[] copia = base.clone();
                OrdenamientoBurbuja.iterativo(copia);
            });

            double[] re = Medidor.medirDetalle(() -> {
                int[] copia = base.clone();
                OrdenamientoBurbuja.recursivo(copia);
            });

            Medidor.imprimirFila("Burbuja", "Iterativo", n, promedio(it));
            Medidor.imprimirFila("Burbuja", "Recursivo", n, promedio(re));

            csv.append(filaCSV("A4 - Burbuja", "Iterativo", n, it));
            csv.append(filaCSV("A4 - Burbuja", "Recursivo", n, re));
        }
    }

    private static String filaCSV(String algoritmo, String version, int n, double[] t) {
        return String.format(
                "%s,%s,%d,%.6f,%.6f,%.6f,%.6f,%.6f%n",
                algoritmo, version, n,
                t[0], t[1], t[2], t[3], t[4]
        );
    }

    private static double promedio(double[] arr) {
        double s = 0;
        for (double v : arr) s += v;
        return s / arr.length;
    }

    private static void imprimirBanner() {
        System.out.println("============================================================");
        System.out.println("  ESTRUCTURA DE DATOS — BENCHMARK ITERATIVO VS RECURSIVO");
        System.out.println("============================================================");
    }

    private static void exportarCSV(String contenido) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_PATH))) {
            pw.print(contenido);
            System.out.println("\n  ✓ CSV generado exitosamente en: " + CSV_PATH);
        } catch (IOException e) {
            System.err.println("  ✗ Error al escribir CSV: " + e.getMessage());
        }
    }
}