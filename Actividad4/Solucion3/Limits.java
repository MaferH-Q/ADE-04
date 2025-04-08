package Actividad4.Solucion3;

// =======================
// SOLUCIÓN 3: Divide y Vencerás
// =======================
class Limits {
    int[] arreglo;
    int inicio, fin;

    public Limits(int[] arreglo, int inicio, int fin) {
        this.arreglo = arreglo;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int longitud() {
        return fin - inicio + 1;
    }
}

