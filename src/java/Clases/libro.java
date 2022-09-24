/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author susan
 */
public class Libro {
    private String codigo;
    private String nombre;
    private String tipo;
    private String editorial;
    private String publicacion;

    public Libro(String codigo, String nombre, String tipo, String editorial, String publicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.publicacion = publicacion;
    }
    
    public Libro() {this.nombre="Principito";}
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }}
    
   