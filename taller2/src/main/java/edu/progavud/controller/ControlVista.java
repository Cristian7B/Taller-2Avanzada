/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.view.VentanaJuego;
import edu.progavud.view.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    /**
     * Metodo para ejecutar acciones, según los eventos que escuche.
     * 
     * @param e evento de acción que contiene el comando String a procesar. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        int contador = 1; //ni contador ni ronda puede ser igual a 0
        switch (comando) {     
            case "JUGAR":
                ventanaPrincipal.setVisible(false);
                ventanaJuego.setVisible(true);
                controlPrincipal.repartoInicial(1);
                break;
            case "SALIR":
                ventanaPrincipal.anuncio("Hasta pronto", "Salir");
                System.exit(0);
                break;     
            case "PEDIR":
                controlPrincipal.pedir(contador);
                break;
            case "QUEDARSE":
                break;
            case "DIVIDIR":
                break;
        }
                
    }
    
    public void asignarOyentes(){
        ventanaPrincipal.getjButton1().setActionCommand("SALIR");
        ventanaPrincipal.getjButton1().addActionListener(this);
        ventanaPrincipal.getjButton2().setActionCommand("JUGAR");
        ventanaPrincipal.getjButton2().addActionListener(this);
        
        ventanaJuego.btnDouble.setActionCommand("DOBLAR");
        ventanaJuego.btnDouble.addActionListener(this);
        ventanaJuego.btnHit.setActionCommand("PEDIR");
        ventanaJuego.btnHit.addActionListener(this);
        ventanaJuego.btnStay.setActionCommand("QUEDARSE");
        ventanaJuego.btnStay.addActionListener(this);
        ventanaJuego.btnSplit.setActionCommand("DIVIDIR");
        ventanaJuego.btnSplit.addActionListener(this);
        
    }
}
