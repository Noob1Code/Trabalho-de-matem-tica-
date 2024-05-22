/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Math;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @author Felipe Borges Carvalho <felipeborgesmelo80@gmail.com>
 * @author Gabriel Braga Oliveira <ninjagamer9795286@gmail.com>
 * @date 04/05/2024
 * @brief Class Vetores
 */
public class Vetores {

    private Double x;
    private Double y;
    private Double z;

    public Vetores() {
    }

    public Vetores(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }

    public String toString() {
        return "( "
                + String.format("%.2f", x)
                + ", "
                + String.format("%.2f", y)
                + ", "
                + String.format("%.2f", z)
                + " )";
    }
}
