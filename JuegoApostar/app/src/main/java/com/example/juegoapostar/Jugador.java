package com.example.juegoapostar;

public class Jugador {

    int id ;
    String nombre;
    int intentos;

    public Jugador(int id, String nombre, int intentos) {
        this.id = id;
        this.nombre = nombre;
        this.intentos = intentos;
    }

    public Jugador(Jugador jugador) {

    }

    public Jugador() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
