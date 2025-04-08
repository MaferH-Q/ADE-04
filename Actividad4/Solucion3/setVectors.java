package Actividad4.Solucion3;

// =======================
// SOLUCIÓN 3: Divide y Vencerás
// =======================
import java.util.ArrayList;

// Clase SetVectors: Gestiona subconjuntos homogéneos y heterogéneos

class SetVectors {
    private ArrayList<Limits> subconjuntos = new ArrayList<>();

    // Insertamos un subarreglo si tiene al menos un elemento
    public void insertar(Limits l) {
        if (l.longitud() > 0) subconjuntos.add(l);
    }

    // Verifica si el conjunto está vacío
    public boolean esVacio() {
        return subconjuntos.isEmpty();
    }

    // Devuelve el subarreglo con más elementos y lo elimina del conjunto
    public Limits mayor() {
        Limits mayor = subconjuntos.get(0);
        for (Limits l : subconjuntos) {
            if (l.longitud() > mayor.longitud()) mayor = l;
        }
        subconjuntos.remove(mayor);
        return mayor;
    }

    // Obtiene la longitud del subconjunto más largo
    public int longitudMayor() {
        int max = 0;
        for (Limits l : subconjuntos) {
            if (l.longitud() > max) max = l.longitud();
        }
        return max;
    }

    // Limpia todos los subconjuntos
    public void destruir() {
        subconjuntos.clear();
    }
}
