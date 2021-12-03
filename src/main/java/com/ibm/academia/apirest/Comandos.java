package com.ibm.academia.apirest;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Empleado;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.EmpleadoDAO;
import com.ibm.academia.apirest.services.ProfesorDAO;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Comandos implements CommandLineRunner {
    @Autowired
    private CarreraDAO carreraDao;

    @Autowired
    private ProfesorDAO profesorDAO;

    @Autowired
    private EmpleadoDAO empleadoDAO;


    @Override
    public void run(String... args) throws Exception {
        /*Carrera finanzas = new Carrera(null, "Ingenieria en finanzas", 20, 3);
        Carrera carreraGuardada = carreraDao.guardar(finanzas);
        System.out.println(carreraGuardada.toString());*/

        /*Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 40, 4);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 42, 4);
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 25, 3);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 33, 3);

        carreraDao.guardar(ingSistemas);
        carreraDao.guardar(ingIndustrial);
        carreraDao.guardar(ingAlimentos);
        carreraDao.guardar(ingElectronica);
        carreraDao.guardar(licSistemas);
        carreraDao.guardar(licTurismo);
        carreraDao.guardar(licYoga);
        carreraDao.guardar(licRecursos);*/

        //List<Carrera> carreras = (List<Carrera>)carreraDao.findCarrerasByNombreContains("Sistemas");
        //Set<Carrera>listaCarreras= new HashSet<Carrera>(carreras);
        //carreras.forEach(System.out::println);

        /*Persona profesorMauro=new Profesor(null,"Mauro","Sanchez Sanchez","202535",null,new BigDecimal(1500));
        Persona guardada=profesorDAO.guardar(profesorMauro);
        System.out.println(((Profesor)guardada).toString());
        Persona profesoraBany=new Profesor(null,"Bany","Hernandez Cadrdona","202589",null,new BigDecimal(1800));
        profesorDAO.guardar(profesoraBany);
        Persona profesorBenjamin=new Profesor(null,"Benjamin","Gnzalez","202599",null,new BigDecimal(2800));
        profesorDAO.guardar(profesorBenjamin);*/

        //Profesor profesoraBany =(Profesor) profesorDAO.buscarPorID(3).get();
        //System.out.println(profesoraBany.toString());

        //profesoraBany.setCarreras(listaCarreras);
        //profesorDAO.guardar(profesoraBany);

        /*Persona empleado1= new Empleado(null,"Angel","valdes","00002",null,new BigDecimal(10000),TipoEmpleado.ADMINISTRATIVO);
        Persona  empleadoGuardado=empleadoDAO.guardar(empleado1);
        System.out.println(((Empleado)empleadoGuardado).toString());*/

        List<Persona> profesores = (List<Persona>)profesorDAO.buscarPorfesoresesPorNombreCarrera("Licenciatura en Sistemas");
        profesores.forEach(System.out::println);




    }
}
