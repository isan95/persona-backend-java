/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polanco.data;
import javax.persistence.*;
import javax.ejb.Stateless;
import java.util.List;
import com.polanco.domain.Persona;
/**
 *
 * @author POLANCO
 */
@Stateless
public class PersonaDaoImpl implements PersonaDao{
    
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;
    
    @Override
    public List<Persona> encontrarTodasPersonas(){
        return em.createNamedQuery("Persona.encontrarTodasPersonas").getResultList();
    }
    
    @Override
    public Persona encontrarPersona(Persona p){
        return em.find(Persona.class, p.getIdPersona());
    }

    @Override
    public void insertarPersona(Persona p){
        em.persist(p);
        em.flush();
    }

    @Override
    public void actualizarPersona(Persona p){
        em.merge(p);
    }

    @Override
    public void eliminarPersona(Persona p){
        em.remove(em.merge(p));
    }
}
