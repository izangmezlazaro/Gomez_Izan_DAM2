package examen.gomez.izan;

import java.util.ArrayList;

import examen.gomez.izan.beans.Laboratorio;
import examen.gomez.izan.beans.MuestraADN;
import examen.gomez.izan.dao.MuestraADNDAOImpl;
import examen.gomez.izan.motores.MotorFactory;

public class main {

    public static void main(String[] args) {

  
        Laboratorio lab = new Laboratorio(); 
        lab.setId(1);

        MuestraADNDAOImpl muestraDAO =
                new MuestraADNDAOImpl(MotorFactory.create(MotorFactory.POSTGRE));

 // TEST 1 ADD MUESTRA ADN
 MuestraADN muestraADD = new MuestraADN(2,"adn1","sangre","2022-02-15","IZAN_GOMEZ",2,"hola");
 muestraDAO.add(muestraADD);
// TEST 2 UPDATE MUESTRA ADN
 MuestraADN muestraUpdate = new MuestraADN(2, "adn2","sangre",  "2022-02-15", "IZAN_GOMEZ", 2,"hola" );
 muestraDAO.update(1, muestraUpdate);
 //TEST 3 FIND
 MuestraADN muestraFIND = muestraDAO.find(1);
    System.out.println(muestraFIND);
    System.out.println(" ");
// TEST 4 FIND ALL MUESTRAS ADN
    ArrayList<MuestraADN> muestraFINDALL = muestraDAO.findAll();
    for (MuestraADN muestra : muestraFINDALL) {
        System.out.println(muestra);
    }
    System.out.println(" ");
// TEST 5 FIND MUESTRAS_ADN BY LABORATORIO
    ArrayList<MuestraADN> muestraFINDBYLAB = muestraDAO.findByLaboratorio(1);
    for (MuestraADN s : muestraFINDBYLAB) {
         System.out.println(s);
    }
    System.out.println(" ");
// TEST 6  FIND MUESTRA WITH ANALISIS
    MuestraADN muestraAnalisis = muestraDAO.findMuestraADNWithDetail(1);
    System.out.println(muestraAnalisis);
    System.out.println(muestraAnalisis.getDetalle());
    System.out.println(" ");
}

}