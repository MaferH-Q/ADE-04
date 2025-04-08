package Actividad5;

// ======================================
// 2. Solución con Programación Dinámica
// ======================================
public class CorteDP {

    // Función para obtener el valor máximo usando programación dinámica
    static int getValue(int[] valores, int largo) {
        // Paso 1: Crear un arreglo para almacenar las soluciones parciales
        int[] dp = new int[largo + 1];

        // Paso 2: Llenar el arreglo dp de manera ascendente
        for (int i = 1; i <= largo; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                // Se compara el valor actual con el valor de cortar en j+1 más la solución del resto
                max = Math.max(max, valores[j] + dp[i - j - 1]);
            }
            dp[i] = max; // Guardamos la mejor solución para la varilla de longitud i
        }

        // Paso 3: Retornar el valor máximo para la longitud completa
        return dp[largo];
    }

    public static void main(String[] args) {
        int[] valores = {3, 7, 1, 3, 9};
        int largo = valores.length;

        // Llamada al método con programación dinámica
        System.out.println("Valor máximo (con DP): " + getValue(valores, largo));
    }
}
