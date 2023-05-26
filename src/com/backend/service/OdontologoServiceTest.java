package com.backend.service;

import com.backend.dao.impl.OdontologoDaoH2;
import com.backend.dao.impl.OdontologoDaoMemoria;
import com.backend.entity.Odontologo;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private static Connection connection = null;
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
    private OdontologoService odontologoServiceMemoria = new OdontologoService(new OdontologoDaoMemoria());

    @Test
    public void deberiaAgregarUnOdontologo() {
        //Al correr Application se agregan tres odontologos mediante el create.sql para el test, en esta instancia creamos dentro del test uno mas
        Odontologo odoTest = new Odontologo(1222, "Maria", "Perez");

        Odontologo odontologoResult = odontologoService.guardarOdontologo(odoTest);

        assertNotNull(odontologoResult);
        assertEquals(1222, odontologoResult.getNumeroMatricula());

    }

    @Test
    public void deberiaListarTodosLosOdontologos() {
        List<Odontologo> odontologoTest = odontologoService.listarOdontologos();

        assertFalse(odontologoTest.isEmpty());
        assertTrue(odontologoTest.size() >= 3);
    }

    @Test
    public void deberiaAgregarUnOdontologoEnMemoria() {
        Odontologo odo1 = new Odontologo(123, "Martinez", "Jose");
        Odontologo odo2 = new Odontologo(123, "Martinez", "Mario");
        Odontologo odo3 = new Odontologo(123, "martinez", "Gustavo");
        odo1.setId(1);
        odo2.setId(2);
        odo3.setId(3);

        Odontologo odontologoResult = odontologoServiceMemoria.guardarOdontologo(odo1);
        odontologoServiceMemoria.guardarOdontologo(odo2);
        odontologoServiceMemoria.guardarOdontologo(odo3);

        assertNotNull(odontologoResult);
        assertEquals(123, odontologoResult.getNumeroMatricula());


    }

    @Test
    public void deberiaListarTodosLosOdontologosEnMemoria() {

        //Se crean tres odontologos primero para poder verificar luego que los lista correctamente

        Odontologo odo1 = new Odontologo(123, "Martinez", "Jose");
        Odontologo odo2 = new Odontologo(123, "Martinez", "Mario");
        Odontologo odo3 = new Odontologo(123, "martinez", "Gustavo");
        odo1.setId(1);
        odo2.setId(2);
        odo3.setId(3);

        Odontologo odontologoResult = odontologoServiceMemoria.guardarOdontologo(odo1);
        odontologoServiceMemoria.guardarOdontologo(odo2);
        odontologoServiceMemoria.guardarOdontologo(odo3);

        //Se realiza el test del listado

        List<Odontologo> odontologosTest = odontologoServiceMemoria.listarOdontologos();


        assertFalse(odontologosTest.isEmpty());
        assertTrue(odontologosTest.size() >= 3);


    }


}