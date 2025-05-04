/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.controller;

import edu.progavud.model.Carta;
import edu.progavud.model.CnxProperties;
import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Persona;
import edu.progavud.model.SerializableCrupier;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase encargada de controlar todo el resto de controles,
 * enlaza todo el programa.
 * 
 * @author Nicolas Velasco 
 */
public class ControlPrincipal {
    /**
     * Objeto que representa el control del crupier y los jugadores.
     */
    private ControlPersona controlPersona;
    /**
     * Objeto que representa el control de la vista.
     */
    private ControlVista controlVista;
    /**
     * Objeto que representa el control del mazo para generar las manos
     */
    private ControlMazo controlMazo;
    /**
     * Control para la gestión de la mesa, son 3 mesas en total
     */
    private ControlMesa controlMesa;
    /**
     * Variable para manejar la ronda de juego actual. Es 0 si a los jugadores
     * aún no se les han repartido las cartas y por lo tanto están en la apuesta
     * inicial.
     */
    public static int rondaActual;
    /**
     * Clase conexión con el archivo de propiedades.
     */
    private CnxProperties cnxProperties;
    
    /**
     * Atributo que representa la cantidad de jugadores capaces de jugar una 
     * mesa de Blackjack
     */
    private ArrayList<Jugador> personasValidadas;
    
    /**
     * Atributo que representa el crupier, capaz de jugar las 
     * mesas de Blackjack
     */
    private Crupier crupierInformacion;
    
    /**
     * Objeto para poder hacer la serialización del crupier.
     */
    private SerializableCrupier serializableCrupier;
    /**
     * Método constructor que enlaza la comunicación con todos los controles.
     */
    public ControlPrincipal(){
        controlPersona = new ControlPersona(this);
        serializableCrupier = new SerializableCrupier();
        controlVista = new ControlVista(this);
        controlMazo = new ControlMazo(this);
        rondaActual = 0;
        controlMesa = new ControlMesa(this, personasValidadas, crupierInformacion);
        
    }
    
    public void crearPersonasValidadas(ArrayList<ArrayList<String>> personasPropiedades) {
        personasValidadas = new ArrayList<>();

        for (int i = 0; i < personasPropiedades.size(); i++) {
            ArrayList<String> props = personasPropiedades.get(i);
            int dinero = Integer.parseInt(props.get(3));
            if (dinero > 0) {
                String nombre = props.get(0);
                String apellido = props.get(1);
                String cedula = props.get(2);
                String direccion = props.get(4);
                String telefono = props.get(5);
                personasValidadas.add(controlPersona.crearJugadorMesa(nombre, apellido, cedula, dinero, direccion, telefono));
            }
        }
    }
    
    public void crearCrupier(ArrayList<String> informacionCrupier) {
        if (serializableCrupier.archivoExiste()) {
            crupierInformacion = (Crupier) serializableCrupier.leerArchivoSerializado();
        } else {
            crupierInformacion = controlPersona.crearCrupier(
                informacionCrupier.get(0),
                informacionCrupier.get(1),
                informacionCrupier.get(2),
                Integer.parseInt(informacionCrupier.get(3))
            );
            serializableCrupier.escribirArchivoSerializado(crupierInformacion);
        }
    }

    
    /**
     * Método que une la persona que pidió con la carta con la nueva carta.
     * Primero se obtiene la persona escogida, luego su mano y a su mano se le añade
     * una carta random dentro del mazo.
     * @param contador contador que apunta a una persona
     */
    public void pedir(int contador){
        controlMesa.getPersonaParaModificar(contador).getMano().add(controlMazo.getRandomCarta());
    }
    
    /**
     * Método que hace el reparto inicial, únicamente entrega una carta a cada jugador
     * @param ronda ronda en la que van, siempre va a aumentar y solo servirá para el reparto
     *              inicial de las cartas. La ronda 1 es la primera carta q le dan a cada persona,
     *              la ronda 2 la segunda carta que se les da. En la segunda partida inician en la
     *              tercera ronda y así sucesivamente.
     */
    public void repartoInicial(int ronda) {
        ArrayList<Carta> manoGenerada = controlMazo.generarMano(ronda);

        // Jugador 1
        controlMesa.getPersonas()[0].getMano().add(manoGenerada.get(0));
        controlMesa.getPersonas()[0].getMano().add(manoGenerada.get(1));

        // Jugador 2
        controlMesa.getPersonas()[1].getMano().add(manoGenerada.get(2));
        controlMesa.getPersonas()[1].getMano().add(manoGenerada.get(3));

        // Crupier
        controlMesa.getPersonas()[2].getMano().add(manoGenerada.get(4));
        controlMesa.getPersonas()[2].getMano().add(manoGenerada.get(5));
    }

    /**
     * Método que dobla el valor de la
     * apuesta pero solo recibe una carta
     */
    public void doblar(int contador) {
        if(controlMesa.verificarDoblar()) {
            controlMesa.getPersonaParaModificar(contador).getMano().add(controlMazo.getRandomCarta());    
        }
    }
    
    /**
     * Método heredado de la clase Persona,si tiene el mismo
     * valor en las dos cartas primeras, puede dividir sus cartas
     * en dos manos y generar otra apuesta con la nueva mano
     */
    public void dividir() {
        if(controlMesa.verificarDividir()) {
            controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getManoDividida().get(0).add(controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getMano().get(0));
            controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getManoDividida().get(1).add(controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getMano().get(0));

            controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getManoDividida().get(0).add(controlMazo.getRandomCarta());
            controlMesa.getPersonaParaModificar(ControlMesa.getContador()).getManoDividida().get(1).add(controlMazo.getRandomCarta());
        }
    }
    
    public Persona[] obtenerPersonas() {
        return controlMesa.getPersonas();
    }

    /**
     * Método que puede asegurar
     * apostando a que le salga blackjack al crupier,
     * si su primera carta es un as. se paga 2 a 1.
     * Se puede apostar como maximo, la mitad de lo que aposto
     * en la apuesta inicial.
     * return valor que asegura, que por predeterminado siempre sera la mitad de la apuesta inicial
     */
    public int asegurar() {
        int apuestaAsegurar = 0;
        if(controlMesa.verificarAsegurar()){
            apuestaAsegurar = (controlMesa.getMesaActual().getApuestasDeLaMesa().get(String.valueOf(ControlMesa.getContador())))/2;
        }
        return apuestaAsegurar;
    }
    
    public void apostarEnJugador(int valorNuevoApuesta) {
        controlMesa.colocarApuestas(valorNuevoApuesta);
    }

    /**
     * Método que sirve para pagarle a una persona, el valor
     * que retorne esta función siempre se le sumará al dinero que 
     * tiene la persona
     * @param proporcion
     * @param apuesta 
     * @return dinero que se le debe pagar a la persona
     */
    public double pagarApuesta(double proporcion, int apuesta) {
        double paga = 0;
        paga = (double) apuesta* proporcion;
        return paga;
    }

    /**
     * Método heredado de la clase Persona, el jugador se
     * planta cuando crea que no necesita mas cartas.
     */
    public void plantarse() {
        ControlMesa.setContador(ControlMesa.getContador()+1);
    }


    /**
     * Método que modifica el atributo ganador de la persona
     */
    public void hallarGanador() {
        controlMesa.getPersonaParaModificar(ControlMesa.getContador()).setGanador(controlMesa.verificarGanador());
    }
    
    
    /**
     * Método para obtener las apuestas de los jugadores para mostrar las apuestas
     * totales en la vista.
     * @return apuestasMesa, arreglo con las apuestas totales de los jugadores
     */
    public int[] obtenerApuestas() {
        int[] apuestasMesa = new int[2];
        apuestasMesa[0] = controlMesa.getMesaActual().getApuestasDeLaMesa().get("0");
        apuestasMesa[1] = controlMesa.getMesaActual().getApuestasDeLaMesa().get("1");
        return apuestasMesa;
    }
    
    /**
     * Método para recuperar la ruta al archivo de propiedades de la vista.
     */
    public void recuperarPath(String path) {
        cnxProperties = new CnxProperties(path, this);
    } 
    

}
