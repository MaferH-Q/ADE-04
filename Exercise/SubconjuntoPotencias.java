
package Exercise;

// ============================
// EJERCICIO 01: Subconjunto de potencias restringidas
// ============================
public class SubconjuntoPotencias {

    // Método principal
    public static boolean esSumaValida(int[] arr, int index, int sumaActual, int objetivo) {
        if (index == arr.length) {
            return sumaActual == objetivo; // Caso base: llegamos al final
        }

        int actual = arr[index];

        // Si el número es potencia de 2, debe incluirse
        if ((actual & (actual - 1)) == 0) {
            return esSumaValida(arr, index + 1, sumaActual + actual, objetivo);
        }

        // Si el número es múltiplo de 5 y el siguiente es impar, no se puede incluir
        if (actual % 5 == 0 && index + 1 < arr.length && arr[index + 1] % 2 != 0) {
            return esSumaValida(arr, index + 1, sumaActual, objetivo);
        }

        // Opción 1: incluir el número
        boolean incluir = esSumaValida(arr, index + 1, sumaActual + actual, objetivo);
        // Opción 2: no incluir el número
        boolean excluir = esSumaValida(arr, index + 1, sumaActual, objetivo);

        return incluir || excluir;
    }

    public static void main(String[] args) {
        int[] ejemplo = {4, 8, 10, 3, 5};
        int objetivo = 27;
        System.out.println("Resultado: " + esSumaValida(ejemplo, 0, 0, objetivo));
    }
}