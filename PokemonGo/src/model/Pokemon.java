/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mabardaji
 */
public class Pokemon {
    private int num_id;
    private String nombre;
    private String type;
    private int fuerza;

    public Pokemon(int num_id, String nombre, String type) {
        this.num_id = num_id;
        this.nombre = nombre;
        this.type = type;
    }
    
    public void fuerzaCombate () {
        int min = 1, max = 100, rango = max - min + 1;
        int rd = (int) (Math.random() * rango) + min;
        this.fuerza = rd;
        
        System.out.println("El pokemon " + this.nombre + " tiene " + this.fuerza + " puntos de fuerza");
    }

    public int getNum_id() {
        return num_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getType() {
        return type;
    }

    public void setNum_id(int num_id) {
        this.num_id = num_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "falta modificar " + this.nombre;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Pokemon)) {
            return false;
        }
        final Pokemon other = (Pokemon) obj;
        return this.num_id == other.num_id;
    }
    
    
    
    
    
    
    
    
}
