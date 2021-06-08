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
import view.FormCadastroView;

/**
 *
 * @author cliente
 */
public class FormCadastroControle {
    
    private FormCadastroView view; // TUDO DENTRO DO FORMULARIO PODERÁ SEDR USADO NO CONTROLE

    public FormCadastroControle(FormCadastroView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
         
        
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        Usuario usuarioX = new Usuario(usuario, senha);
        
     
      // ++++ TENTA REALIZAR UMA CONEXÃO UTILIZANDO O DAO +++++++++
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.insert(usuarioX);
            
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso !!!!");
            // +++ O try{} FECHA A CONEXÃO SOZINHO
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
