package algorithms;

public class OrdenamientoBurbuja {

    // O(n^2)
    public static void iterativo(int[] arr) {
        int n = arr.length;
        for (int pass = 0; pass < n - 1; pass++) {
            for (int i = 1; i < n - pass; i++) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    // O(n^2) versión recursiva que ordena correctamente
    public static void recursivo(int[] arr) {
        burbujaRec(arr, arr.length);
    }

    private static void burbujaRec(int[] arr, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                int tmp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = tmp;
            }
        }
        burbujaRec(arr, n - 1);
    }
}