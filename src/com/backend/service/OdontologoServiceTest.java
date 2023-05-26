package com.backend.service;

import com.backend.dao.impl.OdontologoDaoH2;
import com.backend.entity.Odontologo;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private static Connection connection = null;
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void deberiaAgregarUnOdontologo(){
        Odontologo odoTest = new Odontologo(1222, "Nombre","Apellido");

        Odontologo odontologoResult = odontologoService.guardarOdontologo(odoTest);

        assertNotNull(odontologoResult);
        assertEquals(1222, odontologoResult.getNumeroMatricula());

    }

    @Test
    public void deberiaListarTodosLosOdontologos(){
        List<Odontologo> odontologoTest = odontologoService.listarOdontologos();

        assertFalse(odontologoTest.isEmpty());
        assertTrue(odontologoTest.size() >= 4);
     }

}