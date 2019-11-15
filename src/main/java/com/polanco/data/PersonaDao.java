package com.polanco.data;
import java.util.List;
import com.polanco.domain.Persona;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author POLANCO
 */
public interface PersonaDao {
    
    public List<Persona> encontrarTodasPersonas();

    public Persona encontrarPersona(Persona p);

    public void insertarPersona(Persona p);

    public void actualizarPersona(Persona p);

    public void eliminarPersona(Persona p);

}
