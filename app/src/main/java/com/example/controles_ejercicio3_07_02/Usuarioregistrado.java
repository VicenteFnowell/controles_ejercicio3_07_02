package com.example.controles_ejercicio3_07_02;

/**
 * Created by Vicente FN on 08/02/2018.
 */

public class Usuarioregistrado {

    //Atributos
    String nombre;
    String apellido;
    String provincia;
    String estadociv;
    int edad;


    public Usuarioregistrado(String nombre, String apellido, String provincia, String estadociv, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.provincia = provincia;
        this.estadociv = estadociv;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEstadociv() {
        return estadociv;
    }

    public void setEstadociv(String estadociv) {
        this.estadociv = estadociv;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }







}//Fin Clase Usuario
