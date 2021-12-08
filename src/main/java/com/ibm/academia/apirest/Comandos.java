package com.ibm.academia.apirest;

import com.ibm.academia.apirest.entities.*;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.services.*;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;
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

    @Autowired
    private AulaDAO aulaDAO;

    @Autowired
    private PabellonDAO pabellonDAO;


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

        /*Persona profesorMauro=new Profesor(null,"Mauro","imple","202535",null,new BigDecimal(1500));
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

        /*Persona empleado1= new Empleado(null,"Shair","valdes","00003",null,new BigDecimal(12000),TipoEmpleado.ADMINISTRATIVO);

        Persona empleado2= new Empleado(null,"Manuel","Ortega","00004",null,new BigDecimal(10000),TipoEmpleado.MANTENIMIENTO);

        Persona empleado3= new Empleado(null,"Jose","Ortega","00005",null,new BigDecimal(9000),TipoEmpleado.ADMINISTRATIVO);
        empleadoDAO.guardar(empleado1);
        empleadoDAO.guardar(empleado2);
        empleadoDAO.guardar(empleado3);/*

        //System.out.println(((Empleado)empleadoGuardado).toString());

        /*List<Persona> profesores = (List<Persona>)profesorDAO.buscarPorfesoresesPorNombreCarrera("Licenciatura en Sistemas");
        profesores.forEach(System.out::println);*/

        //List<Persona> empleados=(List<Persona>)empleadoDAO.findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
        //empleados.forEach(System.out::println);

       /* List<Carrera> carreras =(List<Carrera>) carreraDao.buscarCarrerasPorProfesorNombreYApellido("Mauro","Sanchez Sanchez");
        carreras.forEach(System.out::println);*/
        /*Aula aula1= new Aula(null,2,"2x4",50, Pizarron.PIZARRA_BLANCA);
        //Aula aula2= new Aula(null,3,"4x4",35, Pizarron.PIZARRA_TIZA);
        Aula aula3= new Aula(null,1,"4x4",40, Pizarron.PIZARRA_TIZA);
        Aula aula4= new Aula(null,4,"6x6",50, Pizarron.PIZARRA_BLANCA);
        Aula aula6= new Aula(null,5,"6x8",25, Pizarron.PIZARRA_BLANCA);
        Aula aula7= new Aula(null,6,"6x8",30, Pizarron.PIZARRA_TIZA);

        aulaDAO.guardar(aula2);
        aulaDAO.guardar(aula3);
        aulaDAO.guardar(aula4);
        aulaDAO.guardar(aula6);
        aulaDAO.guardar(aula7);
        //System.out.println(aulaDAO.guardar(aula1).toString());*/

        //Pabellon pabellon1=new Pabellon(null,27.0,"Pabellon 6",new Direccion("calle","1","52000","NA","1","localidad 3"));
        //System.out.println(pabellonDAO.guardar(pabellon1).toString());

        //Aula aulaExtarida= aulaDAO.buscarPorID(6).get();

        //Pabellon pabellonExtaido=pabellonDAO.buscarPorID(3).get();

        //aulaExtarida.setPabellon(pabellonExtaido);
        //aulaDAO.guardar(aulaExtarida);

        /*List<Aula>aulas= (List<Aula>) aulaDAO.findAulaByPizarron(Pizarron.PIZARRA_TIZA);
        List<Aula>aulas= (List<Aula>) aulaDAO.findByNumeroAula(6);
        List<Aula>aulas= (List<Aula>) aulaDAO.findByPabellon("Pabellon 2");
        aulas.forEach(System.out::println);
        */

        /*List<Pabellon>pabellones= (List<Pabellon>) pabellonDAO.findByLocalidString("localidad 3");
        List<Pabellon>pabellones= (List<Pabellon>) pabellonDAO.findByNombre("Pabellon 4");
        pabellones.forEach(System.out::println);*/

    }
}
