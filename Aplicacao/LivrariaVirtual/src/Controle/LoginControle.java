/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author cliente
 */
public class LoginControle {
    private LoginView view;
    int nmero =  (int) Math.random();

    public LoginControle(LoginView view) {
        this.view = view;
    }
    
    public int media(){
        int a = 10;
        int b = 7;
        
        return a/b;
    }
    
    public void autenticar(){
        
        
        
        //BUSCAR USUARIO DA VIEW e INSTANCIAR O USUARIO
        String usuario = view.getjTextFielduUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(usuario, senha);
        
        //VERIFICAR SE O USUARIO EXISTE NO BANCO DE DADOS
        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            
            boolean existe = usuarioDAO.existeUsuarioESenha(usuarioAutenticar);
           // System.out.println(false);
            System.out.println("ENtrou");
            //SE EXISTIR DIRECIONA PARA MENU
            if(existe){
                MenuView telaDeMenu = new MenuView();
                telaDeMenu.setVisible(true); // PREMITE A NAVEGAÇÃO ENTRE AS TELAS
            }else{
                JOptionPane.showMessageDialog(view, "Usuario ou senha invalido");  
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(LoginControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
