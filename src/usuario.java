/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique Domingues e Lucas Pereira 
 */
public class usuario {
    //Atributos para autenticação
    private String login;
    private String senha;
    
    //Método para criação de um novo usuário
    public usuario(String nome, String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    //GETTERS
    public String getLogin(){
        return login;
    }
    
    public String getSenha(){
        return senha;
    }
    
    //SETTERS
    public String setLogin(String l){
        return this.login = l;
    }
    
    public String setSenaha(String s){
        return this.senha = s;
    }
}
