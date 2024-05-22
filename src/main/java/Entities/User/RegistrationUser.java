/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

/**
 *
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @author Felipe Borges Carvalho <felipeborgesmelo80@gmail.com>
 * @author Gabriel Braga Oliveira <ninjagamer9795286@gmail.com>
 * @date 03/05/2024
 * @brief class User
 */
public class RegistrationUser {

    private String nome;
    private long CPF;
    private Date nacimento;
    private Integer idade;
    private String email;
    private long telefone;
    private String senha;

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public RegistrationUser() {
    }

    public RegistrationUser(String nome, long CPF, Date nacimento, Integer idade, String email, long telefone, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.nacimento = nacimento;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;

    }

    public String getNome() {
        return nome;
    }

    public long getCPF() {
        return CPF;
    }

    public Date getNacimento() {
        return nacimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public long getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public static boolean validarCPF(String cpf, ArrayList<RegistrationUser> users) {
        int[] numeros = new int[11];
        char primeiroDigito = cpf.charAt(0);

        // Verifica se todos os dígitos são iguais
        for (int i = 0; i < cpf.length(); i++) {
            if (cpf.charAt(i) != primeiroDigito) {
                break;
            }
            if (i == cpf.length() - 1) {
                return false; // Todos os dígitos são iguais, CPF inválido
            }
        }

        /*
		 * 1.int[] numeros = new int[11]; Um vetor de inteiros chamado numeros é criado
		 * com um tamanho de 11 elementos. No entanto, este vetor não é utilizado no no
		 * primeiro for.
		 * 
		 * 2.char primeiroDigito = cpf.charAt(0); O primeiro dígito do CPF é extraído e
		 * armazenado na variável primeiroDigito.
		 * 
		 * 3. Um loop for é utilizado para percorrer todos os dígitos do CPF:-> no caso
		 * a string passa pra ele
		 * 
		 * 4.Dentro do loop, é verificado se cada dígito é diferente do primeiroDigito.
		 * Se um dígito diferente for encontrado, o loop é interrompido usando break.
		 * 
		 * 5.No entanto, se o loop for concluído sem interrupções (ou seja, nenhum
		 * dígito diferente foi encontrado), isso significa que todos os dígitos são
		 * iguais.
		 * 
		 * Nesse caso, a função retorna false, indicando que o CPF é inválido devido a
		 * todos os dígitos serem iguais.Em resumo, esse trecho de código verifica se
		 * todos os dígitos de um CPF são iguais e retorna false
         */
        for (int i = 0; i < 11; i++) {
            numeros[i] = Character.getNumericValue(cpf.charAt(i));
        }

        /*
		 * 1. for (int i = 0; i < 11; i++) {: Inicia um loop for que vai de 0 a 10
		 * (inclusive), percorrendo os índices do vetor numeros.
		 * 
		 * 2.numeros[i] = Character.getNumericValue(cpf.charAt(i));: Para cada iteração
		 * do loop, a expressão dentro do loop é executada. Aqui, "cpf.charAt(i)" obtém
		 * o caractere na posição i da string cpf. Character.getNumericValue(...)
		 * converte esse caractere em um valor numérico.Se o caractere for um dígito
		 * numérico (0 a 9), getNumericValue retorna o valor numérico correspondente. Se
		 * o caractere não for um dígito, ele retorna -1.O valor numérico resultante é
		 * atribuído ao elemento de índice i no array numeros
         */
        int soma = 0;
        int primeiroCalculado, segundoCalculado;

        /*
		 * Declaração de uma variável chamada primeiroCalculado que será utilizada para
		 * armazenar o valor calculado do primeiro dígito verificador do CPF.-1#
		 * 
		 * Declaração de uma variável chamada segundoCalculado que será utilizada para
		 * armazenar o valor calculado do segundo dígito verificador do CPF. -#1
         */
        for (int i = 0, peso = 10; i < 9; i++, peso--) {
            soma += numeros[i] * peso;
        }

        /*
		 * Um loop é utilizado para percorrer os primeiros nove dígitos do CPF.Cada
		 * dígito é multiplicado pelo seu peso correspondente (inicializado em 10 e
		 * diminuído a cada iteração).O resultado é acumulado na variável soma.
         */
        primeiroCalculado = 11 - (soma % 11);

        /*
		 * Calcula o valor do primeiro dígito verificador subtraindo o resto da divisão
		 * da soma por 11 de 11.O resultado é armazenado na variável primeiroCalculado.
         */
        if (primeiroCalculado > 9) {
            primeiroCalculado = 0;
        }

        // Verifica se o valor calculado para o primeiro dígito verificador é maior que
        // 9.Se for, o valor é ajustado para 0.
        soma = 0;

        for (int i = 0, peso = 11; i < 10; i++, peso--) {
            soma += numeros[i] * peso;
        }

        /*
		 * Um loop é utilizado para percorrer os dez primeiros dígitos do CPF (incluindo
		 * o primeiro dígito verificador já calculado). Cada dígito é multiplicado pelo
		 * seu peso correspondente (inicializado em 11 e diminuído a cada iteração).O
		 * resultado é acumulado na variável soma.
         */
        segundoCalculado = 11 - (soma % 11);

        /*
		 * Calcula o valor do segundo dígito verificador subtraindo o resto da divisão
		 * da soma por 11 de 11.O resultado é armazenado na variável segundoCalculado.
         */
        if (segundoCalculado > 9) {
            segundoCalculado = 0;
        }

        for (RegistrationUser a : users) {
            if (cpf.equals(users)) {
                System.out.println("CPF já cadastrado, tente novamente com um CPF válido.");
                return false;
            }
        }
        return primeiroCalculado == numeros[9] && segundoCalculado == numeros[10];
        // Verifica se o valor calculado para o segundo dígito verificador é maior que
        // 9.Se for, o valor é ajustado para 0.

        /*
		 * primeiroCalculado == numeros[9]: Compara se o primeiro dígito verificador
		 * calculado (primeiroCalculado) é igual ao dígito verificador inteiro presente
		 * na posição 9 do vetor numeros.segundoCalculado == numeros[10]: Compara se o
		 * segundo dígito verificador calculado (segundoCalculado) é igual ao dígito
		 * verificador inteiro presente na posição 10 do vetor numeros.A expressão
		 * retorna true se ambas as comparações forem verdadeiras, indicando que os
		 * dígitos verificadores calculados correspondem aos dígitos verificadores
		 * inteiro do CPF. Caso contrário, retorna false, indicando que o CPF não é
		 * válido.
         */
    }

    public static int CalIdade(Date nacimento, Date dataAtual) {

        long diferencaMilissegundos = dataAtual.getTime() - nacimento.getTime();
        long milissegundoAno = 1000L * 60 * 60 * 24 * 365;
        int idade = (int) (diferencaMilissegundos / milissegundoAno);
        return idade;
    }

}
