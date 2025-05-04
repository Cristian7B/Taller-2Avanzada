/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.model;
import edu.progavud.controller.ControlPrincipal;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase creada con el objetivo de obtener las propiedades de los jugadores para
 * cada una de las mesas del juego.
 * @author Cristian Bonilla
 */
public class CnxProperties {
    /**
     * Atributo para la inyección del controller
     */
    private ControlPrincipal controlPrincipal;
    private ArrayList<ArrayList<String>> informacionJugadores;
    private ArrayList<String> informacionCrupier;
    
    /**
     * Método constructor para leer las properties y pasarlas al controllerPrincipal
     * e instanciar los jugadores.
     * @param pathAlArchivo
     * @param controlPrincipal 
     */
    public CnxProperties(String pathAlArchivo, ControlPrincipal controlPrincipal){
        Properties propiedades = new Properties();
        InputStream entrada = null;
        informacionJugadores = new ArrayList<>();
        informacionCrupier = new ArrayList<>();
        
        try {
            entrada = new FileInputStream(pathAlArchivo);
            propiedades.load(entrada);
            ArrayList<String> jugador1 = new ArrayList<>();
            jugador1.add(propiedades.getProperty("jugador1.nombre"));
            jugador1.add(propiedades.getProperty("jugador1.apellido"));
            jugador1.add(propiedades.getProperty("jugador1.cedula"));
            jugador1.add(propiedades.getProperty("jugador1.dinero"));
            jugador1.add(propiedades.getProperty("jugador1.direccion"));
            jugador1.add(propiedades.getProperty("jugador1.telefono"));
            jugador1.add(propiedades.getProperty("jugador1.apuesta"));
            informacionJugadores.add(jugador1);
            
            ArrayList<String> jugador2 = new ArrayList<>();
            jugador2.add(propiedades.getProperty("jugador2.nombre"));
            jugador2.add(propiedades.getProperty("jugador2.apellido"));
            jugador2.add(propiedades.getProperty("jugador2.cedula"));
            jugador2.add(propiedades.getProperty("jugador2.dinero"));
            jugador2.add(propiedades.getProperty("jugador2.direccion"));
            jugador2.add(propiedades.getProperty("jugador2.telefono"));
            jugador2.add(propiedades.getProperty("jugador2.apuesta"));
            informacionJugadores.add(jugador2);

            ArrayList<String> jugador3 = new ArrayList<>();
            jugador3.add(propiedades.getProperty("jugador3.nombre"));
            jugador3.add(propiedades.getProperty("jugador3.apellido"));
            jugador3.add(propiedades.getProperty("jugador3.cedula"));
            jugador3.add(propiedades.getProperty("jugador3.dinero"));
            jugador3.add(propiedades.getProperty("jugador3.direccion"));
            jugador3.add(propiedades.getProperty("jugador3.telefono"));
            jugador3.add(propiedades.getProperty("jugador3.apuesta"));
            informacionJugadores.add(jugador3);

            ArrayList<String> jugador4 = new ArrayList<>();
            jugador4.add(propiedades.getProperty("jugador4.nombre"));
            jugador4.add(propiedades.getProperty("jugador4.apellido"));
            jugador4.add(propiedades.getProperty("jugador4.cedula"));
            jugador4.add(propiedades.getProperty("jugador4.dinero"));
            jugador4.add(propiedades.getProperty("jugador4.direccion"));
            jugador4.add(propiedades.getProperty("jugador4.telefono"));
            jugador4.add(propiedades.getProperty("jugador4.apuesta"));
            informacionJugadores.add(jugador4);

            ArrayList<String> jugador5 = new ArrayList<>();
            jugador5.add(propiedades.getProperty("jugador5.nombre"));
            jugador5.add(propiedades.getProperty("jugador5.apellido"));
            jugador5.add(propiedades.getProperty("jugador5.cedula"));
            jugador5.add(propiedades.getProperty("jugador5.dinero"));
            jugador5.add(propiedades.getProperty("jugador5.direccion"));
            jugador5.add(propiedades.getProperty("jugador5.telefono"));
            jugador5.add(propiedades.getProperty("jugador5.apuesta"));
            informacionJugadores.add(jugador5);

            ArrayList<String> jugador6 = new ArrayList<>();
            jugador6.add(propiedades.getProperty("jugador6.nombre"));
            jugador6.add(propiedades.getProperty("jugador6.apellido"));
            jugador6.add(propiedades.getProperty("jugador6.cedula"));
            jugador6.add(propiedades.getProperty("jugador6.dinero"));
            jugador6.add(propiedades.getProperty("jugador6.direccion"));
            jugador6.add(propiedades.getProperty("jugador6.telefono"));
            jugador6.add(propiedades.getProperty("jugador6.apuesta"));
            informacionJugadores.add(jugador6);
            
            informacionCrupier.add(propiedades.getProperty("crupier.nombre"));
            informacionCrupier.add(propiedades.getProperty("crupier.apellido"));
            informacionCrupier.add(propiedades.getProperty("crupier.cedula"));
            informacionCrupier.add(propiedades.getProperty("crupier.dinero"));
               
            controlPrincipal.crearPersonasValidadas(informacionJugadores);
            controlPrincipal.crearCrupier(informacionCrupier);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                entrada.close();
                } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
    }
}
