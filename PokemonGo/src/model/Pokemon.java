/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joal7509
 */
public class Pokemon {
    private int num;
    private String name;
    private String type;

    public Pokemon(int num, String name, String type) {
        this.num = num;
        this.name = name;
        this.type = type;
    }
    
    public Pokemon(String name, String type) {
        this.num = 0;
        this.name = name;
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pokemon " + name + " tipo " + type;
    }

    
    
}
