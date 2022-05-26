package com.example.t3examen.entities;

public class Pokemon {
    public int id;
    public int numero;
    public String nombre;
    public String region;
    public String imagen;
    public String codigo;
    public String tipo;

    public Pokemon() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pokemon(int id, int numero, String nombre, String region, String imagen, String codigo, String tipo) {
        this.id = id;
        this.numero = numero;
        this.nombre = nombre;
        this.region = region;
        this.imagen = imagen;
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
