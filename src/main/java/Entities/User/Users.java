/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.User;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Kayque de Freitas <kayquefreitas08@gmail.com>
 * @author Felipe Borges Carvalho <felipeborgesmelo80@gmail.com>
 * @author Gabriel Braga Oliveira <ninjagamer9795286@gmail.com>
 * @date 03/05/2024
 * @brief class Users
 */
public class Users {

    private ArrayList<RegistrationUser> users;

    public Users() {
        users = new ArrayList<>();
    }

    public ArrayList<RegistrationUser> getUsers() {
        return users;
    }

    public void addUser(RegistrationUser user) {
        users.add(user);
    }

    public void removeUser(RegistrationUser user) {
        users.remove(user);
    }

    public boolean loginemail(String login, String senha) {
        for (RegistrationUser a : users) {
            if (a.getEmail().equals(login)) {
                if (a.getSenha().equals(senha)) {
                    System.out.println("Login bem Sucedido");
                    return true;
                }
            }
        }
        System.out.println("Login ou senha incorreto");
        return false;
    }

}
