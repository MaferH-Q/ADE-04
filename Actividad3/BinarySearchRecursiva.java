package Actividad3;
// =======================
// 1. Versión Recursiva
// =======================
public class BinarySearchRecursiva {

    // Método recursivo para búsqueda binaria
    int binarySearch(int[] arr, int lo, int hi, int x) {
        // Paso 1: Verificar si hay elementos en el rango
        if (hi >= lo) {
            // Paso 2: Calcular el índice del medio
            int mid = lo + (hi - lo) / 2;

            // Paso 3: Verificar si encontramos el elemento
            if (arr[mid] == x)
                return mid;

            // Paso 4: Si el valor es menor, buscar en la mitad izquierda
            if (arr[mid] > x)
                return binarySearch(arr, lo, mid - 1, x);

            // Paso 5: Si el valor es mayor, buscar en la mitad derecha
            return binarySearch(arr, mid + 1, hi, x);
        }

        // Paso 6: Si no lo encontramos
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchRecursiva bs = new BinarySearchRecursiva();
        int[] arr = {1, 2, 3, 4, 5};
        int x = 4;

        int posicion = bs.binarySearch(arr, 0, arr.length - 1, x);

        if (posicion == -1)
            System.out.println("Elemento no encontrado");
        else
            System.out.println("Elemento encontrado en índice: " + posicion);
    }
}