/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que controla la única ventana del juego.
 * 
 * @author ACER NITRO
 */
public class ControlVista implements ActionListener{
    /**
     * Objeto de ControlPrincipal para la comunicación entre ambos objetos.
     */
    private ControlPrincipal controlPrincipal;
    /**
     * Metodo constructor para mantener la comunicación con el
     * control principal.
     */
    public ControlVista(ControlPrincipal controlPrincipal){
        this.controlPrincipal = controlPrincipal;
    }

    /**
     * Metodo para ejecutar acciones, según los eventos que escuche.
     * 
     * @param e evento de acción que contiene el comando String a procesar. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
