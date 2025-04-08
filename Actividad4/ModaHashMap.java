package Actividad4;

// =======================
// SOLUCIÓN 1: HashMap
// =======================
import java.util.HashMap;

public class ModaHashMap {

    // Función para encontrar la moda usando HashMap
    public static int moda(int[] arr) {
        HashMap<Integer, Integer> frecuencia = new HashMap<>();

        // Paso 1: Contar las apariciones de cada número en el arreglo
        for (int num : arr) {
            // Si el número ya existe, suma 1. Si no, lo agrega con valor 1
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }

        // Paso 2: Inicializar variables para llevar el control de la moda
        int moda = arr[0];
        int maxFrecuencia = 0;

        // Paso 3: Buscar el número con mayor frecuencia en el mapa
        for (int num : frecuencia.keySet()) {
            int f = frecuencia.get(num);
            if (f > maxFrecuencia) {
                maxFrecuencia = f;
                moda = num;
            }
        }

        // Paso 4: Retornar la moda
        return moda;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 2, 3, 3, 3, 4};
        System.out.println("Moda (HashMap): " + moda(arreglo));
    }
}
