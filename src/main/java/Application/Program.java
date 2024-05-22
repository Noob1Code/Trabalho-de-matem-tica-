/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Entities.Math.CalcVetores;
import Entities.Math.Vetores;
import Entities.User.RegistrationUser;
import Entities.User.Users;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @author Felipe Borges Carvalho <felipeborgesmelo80@gmail.com>
 * @author Gabriel Braga Oliveira <ninjagamer9795286@gmail.com>
 * @date 05/05/2024
 * @brief class Program
 */
public class Program {

    static Scanner sc = new Scanner(System.in);
    static CalcVetores calcvet = new CalcVetores();
    static CalcVetores calcvet2 = new CalcVetores();
    private static int contadorCase2 = 0; // Contador global para rastrear execuções do case 2
    private static int contadorCase3 = 0; // Contador global para rastrear execuções do case 3

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            exibirMenu();
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Vetores(opcao);
                    contadorCase2++;
                    break;
                case 2:
                    Vetores(opcao);
                    contadorCase3++;
                    break;
                case 3:
                    if (contadorCase2 >= 2 || contadorCase3 >= 2) {
                        Calculo();
                    } else {
                        System.out.println("Faça o cadastro de pelo menos 2 vetores do mesmo tamanho.");
                    }
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Programa encerrado.");
    }

    private static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1- Cadastrar vetores de ordem 2.");
        System.out.println("2- Cadastrar vetores de ordem 3");
        System.out.println("3- Calcular.");
        System.out.println("4- Sair.");
        System.out.print("Escolha uma opção: ");
    }

    /*
    private static void CadastrarUsuario() {
        System.out.print("Digite o nome do Usuário: ");
        String nome = sc.next();
        System.out.print("Digite seu CPF: ");
        long CPF = sc.nextLong();
        System.out.print("Digite sua data de nascimento (DD/MM/YYYY): ");

        Date dataNacimento = null;
        try {
            dataNacimento = sdf.parse(sc.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dataAtual = new Date();
        int idade = ru.CalIdade(dataNacimento, dataAtual);

        System.out.print("Digite seu email: ");
        String email = sc.next();

        System.out.print("Digite seu telefone: ");
        long telefone = sc.nextLong();

        System.out.print("Digite sua senha: ");
        String senha = sc.next();

        user.addUser(new RegistrationUser(nome, CPF, dataNacimento, idade, email, telefone, senha));

    }
     */
    private static void Vetores(int opcao) {
        boolean teste = false;

        if (opcao == 1) {
            double x = 0;
            double y = 0;
            do {

                System.out.print("Escreva o X do vetor: ");
                String testeN = sc.next();
                if (isNumeric(testeN)) {
                    x = Double.parseDouble(testeN);
                    teste = true;
                } else {
                    System.out.println("Escreva apenas numero");
                    teste = false;
                }

            } while (!teste);

            do {

                System.out.print("Escreva o Y do vetor: ");
                String testeN = sc.next();
                if (isNumeric(testeN)) {
                    y = Double.parseDouble(testeN);
                    teste = true;
                } else {
                    System.out.println("Escreva apenas numero");
                    teste = false;
                }

            } while (!teste);

            if (x == 0.0 || y == 0.0) {
                System.out.println("Não pode ter ordenada 0");
            } else {
                calcvet.addVetores(new Vetores(x, y, 0.0));
            }
        }

        if (opcao == 2) {
            double x = 0;
            double y = 0;
            double z = 0;
            do {

                System.out.print("Escreva o X do vetor: ");
                String testeN = sc.next();
                if (isNumeric(testeN)) {
                    x = Double.parseDouble(testeN);
                    teste = true;
                } else {
                    System.out.println("Escreva apenas numero");
                    teste = false;
                }

            } while (!teste);

            do {

                System.out.print("Escreva o Y do vetor: ");
                String testeN = sc.next();
                if (isNumeric(testeN)) {
                    y = Double.parseDouble(testeN);
                    teste = true;
                } else {
                    System.out.println("Escreva apenas numero");
                    teste = false;
                }

            } while (!teste);

            do {

                System.out.print("Escreva o Z do vetor: ");
                String testeN = sc.next();
                if (isNumeric(testeN)) {
                    z = Double.parseDouble(testeN);
                    teste = true;
                } else {
                    System.out.println("Escreva apenas numero");
                    teste = false;
                }

            } while (!teste);
            if (x == 0.0 || y == 0.0 || z == 0.0) {
                System.out.println("");
            } else {
                calcvet2.addVetores(new Vetores(x, y, z));
            }

        }
    }

    private static void Calculo() {
        System.out.println("Com qual opção:"
                + "\n1 vetor de 2 posição"
                + "\n2 vetor de 3 posição");
        int op = sc.nextInt();
        if (op == 1) {
            do {
                System.out.println("O que você deseja calcular?"
                        + "\n1- Vetores no Plano: "
                        + "\n2- Produto Escalar:"
                        + "\n3- Ângulo entre Vetores:"
                        + "\n4- Ortogonalidade:"
                        + "\nEscolha uma dessas opções: ");
                int opcao = sc.nextInt();
                if (opcao > 0 && opcao <= 4) {
                    calcvet.MostrarVetores();
                    System.out.println("Escolha os vetores para calcular vetores");
                    System.out.print("Primeiro vetor: ");
                    int vetor1 = sc.nextInt();
                    System.out.print("Segundo vetor: ");
                    int vetor2 = sc.nextInt();
                    calcvet.SepararVetor(vetor1 - 1, vetor2 - 1, opcao);
                    break;
                } else {
                    System.out.println("Não existe essa opção");
                    continue;
                }
            } while (true);
        } else if (op == 2) {
            do {
                System.out.println("O que você deseja calcular?"
                        + "\n1- Vetores no Plano: "
                        + "\n2- Produto Escalar:"
                        + "\n3- Ângulo entre Vetores:"
                        + "\n4- Ortogonalidade:"
                        + "\n5- Produto Vetorial:"
                        + "\nEscolha uma dessas opções: ");
                int opcao = sc.nextInt();
                if (opcao > 0 && opcao <= 5) {
                    calcvet2.MostrarVetores();
                    System.out.println("Escolha os vetores para calcular vetores");
                    System.out.print("Primeiro vetor: ");
                    int vetor1 = sc.nextInt();
                    System.out.print("Segundo vetor: ");
                    int vetor2 = sc.nextInt();

                    calcvet2.SepararVetor(vetor1 - 1, vetor2 - 1, opcao);
                    break;
                } else {
                    System.out.println("Não existe essa opção");
                    continue;
                }
            } while (true);
        }
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
