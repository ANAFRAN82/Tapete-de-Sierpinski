package tapete.de.sierpinski;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tapete extends JPanel {

    int nivel_de_recursividad = 5;  // Nivel de recursividad

    // Constructor para inicializar el panel
    public Tapete() { }

    // Sobreescribir el método paintComponent para dibujar
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Llama al método de la superclase para limpiar el fondo
        int size = Math.min(getWidth(), getHeight());
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;
        paintRecursivo(g, x, y, size, nivel_de_recursividad);
    }

    // Método recursivo para dibujar el tapete de Sierpinski
    private void paintRecursivo(Graphics g, int x, int y, int size, int nivel) {
        if (nivel == 0) {
            g.fillRect(x, y, size, size);
        } else {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        // Dejar el cuadrado central en blanco
                        g.setColor(Color.WHITE);
                        g.fillRect(x + newSize, y + newSize, newSize, newSize);
                        g.setColor(Color.BLACK);
                    } else {
                        // Llamada recursiva para los otros 8 cuadrados
                        paintRecursivo(g, x + i * newSize, y + j * newSize, newSize, nivel - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Crear el JFrame (ventana)
        JFrame frame = new JFrame("Tapete de Sierpinski");
        Tapete panel = new Tapete();  // Instanciar el panel que dibuja el tapete

        // Agregar el panel a la ventana
        frame.add(panel);
        frame.setSize(600, 600);  // Establecer el tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cerrar la ventana al salir
        frame.setVisible(true);  // Hacer visible la ventana
    }
}