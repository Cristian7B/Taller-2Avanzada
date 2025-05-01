package edu.progavud.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class VentanaJuego extends javax.swing.JFrame {

    private JLabel labelTiempo;
    private int segundos = 0;
    private Timer timer;
    
    private int fichasApostadas = 0;
    private int dineroJugador = 1000;

    private JLabel labelFichas;
    private JLabel labelDinero;

    public VentanaJuego() {
        initComponents();
        iniciarTemporizador();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setLayout(null); 

        JPanel panelBase = new JPanel(new BorderLayout());
        panelBase.setBounds(0, 0, 1100, 650);
        setContentPane(panelBase);

        JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/mesaDeJuego (1).png")));
        fondo.setLayout(null);
        panelBase.add(fondo, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setOpaque(false); // Hace el panel transparente

        Font fuenteBoton = new Font("SansSerif", Font.BOLD, 16);
        Color colorFondoBoton = new Color(0xAB3428);
        Color colorTexto = new Color(0xF5EE9E);

        JButton btnHit = new JButton("Hit");
        btnHit.setBackground(colorFondoBoton);
        btnHit.setForeground(colorTexto);
        btnHit.setFont(fuenteBoton);
        btnHit.setPreferredSize(new Dimension(100, 40));
        btnHit.setFocusPainted(false);
        btnHit.setBorder(null);

        JButton btnDouble = new JButton("Double");
        btnDouble.setBackground(colorFondoBoton);
        btnDouble.setForeground(colorTexto);
        btnDouble.setFont(fuenteBoton);
        btnDouble.setPreferredSize(new Dimension(100, 40));
        btnDouble.setFocusPainted(false);
        btnDouble.setBorder(null);

        JButton btnStay = new JButton("Stay");
        btnStay.setBackground(colorFondoBoton);
        btnStay.setForeground(colorTexto);
        btnStay.setFont(fuenteBoton);
        btnStay.setPreferredSize(new Dimension(100, 40));
        btnStay.setFocusPainted(false);
        btnStay.setBorder(null);

        JButton btnSplit = new JButton("Split");
        btnSplit.setBackground(colorFondoBoton);
        btnSplit.setForeground(colorTexto);
        btnSplit.setFont(fuenteBoton);
        btnSplit.setPreferredSize(new Dimension(100, 40));
        btnSplit.setFocusPainted(false);
        btnSplit.setBorder(null);

        labelTiempo = new JLabel("Tiempo: 00:00");
        labelTiempo.setFont(new Font("SansSerif", Font.BOLD, 16));
        labelTiempo.setForeground(colorTexto);

        panelBotones.add(btnHit);
        panelBotones.add(btnDouble);
        panelBotones.add(btnStay);
        panelBotones.add(btnSplit);
        panelBotones.add(labelTiempo);

        fondo.add(panelBotones);
        panelBotones.setBounds(300, 560, 600, 50);


  
        JPanel panelTurno = new JPanel(new BorderLayout());
        panelTurno.setBackground(new Color(255, 255, 255, 180));
        JLabel labelJugador = new JLabel("Turno: Jugador 1");
        panelTurno.add(labelJugador, BorderLayout.CENTER);
        fondo.add(panelTurno);
        panelTurno.setBounds(20, 20, 150, 40);

 
        JPanel panelApuesta = new JPanel();
        panelApuesta.setLayout(new BoxLayout(panelApuesta, BoxLayout.Y_AXIS));
        panelApuesta.setBackground(new Color(255, 255, 255, 200));

        JButton btnAgregarFicha = new JButton("+1 Ficha");
        labelFichas = new JLabel("Fichas apostadas: 0");
        labelDinero = new JLabel("Dinero disponible: $1000");


        panelApuesta.add(btnAgregarFicha);
        panelApuesta.add(labelFichas);
        panelApuesta.add(labelDinero);

        fondo.add(panelApuesta);
        panelApuesta.setBounds(870, 20, 200, 80);
    }


    private void actualizarApuestaUI() {
        labelFichas.setText("Fichas apostadas: " + fichasApostadas);
        labelDinero.setText("Dinero disponible: $" + dineroJugador);
    }

    // Revisar
    private void iniciarTemporizador() {
        timer = new Timer(1000, e -> {
            segundos++;
            int minutos = segundos / 60;
            int seg = segundos % 60;
            labelTiempo.setText(String.format("Tiempo: %02d:%02d", minutos, seg));
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaJuego().setVisible(true));
    }
}


