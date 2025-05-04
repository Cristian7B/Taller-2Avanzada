package org.progavud;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.progavud.controller.ControlPersona;
import edu.progavud.controller.ControlPrincipal;
import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Persona;

public class ControlPersonaTest {

          static LocalDateTime tiempo;
          static ControlPersona controlPersona;

          @org.junit.jupiter.api.BeforeAll
          public static void setUpClass() {
                    controlPersona = new ControlPersona(null);
          }

          @org.junit.jupiter.api.BeforeEach
          public void setup() {
                    System.out.println("--------------------------------------------------[         Inicio Prueba       ]---------------------------------------------------------");
          }

          @org.junit.jupiter.api.AfterEach
          public void tearDown() {
                    System.out.println("Test realizado a las: " + tiempo.now());
          }

          @Test
          public void testCrearJugadorMesa() {
                    ControlPersona controlPersona = new ControlPersona(null);

                    Jugador jugador = controlPersona.crearJugadorMesa(
                                        "Juan", "Diaz", "123456", 1000, "Calle 65 sur", "5551234");

                    assertNotNull(jugador);
                    assertEquals("Juan", jugador.getNombre());
                    assertEquals(1000, jugador.getDinero());
          }

          @org.junit.jupiter.api.Test
          public void testCrearCrupier() {
                    Crupier crupier = controlPersona.crearCrupier(
                                        "Nicolas", "Velasco", "654321", 5000);

                    assertNotNull(crupier);
                    assertEquals("Nicolas", crupier.getNombre());
                    assertEquals("654321", crupier.getCedula());
          }

          @org.junit.jupiter.api.Test
          public void testMoverPersonasAlFinal() {
                    Persona[] personas = new Persona[6];
                    for (int i = 0; i < 6; i++) {
                              personas[i] = new Jugador("P" + i, "Apellido", "C" + i, 1000, "Dir", "Tel");
                    }

                    ControlPrincipal mockControlPrincipal = new ControlPrincipal() {
                              @Override
                              public Persona[] obtenerPersonas() {
                                        return personas;
                              }
                    };

                    ControlPersona controlPersona = new ControlPersona(mockControlPrincipal);

                    Persona[] resultado = controlPersona.moverPersonasAlFinal();

                    // Comprobamos que las dos primeras están ahora al final
                    assertEquals("P0", resultado[4].getNombre());
                    assertEquals("P1", resultado[5].getNombre());

                    // Comprobamos que P2 a P5 están al inicio
                    for (int i = 0; i < 4; i++) {
                              assertEquals("P" + (i + 2), resultado[i].getNombre());
                    }
          }

}

	
