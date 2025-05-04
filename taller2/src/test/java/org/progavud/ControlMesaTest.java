package org.progavud;
import static org.junit.jupiter.api.Assertions.*;

import edu.progavud.controller.ControlMesa;
import edu.progavud.model.Crupier;
import edu.progavud.model.Jugador;
import edu.progavud.model.Persona;
import java.time.LocalDateTime;

public class ControlMesaTest {

          static LocalDateTime tiempo;
          static  ControlMesa instance;
          static Persona jugador1;
          static Persona jugador2;
          static Persona crupier;

          @org.junit.jupiter.api.BeforeAll
          public static void setUpClass(){
                    instance = new ControlMesa(null);
                    jugador1 = new Jugador("Cristian","Bonilla","12341234",1000000,"Avenida Villavicencio","12341234",10);
                    jugador2 = new Jugador("Nicolas","Velasco","12431243",1200000,"Avenida el dorado","12431243",10);
                    crupier = new Crupier("Juan","Diaz","12346544",200000000);
                    instance.agregarJugadorMesa(jugador1, 0);
                    instance.agregarJugadorMesa(jugador2, 1);
                    instance.agregarJugadorMesa(crupier, 2);
          }

          @org.junit.jupiter.api.AfterAll
          public static void tearDownClass(){

          }

          @org.junit.jupiter.api.BeforeEach
          public  void setup(){
                    System.out.println("--------------------------------------------------[         Inicio Prueba       ]---------------------------------------------------------");
          }

          @org.junit.jupiter.api.AfterEach
          public void tearDown(){
                    System.out.println("Prueba finalizada a las: \t"+tiempo.now());
          }

          @org.junit.jupiter.api.Test
          public void colocarApuestasTest(){
                    instance.colocarApuestas(25000);
                    instance.colocarApuestas(300000000);
                    assertEquals(instance.getMesaActual().getApuestasDeLaMesa(),300025000);
          }

          @org.junit.jupiter.api.Test
          public void  agregarJugadorMesaTest(){
                    //Revisa si la referencia a la persona en la mesa recien agregada no es nula.
                    assertNotNull(instance.getMesaActual().getPersonas()[0]);
                    assertNotNull(instance.getMesaActual().getPersonas()[1]);
                    assertNotNull(instance.getMesaActual().getPersonas()[2]);
                    //Revisa si se agregaron correctamente las personas en las posiciones dadas.
                    assertNotEquals(instance.getMesaActual().getPersonas()[0], crupier);
                    assertNotEquals(instance.getMesaActual().getPersonas()[1], crupier);
                    assertNotEquals(instance.getMesaActual().getPersonas()[0], jugador2);
                    assertNotEquals(instance.getMesaActual().getPersonas()[1], jugador1);
          }


          @org.junit.jupiter.api.Test
          public void  verificarDoblarTest(){

                    instance.verificarDoblar();
          }

}
