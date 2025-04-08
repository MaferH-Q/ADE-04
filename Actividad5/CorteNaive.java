package Actividad5;
// ============================
// Actividad 05 – Corte de Varilla
// ============================

// ======================================
// 1. Solución sin Programación Dinámica
// ======================================
public class CorteNaive {

    // Función recursiva para obtener el valor máximo posible
    static int getValue(int[] valores, int largo) {
        // Paso 1: Caso base, si la longitud es 0, no hay ganancia
        if (largo <= 0) return 0;

        int max = Integer.MIN_VALUE; // Guardamos el valor máximo encontrado

        // Paso 2: Probar todos los posibles cortes
        for (int i = 0; i < largo; i++) {
            // Se toma el valor de cortar en i+1 y se suma la solución recursiva del resto
            int resultado = valores[i] + getValue(valores, largo - i - 1);
            max = Math.max(max, resultado); // Se actualiza el máximo si el resultado es mayor
        }

        // Paso 3: Retornar el mejor valor encontrado
        return max;
    }

    public static void main(String[] args) {
        int[] valores = {3, 7, 1, 3, 9};
        int largo = valores.length;

        // Llamada al método recursivo sin DP
        System.out.println("Valor máximo (sin DP): " + getValue(valores, largo));
    }
}