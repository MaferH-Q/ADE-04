package Actividad4;

// =======================
// SOLUCIÓN 1: HashMap
// =======================
import java.util.HashMap;

public class ModaHashMap {

// Este método encuentra la moda del arreglo usando un mapa de frecuencias
public static int moda(int[] arr) {
    // Creamos un HashMap para contar cuántas veces aparece cada número
    HashMap<Integer, Integer> frecuencia = new HashMap<>();

    // Recorremos el arreglo
    for (int num : arr) {
        // Si el número ya está, le sumamos 1. Si no está, lo agregamos con 1
        frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
    }

    // Vamos a buscar el número con mayor frecuencia
    int moda = arr[0]; // asumimos que el primero es la moda
    int maxFrecuencia = 0; // inicializamos la frecuencia máxima

    // Recorremos el mapa para ver quién tiene la frecuencia más alta
    for (int num : frecuencia.keySet()) {
        int f = frecuencia.get(num);
        if (f > maxFrecuencia) {
            maxFrecuencia = f;
            moda = num;
        }
    }

    return moda; // devolvemos el número más repetido
}

public static void main(String[] args) {
    int[] arreglo = {1, 2, 2, 3, 3, 3, 4};
    System.out.println("La moda es: " + moda(arreglo));
}
}