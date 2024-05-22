/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.User;

/**
 *
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @author Felipe Borges Carvalho <felipeborgesmelo80@gmail.com>
 * @author Gabriel Braga Oliveira <ninjagamer9795286@gmail.com>
 * @data 05/05/2024
 * @brief Class Validacao
 */
public class Validacao {

    public static boolean validarTelefone(String numero) {
        char validar = numero.charAt(0);
        int temporal = 0;

        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) != validar) {
                temporal = (int) (numero.charAt(i));
                break;
            }
            if (temporal >= 0) {

            } else {
                return false;
            }

            if (i == numero.length() - 1) {
                System.out.println("Não existe número com todos os digitos iguais, por conta do DDD");
                return false; // Todos os dígitos são iguais, número inválido
            }
        }

        return true;
    }

    public static boolean validarNumeros(String numero) {
        char validar = numero.charAt(0);
        int temporal = 0;

        for (int i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) != validar) {
                temporal = (int) (numero.charAt(i));
                break;
            }
            if (temporal >= 0) {

            } else {
                return false;
            }

        }

        return true;
    }

    public static boolean verificarLetras(String verificarDATA) {
        return verificarDATA.matches(".*[a-zA-Z]+.*");

    }

    public static boolean verificarLN(String verificarLN) {
        return verificarLN != null && verificarLN.matches("^[a-zA-Z0-9]*$");

    }

    public static boolean validarNomeCompleto(String nome) {

        // Remove espaços da string
        String semEspacos = removerEspacos(nome);
        if (semEspacos == null || semEspacos.isEmpty()) {
            System.out.println("Cade o nome?.");
            return false;
        }
        if (contarLetras(semEspacos) < 6) {
            System.out.println("Digite nome e sobrenome.");
            return false;
        }
        if (validarVogalConsoante(semEspacos)) {

        } else {
            System.out.println("O nome tem que conter pelo menos 1 consoante e uma vogal.");
            return false;
        }
        // Verifica se a string não contém números
        if (contemNumeros(semEspacos)) {
            System.out.println("Não digite número no nome.");
            return false;
        }

        // Verifica se a string não contém mais de 3 letras repetidas
        if (letrasRepetidas(semEspacos)) {
            System.out.println("O nome não pode conter mais de 3 letras repetidas em sequencia.");
            return false;
        }

        // Verifica se a string não contém caracteres especiais
        if (caracteresEspeciais(semEspacos)) {
            System.out.println("Nome não pode ter caractere especiais.");
            return false;
        }

        return true;
    }

    private static String removerEspacos(String nome) {
        // Substitui todos os espaços por uma string vazia
        return nome.replaceAll("\\s", "");
    }

    private static int contarLetras(String nome) {
        int countLetras = 0;
        for (int i = 0; i < nome.length(); i++) {
            if (Character.isLetter(nome.charAt(i))) {

                // Character.isLetter verifica na posição indicada para ele se e uma letra.
                countLetras++;
            }
        }
        return countLetras;
    }

    private static boolean contemNumeros(String nome) {
        for (int i = 0; i < nome.length(); i++) {
            if (Character.isDigit(nome.charAt(i))) {

                // Character.isDigit verifica na posição indicada para ele se e uma numero.
                System.out.println("O nome não pode conter números.");
                return true;
            }
        }

        return false;
    }

    private static boolean letrasRepetidas(String nome) {
        int countRepeticoes = 1;

        for (int i = 0; i < nome.length() - 1; i++) {
            if (nome.charAt(i) == nome.charAt(i + 1)) {
                countRepeticoes++;

                // Se houver mais de 3 repetições consecutivas, retorne true
                if (countRepeticoes > 2) {
                    return true;
                }
            } else {
                // Se a letra atual é diferente da próxima, reinicia a contagem
                countRepeticoes = 1;
            }
        }

        return false;
    }

    private static boolean caracteresEspeciais(String nome) {
        for (int i = 0; i < nome.length(); i++) {
            char f = nome.charAt(i);
            if (!Character.isLetter(f)) {
                /*
				 * Character.isLetter verifica na posição indicada para ele se e difente da
				 * letra ou seja caractere especial tudo que for diferente da letra, utilizando
				 * o ! para negar ou seja se for uma letra passa se n for ela barra porque e
				 * diferente da letra.
                 */
                return true;
            }
        }
        return false;
    }

    public static boolean validarVogalConsoante(String nome) {
        int contVogais = 0;
        int contConsoantes = 0;

        for (int i = 0; i < nome.length(); i++) {
            char g = Character.toLowerCase(nome.charAt(i));

            if (Character.isLetter(g)) {
                if (verificarVogal(g)) {
                    contVogais++;
                } else {
                    contConsoantes++;
                }
            }
        }

        return contVogais >= 1 && contConsoantes >= 1;
    }

    private static boolean verificarVogal(char k) {
        return k == 'a' || k == 'e' || k == 'i' || k == 'o' || k == 'u';
    }
}
