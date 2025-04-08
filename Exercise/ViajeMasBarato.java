
package Exercise;

// ============================
// EJERCICIO 03: Viaje más barato en el río (Programación Dinámica)
// ============================
public class ViajeMasBarato {

    // Método para calcular el costo mínimo entre embarcaderos
    public static int[][] calcularCostos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        // Inicializar la matriz C
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) C[i][j] = 0; // costo cero al mismo punto
                else C[i][j] = T[i][j]; // copia los costos iniciales
            }
        }

        // Aplicamos programación dinámica para hallar el costo mínimo
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (T[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE) {
                        C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                    }
                }
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] T = {
            {0, 2, 9, INF},
            {INF, 0, 6, 4},
            {INF, INF, 0, 3},
            {INF, INF, INF, 0}
        };

        int[][] C = calcularCostos(T);

        // Mostrar la matriz de costos mínimos
        System.out.println("Costos mínimos entre embarcaderos:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                if (C[i][j] == INF) System.out.print("INF ");
                else System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
