/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polanco.domain;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author POLANCO
 */
@Entity
@NamedQueries(
{@NamedQuery(name = "Persona.encontrarTodasPersonas", query = "SELECT p FROM Persona p ORDER BY p.idPersona")}
)
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona")
    private int idPersona;

    private String nombre;
    
    public Persona(){
    
    }

    public Persona(int idPersona){
        this.idPersona = idPersona;
    }

    public Persona(int idPersona, String nombre){
        this.idPersona = idPersona;
        this.nombre = nombre;
    }
    
    public void setIdPersona(int idPersona){
        this.idPersona = idPersona;
    }
    
    public int getIdPersona(){
        return this.idPersona;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString(){
        return "Persona[idPersona= "+this.idPersona+", nombre= "+this.nombre+"]";
    }
}
