package model;

/**
 * Created by Juanjo on 19/04/2017.
 */

import java.util.*;
import java.util.Comparator;

public class Producto implements Comparable<Producto>,Comparator<Producto> {
    private String nombre;
    private double precio;

    public Producto() {
        this.nombre="Bolsa";
        this.precio=0.05;
    }

    public Producto(String nombre, double precio) {
        this.setNombre(nombre);
        this.setPrecio(precio);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: " +
                "Nombre= " + nombre +
                ", Precio= " + precio + "€ ";
    }

    @Override
    public int compareTo(Producto o) {
        return 0;
    }

    @Override
    public int compare(Producto o1, Producto o2) {
        int res;

        res=o1.getNombre().compareToIgnoreCase(o2.getNombre());
        if (res !=0) {
            return res;
        }
        return Double.compare(o1.getPrecio(),o2.getPrecio());
    }
}