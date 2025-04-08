package Exercise;

// ============================
// EJERCICIO 02: K-ésimo menor elemento (QuickSelect)
// ============================

public class QuickSelect {

    // Función para encontrar el k-ésimo menor usando divide y vencerás
    public static int quickSelect(int[] arr, int k) {
        return quickSelectHelper(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelectHelper(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return quickSelectHelper(arr, left, pivotIndex - 1, k);
        else return quickSelectHelper(arr, pivotIndex + 1, right, k);
    }

    // Partición como en quicksort
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] arreglo = {4, 2, 7, 10, 4, 17};
        int k = 3;
        System.out.println("El " + k + "-ésimo menor es: " + quickSelect(arreglo, k));
    }
}