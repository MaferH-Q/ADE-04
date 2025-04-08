package Actividad4.Solucion3;

// =======================
// SOLUCIÓN 3: Divide y Vencerás
// =======================
// Clase Limits: Representa una parte (subarreglo) del arreglo principal
class Limits {
    int[] arreglo;     // Referencia al arreglo original
    int inicio, fin;   // Índices que indican el inicio y fin del subarreglo

    public Limits(int[] arreglo, int inicio, int fin) {
        this.arreglo = arreglo;
        this.inicio = inicio;
        this.fin = fin;
    }

    // Método que devuelve la longitud del subarreglo
    public int longitud() {
        return fin - inicio + 1;
    }
}
