/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author isard
 */
// La clase Oca hereda de JFrame y maneja eventos con ActionListener
public class Oca extends JFrame implements ActionListener {

    // Declaración de etiquetas para representar las casillas del juego y el mensaje de preguntas
    JLabel c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    JLabel preguntas;

    // Declaración de colores para casillas, fondo y jugador
    Color casillas, fondo, jugador;

    // Botón para lanzar el dado
    JButton movimiento;

    // Variables para controlar el dado, posición del jugador y vueltas
    int dado, player, vuelta;

    // Constructor de la clase
    public Oca() {
        super("Bienvenido al juego de La Oca"); // Título de la ventana
        this.setSize(600, 400); // Tamaño de la ventana
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finaliza el programa al cerrar
        objetos(); // Llama al método que configura los componentes
        this.getContentPane().setBackground(fondo); // Establece el color de fondo
        this.setVisible(true); // Muestra la ventana
    }

    // Método que configura todos los objetos visuales del juego
    public void objetos() {
        // Inicializa colores personalizados
        casillas = new Color(153, 255, 255); // Azul claro para las casillas
        fondo = new Color(0, 0, 255); // Azul fuerte para el fondo
        jugador = new Color(0, 0, 0); // Negro para representar al jugador

        // Inicialización de etiquetas para cada casilla del tablero
        c0 = new JLabel(""); c1 = new JLabel(""); c2 = new JLabel(""); c3 = new JLabel("");
        c4 = new JLabel(""); c5 = new JLabel(""); c6 = new JLabel(""); c7 = new JLabel("");
        c8 = new JLabel(""); c9 = new JLabel(""); c10 = new JLabel("");

        // Etiqueta de mensaje principal
        preguntas = new JLabel("ESTA ES MI HISTORIA");
        Font letra = new Font("Arial", Font.BOLD, 18); // Fuente personalizada
        preguntas.setFont(letra);

        // Botón para lanzar el dado
        movimiento = new JButton("Dado");

        // Diseño absoluto (sin layout manager)
        this.setLayout(null);

        // Posicionamiento de cada casilla
        c0.setBounds(10, 10, 50, 50);
        c1.setBounds(70, 10, 50, 50);
        c2.setBounds(130, 10, 50, 50);
        c3.setBounds(190, 10, 50, 50);
        c4.setBounds(250, 10, 50, 50);
        c5.setBounds(310, 10, 50, 50);
        c6.setBounds(370, 10, 50, 50);
        c7.setBounds(370, 70, 50, 50);
        c8.setBounds(370, 130, 50, 50);
        c9.setBounds(310, 130, 50, 50);
        c10.setBounds(250, 130, 50, 50);

        // Posicionamiento del botón y mensaje
        movimiento.setBounds(300, 200, 100, 100);
        preguntas.setBounds(10, 200, 200, 100);

        // Inicializa los colores de las casillas
        ponerazul();

        // Muestra al jugador en la casilla inicial (c0)
        c0.setBackground(jugador);

        // Añade todos los componentes a la ventana
        this.add(c0); this.add(c1); this.add(c2); this.add(c3); this.add(c4);
        this.add(c5); this.add(c6); this.add(c7); this.add(c8); this.add(c9); this.add(c10);
        this.add(preguntas);
        this.add(movimiento);

        // Asocia el botón con el manejador de eventos (actionPerformed)
        movimiento.addActionListener(this);
    }
    
// Manejador de eventos cuando se hace clic en el botón "Dado"
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == movimiento) {
            // Lanza un número aleatorio del 1 al 6 (simula un dado)
            dado = (int)(Math.random() * 6) + 1;
            JOptionPane.showMessageDialog(null, "Has sacado un " + dado);

            // Avanza al jugador esa cantidad de posiciones
            player += dado;

            // Si llega al final o se pasa, lo coloca en la última casilla y termina el juego
            if (player >= 10) {
                player = 10;
                ponerazul(); // Limpia el tablero
                c10.setBackground(jugador); // Pone al jugador en la última casilla
                JOptionPane.showMessageDialog(null, "¡Has llegado al final del juego!");
                System.exit(0); // Cierra el programa
            }
        
        // Limpia el tablero antes de moverse
        ponerazul();
        
        // Según la casilla, muestra un mensaje distinto
        switch (player) {
            case 0:
                c0.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Inicio del juego.");
                break;
            case 1:
                c1.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Paso 1: La aventura comienza.");
                break;
            case 2:
                c2.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Paso 2: Encuentras una pista misteriosa.");
                break;
            case 3:
                c3.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Paso 3: Un camino se divide en dos.");
                break;
            case 4:
                c4.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Paso 4: Has esquivado una trampa.");
                break;
            case 5:
                c5.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Paso 5: Escuchas un ruido extraño...");
                break;
            case 6:
                c6.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Paso 6: Recibes ayuda inesperada.");
                break;
            case 7:
                c7.setBackground(jugador);
                // En la casilla 7 aparece un reto adicional
                int respuesta = JOptionPane.showConfirmDialog(null,"Paso 7: Un reto mental aparece.\n¿Quieres abrir el reto mental?","Reto Mental",
                JOptionPane.YES_NO_OPTION);
                // Lanza una ventana nueva con el juego "Adivina el número"
                if (respuesta == JOptionPane.YES_OPTION) {
                AdivinaNumero juego = new AdivinaNumero();
                juego.setLocationRelativeTo(null);
                juego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                juego.setVisible(true);
                }
         
                break;
            case 8:
                c8.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Paso 8: Encuentras una puerta secreta.");
                break;
            case 9:
                c9.setBackground(jugador);
                JOptionPane.showMessageDialog(null, "Paso 9: Estás muy cerca del final.");
                break;
        }
    }
}
    // Método que limpia las casillas y las pinta del color azul base
    public void ponerazul(){
    // Habilita el color de fondo de cada etiqueta (opaque)
    c0.setOpaque(true);
    c1.setOpaque(true);
    c2.setOpaque(true);
    c3.setOpaque(true);
    c4.setOpaque(true);
    c5.setOpaque(true);
    c6.setOpaque(true);
    c7.setOpaque(true);
    c8.setOpaque(true);
    c9.setOpaque(true);
    c10.setOpaque(true);
    preguntas.setOpaque(true);
    
   // Asigna el color de fondo a todas las casillas
    c0.setBackground(casillas);
    c1.setBackground(casillas);
    c2.setBackground(casillas);
    c3.setBackground(casillas);
    c4.setBackground(casillas);
    c5.setBackground(casillas);
    c6.setBackground(casillas);
    c7.setBackground(casillas);
    c8.setBackground(casillas);
    c9.setBackground(casillas);
    c10.setBackground(casillas);
    
    // El mensaje de historia se muestra con fondo naranja
    preguntas.setBackground(Color.ORANGE);
        
    }
    
    // Método principal que inicia el juego
    public static void main(String[] args) {
    new Oca(); // Crea una instancia del juego
    }

    
}
