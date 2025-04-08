package Actividad4;

// =======================
// SOLUCIÓN 2: Arreglo Ordenado
// =======================
import java.util.Arrays;

public class ModaOrdenado {

    // Función para encontrar la moda en un arreglo ordenado
    public static int moda(int[] arr) {
        Arrays.sort(arr); // Paso 1: Ordenar el arreglo

        // Paso 2: Inicializar variables para contar frecuencias
        int moda = arr[0];
        int maxFrecuencia = 1;
        int actual = arr[0];
        int frecuenciaActual = 1;

        // Paso 3: Recorrer el arreglo para contar frecuencias consecutivas
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == actual) {
                frecuenciaActual++; // Mismo número, incrementa la frecuencia
            } else {
                // Nuevo número, comparar frecuencia anterior con máxima
                if (frecuenciaActual > maxFrecuencia) {
                    maxFrecuencia = frecuenciaActual;
                    moda = actual;
                }
                actual = arr[i]; // Actualizamos el número actual
                frecuenciaActual = 1; // Reiniciar frecuencia
            }
        }

        // Paso 4: Verificar la última secuencia
        if (frecuenciaActual > maxFrecuencia) {
            moda = actual;
        }

        // Paso 5: Retornar la moda
        return moda;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 2, 3, 3, 3, 4};
        System.out.println("Moda (ordenado): " + moda(arreglo));
    }
}