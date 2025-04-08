package Actividad2;

/// ==============================================
// Árbol de Pitágoras //
// ==============================================

import javax.swing.*;   // Librería para crear la ventana
import java.awt.*;      // Librería para dibujar en la pantalla

public class PythagorasTree extends JPanel {

    // Variable que indica hasta qué nivel se dibujará el árbol
    private int profundidad;

    // Constructor que recibe la profundidad como parámetro
    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad; // Guardamos la profundidad deseada

        // Le decimos al panel que tendrá un tamaño de 800 x 800 píxeles
        setPreferredSize(new Dimension(800, 800));
    }

    // Este método se ejecuta automáticamente cuando se dibuja el panel
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia la pantalla antes de dibujar

        // Usamos Graphics2D para tener más control sobre el dibujo
        Graphics2D g2d = (Graphics2D) g;

        // Establecemos el color de fondo en negro
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight()); // Pintamos todo el fondo de negro

        // Ahora cambiamos el color a verde para dibujar el árbol
        g2d.setColor(Color.GREEN);

        // Llamada inicial al método recursivo para dibujar el árbol
        // Empezamos desde el punto (350, 600), con una rama de longitud 100 y ángulo -90° (hacia arriba)
        trazaArbol(g2d, 350, 600, 100, -90, profundidad);
    }

    /**
     * Método recursivo que dibuja el árbol.
     * Cada llamada dibuja una línea y luego llama a sí misma para hacer las ramas izquierda y derecha.
     * @param g      el objeto gráfico donde se dibuja
     * @param x      coordenada x donde comienza la rama
     * @param y      coordenada y donde comienza la rama
     * @param lado   longitud de la rama actual
     * @param angulo dirección en que se dibuja la rama (en grados)
     * @param nivel  cuántos niveles de profundidad faltan por dibujar
     */
    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        // Caso base: si ya no hay más niveles o la rama es muy corta, detenemos
        if (nivel == 0 || lado < 2) return;

        // Calculamos las coordenadas del punto final de la línea usando trigonometría
        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        // Dibujamos la rama desde (x, y) hasta (x2, y2)
        g.drawLine(x, y, x2, y2);

        // Calculamos el nuevo tamaño de la rama (más corto)
        int nuevoLado = (int) (lado * 0.7); // Cada rama será 70% del tamaño anterior

        // Dibujamos la rama izquierda (ángulo - 45°)
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);

        // Dibujamos la rama derecha (ángulo + 45°)
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }

    // Este es el método principal que inicia el programa
    public static void main(String[] args) {
        // Creamos una ventana llamada "Árbol de Pitágoras Mejorado"
        JFrame ventana = new JFrame("Árbol de Pitágoras Mejorado");

        // Agregamos nuestro panel personalizado con una profundidad de 10 niveles
        ventana.add(new PythagorasTree(10));

        // Configuramos la ventana para que se cierre cuando la usuaria la cierre
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajustamos el tamaño de la ventana automáticamente según el panel
        ventana.pack();

        // Hacemos que la ventana se muestre en pantalla
        ventana.setVisible(true);
    }
}
