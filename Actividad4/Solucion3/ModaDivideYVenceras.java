package Actividad4.Solucion3;

public class ModaDivideYVenceras {

    public static int moda3(int[] a, int prim, int ult) {
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();

        // Paso 1: Insertar el arreglo completo como heterogéneo
        heterogeneo.insertar(new Limits(a, prim, ult));

        // Paso 2: Repetir hasta que el conjunto homogéneo sea más largo
        while (heterogeneo.longitudMayor() > homogeneo.longitudMayor()) {
            Limits p = heterogeneo.mayor();
            int mediana = p.arreglo[(p.inicio + p.fin) / 2]; // Mediana como pivote

            // Paso 3: Dividir el arreglo en < mediana, == mediana, > mediana
            int izq = p.inicio, der = p.inicio;
            while (der <= p.fin && p.arreglo[der] < mediana) der++;
            izq = der;
            while (der <= p.fin && p.arreglo[der] == mediana) der++;

            Limits p1 = new Limits(p.arreglo, p.inicio, izq - 1);
            Limits p2 = new Limits(p.arreglo, izq, der - 1);
            Limits p3 = new Limits(p.arreglo, der, p.fin);

            // Paso 4: Insertar en conjuntos correspondientes
            heterogeneo.insertar(p1);
            homogeneo.insertar(p2);
            heterogeneo.insertar(p3);
        }

        // Paso 5: Obtener la moda del subarreglo más grande en homogeneo
        if (homogeneo.esVacio()) return a[prim];

        Limits moda = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();
        return moda.arreglo[moda.inicio];
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 3, 3, 4, 5, 3};
        System.out.println("Moda (Divide y Vencerás): " + moda3(arreglo, 0, arreglo.length - 1));
    }
}
