package org.progavud;

import static org.junit.jupiter.api.Assertions.*;

import edu.progavud.controller.ControlMesa;
import edu.progavud.model.Carta;
import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Persona;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ControlMesaTest {

          static LocalDateTime tiempo;
          static ControlMesa instance;
          static Persona jugador1;
          static Persona jugador2;
          static Persona crupier;

          @org.junit.jupiter.api.BeforeAll
          public static void setUpClass() {
                    instance = new ControlMesa(null);
                    jugador1 = new Jugador("Cristian", "Bonilla", "12341234", 1000000, "Avenida Villavicencio",
                                        "12341234", 10);
                    jugador2 = new Jugador("Nicolas", "Velasco", "12431243", 1200000, "Avenida el dorado", "12431243",
                                        10);
                    crupier = new Crupier("Juan", "Diaz", "12346544", 200000000);
                    instance.agregarJugadorMesa(jugador1, 0);
                    instance.agregarJugadorMesa(jugador2, 1);
                    instance.agregarJugadorMesa(crupier, 2);

          }

          @org.junit.jupiter.api.AfterAll
          public static void tearDownClass() {

          }

          @org.junit.jupiter.api.BeforeEach
          public void setup() {
                    System.out.println("--------------------------------------------------[         Inicio Prueba       ]---------------------------------------------------------");
          }

          @org.junit.jupiter.api.AfterEach
          public void tearDown() {
                    System.out.println("Prueba finalizada a las: \t" + tiempo.now());
          }

          @org.junit.jupiter.api.Test
          public void colocarApuestasTest() {
                    instance.colocarApuestas(300000);
                    instance.colocarApuestas(40000);
                    /*
                     * ya que segun las reglas de negocio, solo se pueden hacer aumentos con un
                     * valor
                     * numerico definido o todo el dinero que tenga el jugador, no es necesario
                     * evaluar el
                     * caso en el que se supere el dinero que posee el jugador.
                     */
                    assertEquals(340000, instance.getMesaActual().getApuestasDeLaMesa().get("0")
                                        + instance.getMesaActual().getApuestasDeLaMesa().get("1"));
          }

          @org.junit.jupiter.api.Test
          public void agregarJugadorMesaTest() {
                    // Revisa si la referencia a la persona en la mesa recien agregada no es nula.
                    assertNotNull(instance.getMesaActual().getPersonas()[0]);
                    assertNotNull(instance.getMesaActual().getPersonas()[1]);
                    assertNotNull(instance.getMesaActual().getPersonas()[2]);
                    // Revisa si se agregaron correctamente las personas en las posiciones dadas.
                    assertNotEquals(instance.getMesaActual().getPersonas()[0], crupier);
                    assertNotEquals(instance.getMesaActual().getPersonas()[1], crupier);
                    assertNotEquals(instance.getMesaActual().getPersonas()[0], jugador2);
                    assertNotEquals(instance.getMesaActual().getPersonas()[1], jugador1);
          }

          @org.junit.jupiter.api.Test
          public void verificarDoblarTest() {
                    instance.colocarApuestas(300000);
                    instance.getMesaActual().getPersonas()[0].getMano().add(new Carta("PICA", 10));
                    instance.getMesaActual().getPersonas()[0].getMano().add(new Carta("TREBOL", 10));
                    instance.verificarDoblar();
                    assertEquals(600000, instance.getMesaActual().getApuestasDeLaMesa().get("0"));

                    instance.colocarApuestas(40000);
                    instance.getMesaActual().getPersonas()[1].getMano().add(new Carta("CORAZON", 10));
                    instance.getMesaActual().getPersonas()[1].getMano().add(new Carta("DIAMANTE", 2));
                    instance.verificarDoblar();
                    assertEquals(80000, instance.getMesaActual().getApuestasDeLaMesa().get("1"));
          }

          @org.junit.jupiter.api.Test
          public void verificarDividirTest() {
                    instance.colocarApuestas(300000);
                    instance.getMesaActual().getPersonas()[0].getMano().add(new Carta("PICA", 10));
                    instance.getMesaActual().getPersonas()[0].getMano().add(new Carta("TREBOL", 10));
                    assertTrue(instance.verificarDividir());

                    instance.colocarApuestas(40000);
                    instance.getMesaActual().getPersonas()[1].getMano().add(new Carta("CORAZON", 10));
                    instance.getMesaActual().getPersonas()[1].getMano().add(new Carta("DIAMANTE", 2));
                    assertFalse(instance.verificarDividir());
          }

          @org.junit.jupiter.api.Test
          public void verificarAsegurarTest() {
                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("PICA", 11));
                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("TREBOL", 10));
                    assertTrue(instance.verificarAsegurar());

                    instance.getMesaActual().getPersonas()[2].getMano().set(1, new Carta("CORAZON", 5));
                    assertFalse(instance.verificarAsegurar());
          }

          @org.junit.jupiter.api.Test
          public void verificarBlackJackTest() {
                    instance.colocarApuestas(300000);
                    instance.getMesaActual().getPersonas()[0].getMano().add(new Carta("PICA", 10));
                    instance.getMesaActual().getPersonas()[0].getMano().add(new Carta("TREBOL", 11));
                    assertTrue(instance.verificarBlackJack());

                    instance.colocarApuestas(40000);
                    instance.getMesaActual().getPersonas()[1].getMano().add(new Carta("CORAZON", 10));
                    instance.getMesaActual().getPersonas()[1].getMano().add(new Carta("DIAMANTE", 6));
                    assertFalse(instance.verificarBlackJack());

          }

          @org.junit.jupiter.api.Test
          public void verificarGanadorTest() {
                    instance.colocarApuestas(300000);
                    instance.getMesaActual().getPersonas()[0].getMano().add(new Carta("PICA", 10));
                    instance.getMesaActual().getPersonas()[0].getMano().add(new Carta("TREBOL", 11));

                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("PICA", 5));
                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("TREBOL", 11));
                    assertEquals(2, instance.verificarGanador());

                    instance.getMesaActual().getPersonas()[0].getMano().set(0, new Carta("CORAZON", 5));
                    assertEquals(1, instance.verificarGanador());

                    instance.colocarApuestas(40000);
                    instance.getMesaActual().getPersonas()[1].getMano().add(new Carta("DIAMANTE", 4));
                    instance.getMesaActual().getPersonas()[1].getMano().add(new Carta("PICA", 11));
                    assertEquals(0, instance.verificarGanador());

          }

          @org.junit.jupiter.api.Test
          public void asegurarGanadorTest() {
                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("PICA", 11));
                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("TREBOL", 10));
                    assertEquals(-1 / 2, instance.asegurarGanador(), 0001);

                    instance.getMesaActual().getPersonas()[2].getMano().set(1, new Carta("CORAZON", 5));
                    assertEquals(0, instance.asegurarGanador(), 0001);
          }

          @org.junit.jupiter.api.Test
          public void blackJackGanadorTest() {
                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("PICA", 11));
                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("TREBOL", 10));
                    assertEquals(3 / 2, instance.asegurarGanador(), 0001);

                    instance.getMesaActual().getPersonas()[2].getMano().set(1, new Carta("CORAZON", 5));
                    assertEquals(0, instance.asegurarGanador(), 0001);
          }

          @org.junit.jupiter.api.Test
          public void divisionGanadorTest() {
                    ArrayList<Carta> manoDividida1 = new ArrayList<Carta>();
                    ArrayList<Carta> manoDividida2 = new ArrayList<Carta>();

                    manoDividida1.add(new Carta("PICA", 10));
                    manoDividida1.add(new Carta("TREBOL", 11));
                    
                    manoDividida2.add(new Carta("CORAZON", 11));
                    manoDividida2.add(new Carta("PICA",5));

                    ArrayList<ArrayList<Carta>> manoDividida = new ArrayList<ArrayList<Carta>>();
                    
                    manoDividida.add(manoDividida1);
                    manoDividida.add(manoDividida2);
                    instance.getMesaActual().getPersonas()[0].setManoDividida(manoDividida);

                    instance.colocarApuestas(300000);

                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("PICA", 6));
                    instance.getMesaActual().getPersonas()[2].getMano().add(new Carta("TREBOL", 10));
                    assertEquals(1, instance.divisionGanador());

                    manoDividida2.set(1,new Carta("CORAZON",9));
                    assertEquals(2, instance.divisionGanador());

                    manoDividida1.set(0,new Carta("CORAZON",4));
                    manoDividida2.set(1,new Carta("CORAZON",5));
                    assertEquals(-1, instance.divisionGanador());

                    manoDividida2.set(1,new Carta("DIAMANTE",3));
                    assertEquals(-2, instance.divisionGanador());

                    
          }
}