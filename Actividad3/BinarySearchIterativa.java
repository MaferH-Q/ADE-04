package Actividad3;
// =======================
// 2. Versión Iterativa
// =======================
public class BinarySearchIterativa {

    // Método iterativo para búsqueda binaria
    int binarySearch(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;

        // Paso 1: Mientras el rango sea válido
        while (lo <= hi) {
            // Paso 2: Calcular el punto medio
            int mid = lo + (hi - lo) / 2;

            // Paso 3: Verificar si encontramos el valor
            if (arr[mid] == x)
                return mid;

            // Paso 4: Si el valor buscado es mayor, mover a la mitad derecha
            if (arr[mid] < x)
                lo = mid + 1;
            // Paso 5: Si el valor buscado es menor, mover a la mitad izquierda
            else
                hi = mid - 1;
        }

        // Paso 6: Si el valor no fue encontrado
        return -1;
    }
    // Método principal para probar la búsqueda iterativa
    public static void main(String[] args) {
        BinarySearchIterativa buscador = new BinarySearchIterativa();

        // Arreglo ordenado para buscar
        int[] arreglo = {1, 2, 3, 4, 5};

        // Valor a buscar
        int x = 3;

        // Llamamos al método de búsqueda iterativa
        int resultado = buscador.binarySearch(arreglo, x);

        // Mostramos el resultado
        if (resultado == -1)
            System.out.println("Elemento no encontrado");
        else
            System.out.println("Elemento encontrado en índice: " + resultado);
    }
}
