package Actividad4;

// =======================
// SOLUCIÓN 2: Arreglo Ordenado
// =======================
import java.util.Arrays;

public class ModaOrdenado {

    public static int moda(int[] arr) {
        Arrays.sort(arr); // ordenamos el arreglo para juntar iguales

        // Variables para llevar el control
        int moda = arr[0];
        int maxFrecuencia = 1;
        int actual = arr[0];
        int frecuenciaActual = 1;

        // Recorremos desde el segundo elemento
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == actual) {
                frecuenciaActual++; // seguimos contando
            } else {
                // comparamos si esa secuencia fue la más larga
                if (frecuenciaActual > maxFrecuencia) {
                    maxFrecuencia = frecuenciaActual;
                    moda = actual;
                }
                // reiniciamos los contadores
                actual = arr[i];
                frecuenciaActual = 1;
            }
        }

        // Última verificación al salir del bucle
        if (frecuenciaActual > maxFrecuencia) {
            moda = actual;
        }

        return moda;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 2, 3, 3, 3, 4};
        System.out.println("La moda ordenada es: " + moda(arreglo));
    }
}