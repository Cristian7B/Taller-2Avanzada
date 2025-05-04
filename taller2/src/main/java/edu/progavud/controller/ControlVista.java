/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.view.VentanaJuego;
import edu.progavud.view.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * Clase que controla las ventanas del juego.
 * 
 * @author Nicolas Velasco 
 */
public class ControlVista implements ActionListener{
    /**
     * Objeto de ControlPrincipal para la comunicación entre ambos objetos.
     */
    private ControlPrincipal controlPrincipal;
    /**
     * Objeto de la ventana en la que se va a jugar
     */
    private VentanaJuego ventanaJuego;
    /**
     * Objeto donde aparece la ventana del menú de inicio
     */
    private VentanaPrincipal ventanaPrincipal;
    /**
     * Metodo constructor para mantener la comunicación con el
     * control principal.
     */
    public ControlVista(ControlPrincipal controlPrincipal){
        this.controlPrincipal = controlPrincipal;
        ventanaPrincipal = new VentanaPrincipal(this);
        ventanaJuego = new VentanaJuego(this);
        asignarOyentes();
    }
    int proporcionAsegurar = 0;
    /**
     * Metodo para ejecutar acciones, según los eventos que escuche.
     * 
     * @param e evento de acción que contiene el comando String a procesar. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if ( ControlMesa.getContador() != 3){
            switch (comando) {    

                case "JUGAR":
                    actualizarEstadoApuestas();
                    ventanaPrincipal.setVisible(false);
                    ventanaJuego.setVisible(true);


                    controlPrincipal.rondaActual = 1;
                    ControlMesa.setContador(1);
                    actualizarEstadoJugador();

                    ventanaJuego.mostrarMensaje("Realicen sus apuestas antes de repartir cartas. Al principio solo podrá apostar con una única ficha, o en su defecto hacer AllIn");


                    break;

                case "SALIR":
                    ventanaPrincipal.anuncio("Hasta pronto", "Salir");
                    System.exit(0);
                    break;     
                case "ASEGURAR":
                    if (controlPrincipal.obtenerPersonas()[2].getMano().get(0).getValorInterno()==11){
                        proporcionAsegurar = controlPrincipal.asegurar();
                        ventanaPrincipal.anuncio("Apuesta asegurada", "CRUPIER");
                    }else{
                        ventanaPrincipal.anuncio("No puedes asegurar porque la primera carta del crupier debe ser un as", "CRUPIER");
                    }
                    
                    break;
                case "PEDIR1":
                    controlPrincipal.pedir(ControlMesa.getContador());
                    ventanaJuego.getPanelCartasJugador().add(ventanaJuego.crearCarta(  
                            String.valueOf(
                                    controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size() - 1).getValorInterno()),
                                    controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size() - 1).getTipo()));
                    ventanaJuego.getPanelCartasJugador().revalidate();
                    ventanaJuego.getPanelCartasJugador().repaint();

                    actualizarEstadoJugador();
                    break;
                case "PEDIR2":
                    controlPrincipal.pedir(ControlMesa.getContador());
                    ventanaJuego.getPanelCartasJugador2().add(ventanaJuego.crearCarta( 
                            String.valueOf(
                                    controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size() - 1).getValorInterno()),
                                    controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size() - 1).getTipo()));
                    ventanaJuego.getPanelCartasJugador2().revalidate();
                    ventanaJuego.getPanelCartasJugador2().repaint();

                    break;
                case "QUEDARSE":
                    actualizarEstadoJugador();
                    quedarse();
                    break;
                case "DOBLAR1":
                    controlPrincipal.doblar(ControlMesa.getContador());
                    ventanaJuego.getPanelCartasJugador().add(ventanaJuego.crearCarta(  
                            String.valueOf(
                                    controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size() - 1).getValorInterno()),
                                    controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size() - 1).getTipo()));
                    ventanaJuego.getPanelCartasJugador().revalidate();
                    ventanaJuego.getPanelCartasJugador().repaint();
                    controlPrincipal.obtenerApuestas()[ControlMesa.getContador()-1] = (controlPrincipal.obtenerApuestas()[ControlMesa.getContador()-1])*2;
                    actualizarEstadoJugador();
                    actualizarEstadoApuestas();
                    quedarse();
                    break;
                case "DOBLAR2":
                    controlPrincipal.doblar(ControlMesa.getContador());
                    ventanaJuego.getPanelCartasJugador2().add(ventanaJuego.crearCarta(  
                            String.valueOf(
                                    controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size() - 1).getValorInterno()),
                                    controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size() - 1).getTipo()));
                    ventanaJuego.getPanelCartasJugador2().revalidate();
                    ventanaJuego.getPanelCartasJugador2().repaint();
                    controlPrincipal.obtenerApuestas()[ControlMesa.getContador()-1] = (controlPrincipal.obtenerApuestas()[ControlMesa.getContador()-1])*2;
                    actualizarEstadoJugador();
                    actualizarEstadoApuestas();
                    quedarse();
                    break;
                case "DIVIDIR":
                    actualizarEstadoJugador();
                    break;
                
                case "APOSTAR1":
                    controlPrincipal.apostarEnJugador(1);
                    avanzarRondaSiListo();
                    actualizarEstadoJugador();
                    actualizarEstadoApuestas();
                    break;
                case "APOSTAR5":
                    controlPrincipal.apostarEnJugador(5);
                    avanzarRondaSiListo();
                    actualizarEstadoJugador();
                    actualizarEstadoApuestas();
                    break;
                case "APOSTAR10":
                    controlPrincipal.apostarEnJugador(10);
                    avanzarRondaSiListo();
                    actualizarEstadoJugador();
                    actualizarEstadoApuestas();
                    break;
                case "APOSTAR25":
                    controlPrincipal.apostarEnJugador(25);
                    avanzarRondaSiListo();
                    actualizarEstadoJugador();
                    actualizarEstadoApuestas();
                    break;
                case "APOSTAR50":
                    controlPrincipal.apostarEnJugador(50);
                    avanzarRondaSiListo();
                    actualizarEstadoJugador();
                    actualizarEstadoApuestas();
                    break;
                case "ALLIN":
                    controlPrincipal.apostarEnJugador(controlPrincipal.obtenerPersonas()[ControlMesa.getContador()].getDinero());
                    avanzarRondaSiListo();
                    actualizarEstadoJugador();
                    actualizarEstadoApuestas();
                    break;
            }
        }else{
            
            switch (comando){
                case "SIGUIENTE":
                    controlPrincipal.moverPersonasAlFinal();
                    controlPrincipal.rondaActual = 2;
                    ControlMesa.setContador(1);
                    actualizarEstadoJugador();

                    ventanaJuego.mostrarMensaje("Realicen sus apuestas antes de repartir cartas. Al principio solo podrá apostar con una única ficha, o en su defecto hacer AllIn");
                    break;
            }               
        }
    }
   
    private void quedarse(){
        if (ventanaJuego.btnHit.getActionCommand() == "PEDIR1"){
            ventanaJuego.btnHit.setActionCommand("PEDIR2");
            ventanaJuego.btnDouble.setActionCommand("DOBLAR2");
        }else{
            ventanaJuego.btnHit.setActionCommand("PEDIR1");
            ventanaJuego.btnDouble.setActionCommand("DOBLAR1");
        }
        if (ControlMesa.getContador() ==1){
            ControlMesa.setContador(2);
        }else{
            ControlMesa.setContador(3);
            controlPrincipal.pedir(3);
            mostrarCartasCrupier();
            ControlMesa.setContador(1);
            controlPrincipal.pagarApuesta(controlPrincipal.hallarGanador()+controlPrincipal.blackJack()+proporcionAsegurar, controlPrincipal.obtenerApuestas()[ControlMesa.getContador()-1]);
            ControlMesa.setContador(2);
            controlPrincipal.pagarApuesta(controlPrincipal.hallarGanador()+controlPrincipal.blackJack()+proporcionAsegurar, controlPrincipal.obtenerApuestas()[ControlMesa.getContador()-1]);
            ControlMesa.setContador(1);
            actualizarEstadoJugador();
            ControlMesa.setContador(2);
            actualizarEstadoJugador();
            ControlMesa.setContador(3);
            ventanaPrincipal.anuncio("Cobro y pago de las apuestas realizado", "CRUPIER");
        }
    }
    
    private void mostrarCartasCrupier(){
            ventanaJuego.getPanelCartasCrupier().removeAll();
        for (int i = 0; i<controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().size(); i++){
            ventanaJuego.getPanelCartasCrupier().add(ventanaJuego.crearCarta(
                    String.valueOf(
                            controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(i).getValorInterno()),
                            controlPrincipal.obtenerPersonas()[ControlMesa.getContador()-1].getMano().get(i).getTipo()));

        }
        
        ventanaJuego.getPanelCartasCrupier().revalidate();
        ventanaJuego.getPanelCartasCrupier().repaint();            
    }
    

    private void avanzarRondaSiListo() {
        ControlMesa.setContador(ControlMesa.getContador()+1);

        if (ControlMesa.getContador() == 3 && controlPrincipal.rondaActual == 1) {
            controlPrincipal.rondaActual = 2;
            ControlMesa.setContador(1); 

            controlPrincipal.repartoInicial(1);

            for (int i = 0; i < 3; i++) {
                for(int j = 0; j < 2; j++) {
                    String tipo = controlPrincipal.obtenerPersonas()[i].getMano().get(j).getTipo();
                    String simbolo = "";

                    switch (tipo) {
                        case "PICAS":
                            simbolo = "PICAS"; 
                            break;
                        case "DIAMANTES":
                            simbolo = "DIAMANTES"; 
                            break;
                        case "CORAZONES":
                            simbolo = "CORAZONES"; 
                            break;
                        case "TREBOLES":
                            simbolo = "TREBOLES";
                            break;
                    }

                    if (i == 0) {
                        ventanaJuego.getPanelCartasJugador().add(ventanaJuego.crearCarta(
                            String.valueOf(controlPrincipal.obtenerPersonas()[i].getMano().get(j).getValorInterno()),
                            simbolo
                        ));
                        ventanaJuego.getPanelCartasJugador().revalidate();
                        ventanaJuego.getPanelCartasJugador().repaint();
                    } else if (i == 1) {
                        ventanaJuego.getPanelCartasJugador2().add(ventanaJuego.crearCarta(
                            String.valueOf(controlPrincipal.obtenerPersonas()[i].getMano().get(j).getValorInterno()),
                            simbolo
                        ));
                        ventanaJuego.getPanelCartasJugador2().revalidate();
                        ventanaJuego.getPanelCartasJugador2().repaint();
                    } else if (i == 2) {
                        if(j == 1) {
                            ventanaJuego.getPanelCartasCrupier().add(ventanaJuego.crearCartaVolteada());
                        } else {
                            ventanaJuego.getPanelCartasCrupier().add(ventanaJuego.crearCarta(
                                String.valueOf(controlPrincipal.obtenerPersonas()[i].getMano().get(j).getValorInterno()),
                                simbolo
                            ));
                            ventanaJuego.getPanelCartasCrupier().revalidate();
                            ventanaJuego.getPanelCartasCrupier().repaint();
                        }
                    }
                }
            }

            ventanaPrincipal.anuncio("No va mas, queda cerrado el acceso a otros jugadores.", "CRUPIER");
            ControlMesa.setContador(1);
        }
    }
    
    private void actualizarEstadoJugador() {
        int jugadorActual = ControlMesa.getContador();
        ventanaJuego.getLabelJugador().setText(controlPrincipal.obtenerPersonas()[jugadorActual-1].getNombre());
        ventanaJuego.getLabelDinero().setText("Dinero disponible: $" + String.valueOf(controlPrincipal.obtenerPersonas()[jugadorActual-1].getDinero()));
        ventanaJuego.getFondo().revalidate();
        ventanaJuego.getFondo().repaint();
    }
    
    private void actualizarEstadoApuestas() {
        int[] apuestasMesa = controlPrincipal.obtenerApuestas();
        ventanaJuego.getLabelFichas().setText("Fichas apostadas por " + controlPrincipal.obtenerPersonas()[0].getNombre() + ": $" + String.valueOf(apuestasMesa[0]));
        ventanaJuego.getLabelFichas2().setText("Fichas apostadas por " + controlPrincipal.obtenerPersonas()[1].getNombre() + ": $" + String.valueOf(apuestasMesa[1]));
        ventanaJuego.getFondo().revalidate();
        ventanaJuego.getFondo().repaint();
    }


    
    public void asignarOyentes(){
        ventanaPrincipal.getjButton1().setActionCommand("SALIR");
        ventanaPrincipal.getjButton1().addActionListener(this);
        ventanaPrincipal.getjButton2().setActionCommand("JUGAR");
        ventanaPrincipal.getjButton2().addActionListener(this);
        
        ventanaJuego.btnDouble.setActionCommand("DOBLAR1");
        ventanaJuego.btnDouble.addActionListener(this);
        ventanaJuego.btnHit.setActionCommand("PEDIR1");
        ventanaJuego.btnHit.addActionListener(this);
        ventanaJuego.btnStay.setActionCommand("QUEDARSE");
        ventanaJuego.btnStay.addActionListener(this);
        ventanaJuego.btnAsegurar.setActionCommand("ASEGURAR");
        ventanaJuego.btnAsegurar.addActionListener(this);
        ventanaJuego.btnSplit.setActionCommand("DIVIDIR");
        ventanaJuego.btnSplit.addActionListener(this);
        ventanaJuego.btnSiguienteRonda.setActionCommand("SIGUIENTE");
        ventanaJuego.btnSiguienteRonda.addActionListener(this);
        
        ventanaJuego.btnFicha1.setActionCommand("APOSTAR1");
        ventanaJuego.btnFicha5.setActionCommand("APOSTAR5");
        ventanaJuego.btnFicha10.setActionCommand("APOSTAR10");
        ventanaJuego.btnFicha25.setActionCommand("APOSTAR25");
        ventanaJuego.btnFicha50.setActionCommand("APOSTAR50");
        ventanaJuego.btnAllIn.setActionCommand("ALLIN");

        ventanaJuego.btnFicha1.addActionListener(this);
        ventanaJuego.btnFicha5.addActionListener(this);
        ventanaJuego.btnFicha10.addActionListener(this);
        ventanaJuego.btnFicha25.addActionListener(this);
        ventanaJuego.btnFicha50.addActionListener(this);
        ventanaJuego.btnAllIn.addActionListener(this);

        
        
    }
    
}
