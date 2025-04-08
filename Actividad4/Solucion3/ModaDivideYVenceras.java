package Actividad4.Solucion3;

//Clase principal que contiene el algoritmo de Divide y Vencerás
public class ModaDivideYVenceras {

    // Método principal para encontrar la moda
    public static int moda3(int[] a, int prim, int ult) {
        // Creamos dos conjuntos:
        // - uno para los subconjuntos homogéneos (todos los valores iguales)
        // - otro para los heterogéneos (mezclados)
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();

        // Al inicio, todo el arreglo es considerado heterogéneo
        heterogeneo.insertar(new Limits(a, prim, ult));

        // Mientras haya un subconjunto heterogéneo más largo que los homogéneos...
        while (heterogeneo.longitudMayor() > homogeneo.longitudMayor()) {
            // Tomamos el subconjunto heterogéneo más largo
            Limits p = heterogeneo.mayor();

            // Elegimos la mediana (el valor del centro) como punto de referencia
            int mediana = p.arreglo[(p.inicio + p.fin) / 2];

            // Vamos a dividir este subconjunto en tres partes:
            // - menores que la mediana
            // - iguales a la mediana (posible moda)
            // - mayores que la mediana
            int izq = p.inicio, der = p.inicio;

            // Recorremos los menores
            while (der <= p.fin && p.arreglo[der] < mediana) der++;
            izq = der;

            // Recorremos los iguales a la mediana
            while (der <= p.fin && p.arreglo[der] == mediana) der++;

            // Creamos los tres subconjuntos
            Limits p1 = new Limits(p.arreglo, p.inicio, izq - 1); // menores
            Limits p2 = new Limits(p.arreglo, izq, der - 1);      // iguales (homogéneo)
            Limits p3 = new Limits(p.arreglo, der, p.fin);        // mayores

            // Insertamos cada subconjunto en su grupo correspondiente
            heterogeneo.insertar(p1); // aún mezclados
            homogeneo.insertar(p2);   // todos iguales → candidatos a moda
            heterogeneo.insertar(p3);
        }

        // Cuando ya no quedan heterogéneos más largos, tomamos la moda
        if (homogeneo.esVacio()) return a[prim];

        // Tomamos el subconjunto homogéneo más largo
        Limits moda = homogeneo.mayor();

        // Limpiamos los conjuntos (por buena práctica)
        homogeneo.destruir();
        heterogeneo.destruir();

        // Retornamos el valor que más se repitió (el del primer índice del homogéneo)
        return moda.arreglo[moda.inicio];
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 3, 3, 4, 5, 3};
        System.out.println("🌼 La moda usando Divide y Vencerás es: " + moda3(arreglo, 0, arreglo.length - 1));
    }
}
