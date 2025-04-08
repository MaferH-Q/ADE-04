package Actividad1;

public class Hanoi {

    public static void main(String[] args) {
        // Llamamos al método para 3 discos, de torre 1 a torre 3, usando la torre 2 como auxiliar
        torresHanoi(3, 1, 2, 3);
    }

    // Método recursivo que resuelve el problema de las Torres de Hanoi
    public static void torresHanoi(int discos, int origen, int auxiliar, int destino) {
        // Caso base: si solo hay un disco, moverlo directamente
        if (discos == 1) {
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
        } else {
            // Paso 1: mover n-1 discos del origen al auxiliar
            torresHanoi(discos - 1, origen, destino, auxiliar);
            // Paso 2: mover el disco más grande al destino
            System.out.println("Mover disco de torre " + origen + " a torre " + destino);
            // Paso 3: mover los n-1 discos desde el auxiliar al destino
            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
    }
}

