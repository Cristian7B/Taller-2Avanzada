package edu.progavud.view;

import edu.progavud.controller.ControlVista;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class VentanaJuego extends javax.swing.JFrame {
    private int segundos = 0;
    private Timer timer;
    
    private JLabel fondo;

    private int fichasApostadas = 0;
    private int dineroJugador = 1000;
    
    private JLabel labelJugador;
    private JLabel labelFichas;
    private JLabel labelFichas2;
    private JLabel labelDinero;

    public JButton btnHit;
    public JButton btnDouble;
    public JButton btnStay;
    public JButton btnSplit;
    
    public JButton btnFicha1;
    public JButton btnFicha5;
    public JButton btnFicha10;
    public JButton btnFicha25;
    public JButton btnFicha50;
    public JButton btnAllIn;

    private ControlVista controlVista;

    // Nuevos paneles para mostrar cartas
    private JPanel panelCartasJugador;
    private JPanel panelCartasJugador2;
    private JPanel panelCartasCrupier;

    public VentanaJuego(ControlVista controlVista) {
        this.controlVista = controlVista;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setLayout(null); 

        JPanel panelBase = new JPanel(new BorderLayout());
        panelBase.setBounds(0, 0, 1100, 650);
        panelBase.setBackground(new Color(0x0B3E25));
        setContentPane(panelBase);

        fondo = new JLabel(new ImageIcon(getClass().getResource("/mesaDeJuegoFinal.png")));
        fondo.setLayout(null);
        panelBase.add(fondo, BorderLayout.CENTER);

        // Panel superior para botones de apuestas
        JPanel panelApuestasNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelApuestasNorth.setOpaque(false);

        btnFicha1 = new JButton("+1");
        btnFicha1.setBackground(new Color(0x4CAF50));
        btnFicha1.setForeground(new Color(0xF5EE9E));
        btnFicha1.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnFicha1.setPreferredSize(new Dimension(80, 40));
        btnFicha1.setFocusPainted(false);
        btnFicha1.setBorder(null);

        btnFicha5 = new JButton("+5");
        btnFicha5.setBackground(new Color(0x2196F3));
        btnFicha5.setForeground(new Color(0xF5EE9E));
        btnFicha5.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnFicha5.setPreferredSize(new Dimension(80, 40));
        btnFicha5.setFocusPainted(false);
        btnFicha5.setBorder(null);

        btnFicha10 = new JButton("+10");
        btnFicha10.setBackground(new Color(0xFFC107));
        btnFicha10.setForeground(new Color(0xF5EE9E));
        btnFicha10.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnFicha10.setPreferredSize(new Dimension(80, 40));
        btnFicha10.setFocusPainted(false);
        btnFicha10.setBorder(null);

        btnFicha25 = new JButton("+25");
        btnFicha25.setBackground(new Color(0xFF5722));
        btnFicha25.setForeground(new Color(0xF5EE9E));
        btnFicha25.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnFicha25.setPreferredSize(new Dimension(80, 40));
        btnFicha25.setFocusPainted(false);
        btnFicha25.setBorder(null);

        btnFicha50 = new JButton("+50");
        btnFicha50.setBackground(new Color(0x9C27B0));
        btnFicha50.setForeground(new Color(0xF5EE9E));
        btnFicha50.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnFicha50.setPreferredSize(new Dimension(80, 40));
        btnFicha50.setFocusPainted(false);
        btnFicha50.setBorder(null);

        btnAllIn = new JButton("All In");
        btnAllIn.setBackground(new Color(0xB71C1C));
        btnAllIn.setForeground(new Color(0xF5EE9E));
        btnAllIn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnAllIn.setPreferredSize(new Dimension(80, 40));
        btnAllIn.setFocusPainted(false);
        btnAllIn.setBorder(null);

        panelApuestasNorth.add(btnFicha1);
        panelApuestasNorth.add(btnFicha5);
        panelApuestasNorth.add(btnFicha10);
        panelApuestasNorth.add(btnFicha25);
        panelApuestasNorth.add(btnFicha50);
        panelApuestasNorth.add(btnAllIn);
        panelBase.add(panelApuestasNorth, BorderLayout.NORTH);

        // Panel SUR con botones del juego
        JPanel panelSur = new JPanel();
        panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.Y_AXIS));
        panelSur.setOpaque(false);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setOpaque(false);

        Font fuenteBoton = new Font("SansSerif", Font.BOLD, 16);
        Color colorFondoBoton = new Color(0xAB3428);
        Color colorTexto = new Color(0xF5EE9E);

        btnHit = new JButton("Hit");
        btnHit.setBackground(colorFondoBoton);
        btnHit.setForeground(colorTexto);
        btnHit.setFont(fuenteBoton);
        btnHit.setPreferredSize(new Dimension(100, 40));
        btnHit.setFocusPainted(false);
        btnHit.setBorder(null);

        btnDouble = new JButton("Double");
        btnDouble.setBackground(colorFondoBoton);
        btnDouble.setForeground(colorTexto);
        btnDouble.setFont(fuenteBoton);
        btnDouble.setPreferredSize(new Dimension(100, 40));
        btnDouble.setFocusPainted(false);
        btnDouble.setBorder(null);

        btnStay = new JButton("Stay");
        btnStay.setBackground(colorFondoBoton);
        btnStay.setForeground(colorTexto);
        btnStay.setFont(fuenteBoton);
        btnStay.setPreferredSize(new Dimension(100, 40));
        btnStay.setFocusPainted(false);
        btnStay.setBorder(null);

        btnSplit = new JButton("Split");
        btnSplit.setBackground(colorFondoBoton);
        btnSplit.setForeground(colorTexto);
        btnSplit.setFont(fuenteBoton);
        btnSplit.setPreferredSize(new Dimension(100, 40));
        btnSplit.setFocusPainted(false);
        btnSplit.setBorder(null);
        panelBotones.add(btnHit);
        panelBotones.add(btnDouble);
        panelBotones.add(btnStay);
        panelBotones.add(btnSplit);

        panelSur.add(panelBotones);
        panelBase.add(panelSur, BorderLayout.SOUTH);

        Font fuenteLabel = new Font("SansSerif", Font.BOLD, 14);

        JPanel panelTurno = new JPanel(new BorderLayout());
        panelTurno.setBackground(new Color(0, 0, 0, 150)); 
        panelTurno.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); 

        labelJugador = new JLabel("Turno: Jugador 1");
        labelJugador.setFont(fuenteLabel);
        labelJugador.setForeground(colorTexto);

        labelDinero = new JLabel("Dinero disponible: $1000");
        labelDinero.setFont(fuenteLabel);
        labelDinero.setForeground(colorTexto);

        panelTurno.add(labelJugador, BorderLayout.CENTER);
        panelTurno.add(labelDinero, BorderLayout.SOUTH);

        fondo.add(panelTurno);
        panelTurno.setBounds(20, 20, 200, 60);

        JPanel panelApuesta = new JPanel();
        panelApuesta.setLayout(new BoxLayout(panelApuesta, BoxLayout.Y_AXIS));
        panelApuesta.setBackground(new Color(0, 0, 0, 180)); 
        panelApuesta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        labelFichas = new JLabel("Fichas apostadas Jugador 1: 0");
        labelFichas.setFont(fuenteLabel);
        labelFichas.setForeground(colorTexto);

        labelFichas2 = new JLabel("Fichas apostadas Jugador 2: 0");
        labelFichas2.setFont(fuenteLabel);
        labelFichas2.setForeground(colorTexto);

        panelApuesta.add(labelFichas);
        panelApuesta.add(Box.createVerticalStrut(5)); 
        panelApuesta.add(labelFichas2);

        fondo.add(panelApuesta);
        panelApuesta.setBounds(770, 20, 270, 80);

        crearPanelesDeCartas();
    }


    public void crearPanelesDeCartas() {
        panelCartasCrupier = new JPanel();
        panelCartasCrupier.setOpaque(false);
        panelCartasCrupier.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelCartasCrupier.setBounds(400, 250, 400, 100); 
        fondo.add(panelCartasCrupier);

        panelCartasJugador = new JPanel();
        panelCartasJugador.setOpaque(false);
        panelCartasJugador.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelCartasJugador.setBounds(220, 350, 400, 100); 
        fondo.add(panelCartasJugador);

        panelCartasJugador2 = new JPanel();
        panelCartasJugador2.setOpaque(false);
        panelCartasJugador2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelCartasJugador2.setBounds(780, 350, 400, 100); 
        fondo.add(panelCartasJugador2);
    }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }


    public JPanel crearCarta(String valor, String tipo) {
        Map<String, String> tipoMapa = new HashMap<>();
        tipoMapa.put("PICAS", "/picasIcon.png");
        tipoMapa.put("DIAMANTES", "/diamantesIcon.png");
        tipoMapa.put("CORAZONES", "/corazonesIcon.png");
        tipoMapa.put("TREBOLES", "/trebolesIcon.png");

        Map<String, Color> colorMapa = new HashMap<>();
        colorMapa.put("PICAS", Color.BLACK);
        colorMapa.put("TREBOLES", Color.BLACK);
        colorMapa.put("DIAMANTES", new Color(0xE64C3C));
        colorMapa.put("CORAZONES", new Color(0xE64C3C));

        String simboloPath = tipoMapa.get(tipo);
        Color colorFondo = colorMapa.get(tipo);


        ImageIcon icono = new ImageIcon(getClass().getResource(simboloPath));
        Image imagen = icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Ajusta el tamaño a la carta
        icono = new ImageIcon(imagen);

        JPanel carta = new JPanel();
        carta.setLayout(new BorderLayout());
        carta.setPreferredSize(new Dimension(60, 90));
        carta.setBackground(Color.WHITE);
        carta.setBorder(BorderFactory.createLineBorder(colorFondo, 2));

        JLabel esquinaSuperior = new JLabel(valor);
        esquinaSuperior.setFont(new Font("SansSerif", Font.BOLD, 12));
        esquinaSuperior.setHorizontalAlignment(SwingConstants.LEFT);
        esquinaSuperior.setVerticalAlignment(SwingConstants.TOP);
        esquinaSuperior.setForeground(colorFondo);
        carta.add(esquinaSuperior, BorderLayout.NORTH);

        JLabel centro = new JLabel(icono); 
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        centro.setVerticalAlignment(SwingConstants.CENTER);
        carta.add(centro, BorderLayout.CENTER);

        JLabel esquinaInferior = new JLabel(valor);
        esquinaInferior.setFont(new Font("SansSerif", Font.BOLD, 12));
        esquinaInferior.setHorizontalAlignment(SwingConstants.RIGHT);
        esquinaInferior.setVerticalAlignment(SwingConstants.BOTTOM);
        esquinaInferior.setForeground(colorFondo);
        carta.add(esquinaInferior, BorderLayout.SOUTH);

        return carta;
    }
    
    public JPanel crearCartaVolteada() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/cartaVolteada.png"));
        Image imagen = icono.getImage().getScaledInstance(60, 90, Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagen);

        JPanel carta = new JPanel();
        carta.setLayout(new BorderLayout());
        carta.setPreferredSize(new Dimension(60, 90));
        carta.setBackground(Color.WHITE);
        carta.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        JLabel imagenCentro = new JLabel(icono);
        imagenCentro.setHorizontalAlignment(SwingConstants.CENTER);
        imagenCentro.setVerticalAlignment(SwingConstants.CENTER);
        carta.add(imagenCentro, BorderLayout.CENTER);

        return carta;
    }


    // Getters y setters

    public JLabel getLabelJugador() {
        return labelJugador;
    }

    public void setLabelJugador(JLabel labelJugador) {
        this.labelJugador = labelJugador;
    }

    public JLabel getLabelFichas2() {
        return labelFichas2;
    }

    public void setLabelFichas2(JLabel labelFichas2) {
        this.labelFichas2 = labelFichas2;
    }
    public int getSegundos() { return segundos; }
    public void setSegundos(int segundos) { this.segundos = segundos; }

    public Timer getTimer() { return timer; }
    public void setTimer(Timer timer) { this.timer = timer; }

    public int getFichasApostadas() { return fichasApostadas; }
    public void setFichasApostadas(int fichasApostadas) { this.fichasApostadas = fichasApostadas; }

    public int getDineroJugador() { return dineroJugador; }
    public void setDineroJugador(int dineroJugador) { this.dineroJugador = dineroJugador; }

    public JLabel getLabelFichas() { return labelFichas; }
    public void setLabelFichas(JLabel labelFichas) { this.labelFichas = labelFichas; }

    public JLabel getLabelDinero() { return labelDinero; }
    public void setLabelDinero(JLabel labelDinero) { this.labelDinero = labelDinero; }

    public ControlVista getControlVista() { return controlVista; }
    public void setControlVista(ControlVista controlVista) { this.controlVista = controlVista; }

    public JButton getBtnHit() { return btnHit; }
    public void setBtnHit(JButton btnHit) { this.btnHit = btnHit; }

    public JButton getBtnDouble() { return btnDouble; }
    public void setBtnDouble(JButton btnDouble) { this.btnDouble = btnDouble; }

    public JLabel getFondo() {
        return fondo;
    }

    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }
    

    public JButton getBtnStay() { return btnStay; }
    public void setBtnStay(JButton btnStay) { this.btnStay = btnStay; }

    public JButton getBtnSplit() { return btnSplit; }
    public void setBtnSplit(JButton btnSplit) { this.btnSplit = btnSplit; }
    
    

    public JPanel getPanelCartasJugador() { return panelCartasJugador; }
    public JPanel getPanelCartasJugador2() { return panelCartasJugador2; }
    public JPanel getPanelCartasCrupier() { return panelCartasCrupier; }
}
