package Actividad4.Solucion3;

// =======================
// SOLUCIÓN 3: Divide y Vencerás
// =======================
import java.util.ArrayList;

class SetVectors {
    private ArrayList<Limits> subconjuntos;

    public SetVectors() {
        subconjuntos = new ArrayList<>();
    }

    public void insertar(Limits l) {
        if (l.longitud() > 0)
            subconjuntos.add(l);
    }

    public boolean esVacio() {
        return subconjuntos.isEmpty();
    }

    public Limits mayor() {
        Limits mayor = subconjuntos.get(0);
        for (Limits l : subconjuntos) {
            if (l.longitud() > mayor.longitud())
                mayor = l;
        }
        subconjuntos.remove(mayor);
        return mayor;
    }

    public int longitudMayor() {
        int max = 0;
        for (Limits l : subconjuntos) {
            if (l.longitud() > max)
                max = l.longitud();
        }
        return max;
    }

    public void destruir() {
        subconjuntos.clear();
    }
}