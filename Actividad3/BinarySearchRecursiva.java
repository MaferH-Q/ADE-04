package Actividad3;
// =======================
// 1. Versión Recursiva
// =======================
public class BinarySearchRecursiva {

   // Este método realiza la búsqueda binaria usando recursividad
   int binarySearch(int[] arr, int lo, int hi, int x) {
    // Paso 1: Verificar si ya no hay más elementos por revisar
    if (hi < lo)
        return -1; // No se encontró el valor

    // Paso 2: Calcular la posición del medio del arreglo actual
    int mid = lo + (hi - lo) / 2;

    // Paso 3: Si el valor medio es el que buscamos, lo retornamos
    if (arr[mid] == x)
        return mid;

    // Paso 4: Si el valor medio es mayor al que buscamos, buscar en la izquierda
    if (arr[mid] > x)
        return binarySearch(arr, lo, mid - 1, x);

    // Paso 5: Si el valor medio es menor, buscar en la derecha
    return binarySearch(arr, mid + 1, hi, x);
}

// Método principal para probar la búsqueda recursiva
public static void main(String[] args) {
    BinarySearchRecursiva buscador = new BinarySearchRecursiva();

    // Creamos un arreglo ordenado
    int[] arreglo = {1, 2, 3, 4, 5};

    // Indicamos el número que queremos buscar
    int x = 4;

    // Llamamos al método de búsqueda
    int resultado = buscador.binarySearch(arreglo, 0, arreglo.length - 1, x);

    // Mostramos el resultado de la búsqueda
    if (resultado == -1)
        System.out.println("Elemento no encontrado");
    else
        System.out.println("Elemento encontrado en índice: " + resultado);
}
}
