/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

/**
 *
 * @author ACER NITRO
 */
public class ControlPrincipal {
    private ControlPersona controlPersona;
    private ControlVista controlVista;
    
    public ControlPrincipal(){
        controlPersona = new ControlPersona(this);
        controlVista = new ControlVista(this);
    }
}
