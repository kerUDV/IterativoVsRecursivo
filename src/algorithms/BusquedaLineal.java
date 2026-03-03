package algorithms;

public class BusquedaLineal {

    // O(n)
    public static int iterativa(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // O(n) - reduce subproblema en cada llamada (idx+1)
    public static int recursiva(int[] arr, int target) {
        return recursiva(arr, target, 0);
    }

    private static int recursiva(int[] arr, int target, int idx) {
        if (idx >= arr.length) return -1;
        if (arr[idx] == target) return idx;
        return recursiva(arr, target, idx + 1);
    }
}