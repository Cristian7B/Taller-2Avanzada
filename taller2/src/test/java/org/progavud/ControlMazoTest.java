package org.progavud;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import edu.progavud.controller.ControlMazo;

public class ControlMazoTest {

          static  ControlMazo instance;

          @org.junit.jupiter.api.BeforeAll
          public static void setUpClass(){
                    instance = new ControlMazo(null);
          }

          @org.junit.jupiter.api.BeforeEach
          public  void setup(){
                    System.out.println("--------------------------------------------------[         Inicio Prueba       ]---------------------------------------------------------");
          }

          @org.junit.jupiter.api.Test
          public void  revolverMazoTest(){
                    instance.revolverMazo();
                    assertEquals(52, instance.getMazoRevuelto().size());

          }
          
          @org.junit.jupiter.api.Test
          public void getMazoRevueltoTest(){
                    instance.revolverMazo();
                    assertNotNull(instance.getMazoRevuelto());
          }

          @org.junit.jupiter.api.Test
          public void generarManoTest(){
                    instance.revolverMazo();
                    assertNotNull(instance.generarMano(1));
                    assertEquals(6,instance.generarMano(1).size());
          }

          @org.junit.jupiter.api.Test
          public void getRandomCartaTest(){
                    instance.revolverMazo();
                    assertNotNull(instance.getRandomCarta());
                    assertTrue(instance.getRandomCarta().getValorInterno()>=1 && instance.getRandomCarta().getValorInterno()<=11);
          }
          
}
