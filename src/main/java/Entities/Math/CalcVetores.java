/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @author Felipe Borges Carvalho <felipeborgesmelo80@gmail.com>
 * @author Gabriel Braga Oliveira <ninjagamer9795286@gmail.com>
 * @date 10/05/2024
 * @brief Class CalcVetores
 */
public class CalcVetores {

    private List<Vetores> vetors = new ArrayList<>();

    public CalcVetores() {
    }

    public void addVetores(Vetores vetor) {
        vetors.add(vetor);
    }

    public void addRemove(Vetores vetor) {
        vetors.remove(vetor);
    }

    public void VetoresNoPlano(Double x1, Double y1, Double z1, Double x2, Double y2, Double z2) {
        Double distancia = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));

        System.out.printf("O vetor no plano: %.2f", distancia);
    }

    public void ProdutoEscalar(Double x1, Double y1, Double z1, Double x2, Double y2, Double z2) {
        Double escalar = (x1 * x2) + (y1 * y2) + (z1 * z2);
        System.out.printf("O produto escalar: %.2f", escalar);

    }

    public Double Modulo(Double x, Double y, Double z) {
        Double modulo = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

        if (modulo < 0) {
            modulo = modulo * -1;
            return modulo;
        }
        return modulo;
    }

    public void AnguloEntreVetores(Double x1, Double y1, Double z1, Double x2, Double y2, Double z2) {
        Double cos = ((x1 * x2) + (y1 * y2) + (z1 * z2)) / (Modulo(x1, y1, z1) * Modulo(x2, y2, z2));
        Double angulo = Math.acos(cos);
        Double anguloGrau = Math.toDegrees(angulo);

        System.out.printf("O ângulo entre vetores: %.2f", anguloGrau);
    }

    public void Ortogonalidade(Double x1, Double y1, Double z1, Double x2, Double y2, Double z2) {
        Double ortogonal = (x1 * x2) + (y1 * y2) + (z1 * z2);
        if (ortogonal == 0.0) {
            System.out.println("É ortogonal");
        } else {
            System.out.println("Não é ortogonal");
        }
    }

    public void ProdutoVetorial(Double x1, Double y1, Double z1, Double x2, Double y2, Double z2) {
        Double i = y1 * z2 - z1 * y2;
        Double j = z1 * x2 - x1 * z2;
        Double k = x1 * y2 - y1 * x2;

        System.out.println("Produto vetorias: (" + i + ", " + j + ", " + k + ")");

    }

    public void SepararVetor(Integer primeiro, Integer segundo, Integer calc) {
        Vetores vetor1 = vetors.get(primeiro);
        Vetores vetor2 = vetors.get(segundo);

        Double x1 = vetor1.getX();
        Double y1 = vetor1.getY();
        Double z1 = vetor1.getZ();
        Double x2 = vetor2.getX();
        Double y2 = vetor2.getY();
        Double z2 = vetor2.getZ();

        switch (calc) {
            case 1:
                VetoresNoPlano(x1, y1, z1, x2, y2, z2);
                break;
            case 2:
                ProdutoEscalar(x1, y1, z1, x2, y2, z2);
                break;
            case 3:
                AnguloEntreVetores(x1, y1, z1, x2, y2, z2);
                break;
            case 4:
                Ortogonalidade(x1, y1, z1, x2, y2, z2);
                break;
            case 5:
                ProdutoVetorial(x1, y1, z1, x2, y2, z2);
                break;
        }

    }

    public void MostrarVetores() {
        Integer i = 1;

        for (Vetores vet : vetors) {
            System.out.println(i + ": " + vet);
            i++;
        }
    }

}
