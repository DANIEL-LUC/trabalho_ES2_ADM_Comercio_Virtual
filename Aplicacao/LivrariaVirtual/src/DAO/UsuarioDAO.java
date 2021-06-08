/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpringLayout;
import model.Usuario;
import view.FormCadastroView;

/**
 *
 * @author cliente
 */
public class UsuarioDAO {
 
    
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    
    public Usuario insert(Usuario usuario) throws SQLException{
       //==== FORMA ERRADA DE INSERÇÃO, POIS DEIXA O SISTEMA VULNERAVEL   
       // String sql = "insert into usuario(usuario,senha) values('"+usuario.getUsuario()+"','"+usuario.getSenha()+"');" ;
       
        String sql = "insert into usuario(usuario,senha) values(?,?);";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        
        //VERIFICA SE EXISTE ALGUMA STRING MALICIOSA
        statement.setString(1, usuario.getUsuario()); // INSERE O USUARIO NO PRIMEIRO ' ? '
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        
        // connection.close(); NÃO FECHE CONEXÃO AQUI !!!!
      
        
        
       // int id = resultSet.getInt("Id");
        //System.out.println(id);
        
         ResultSet resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            
            int id = resultSet.getInt("Id");
            usuario.setId(id);
        }
        return usuario;
        

    }

    public void upDate(Usuario usuario) throws SQLException{
        String sql = "update usuario set usuario = ?, senha = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        
        //VERIFICA SE EXISTE ALGUMA STRING MALICIOSA
        statement.setString(1, usuario.getUsuario()); // INSERE O USUARIO NO PRIMEIRO ' ? '
        statement.setString(2, usuario.getSenha());
        statement.setInt(3, usuario.getId());
        
        statement.execute();
    }

    public void insertOrUpdate(Usuario usuario) throws SQLException{
        if(usuario.getId() > 0 ){
            upDate(usuario);
        }else insert(usuario);
    }
    
    public void delete (Usuario usuario) throws SQLException{
         String sql = "delete from usuario where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
      
        statement.setString(1, usuario.getUsuario()); 
        statement.execute();
    }
    
    public ArrayList<Usuario> selectAll() throws SQLException{
        String sql = "select * from usuario";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisar(statement);
    }
 
    private ArrayList<Usuario> pesquisar(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> listaUsuario = new ArrayList();
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("Id");
            String nomeUsuario = resultSet.getString("usuario");
            String senhaUsuario = resultSet.getString("senha");
            
            Usuario usuarioAux = new Usuario(id, nomeUsuario, senhaUsuario);
            
            listaUsuario.add(usuarioAux);
        }
        return listaUsuario;
    }
    
    
    public Usuario selectPorId(Usuario usuario) throws SQLException{
        String sql = "select * from usuario where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId()); 
        statement.execute();
      
        //ArrayList<Usuario> usuarios = pesquisar(statement);
        //return usuarios.get(0);
        
        return pesquisar(statement).get(0);
        
        
    }
    
    public boolean existeUsuarioESenha(Usuario usuario) throws SQLException {
        //==== FORMA ERRADA DE INSERÇÃO, POIS DEIXA O SISTEMA VULNERAVEL
       // String sql = "select * from usuario where usuario = '"+ usuario.getUsuario()+"'and senha = '"+usuario.getSenha()+"'";
       
       
        String sql = "select * from usuario where usuario = ? and senha = ? ";
       
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //VERIFICA SE EXISTE ALGUMA STRING MALICIOSA
        statement.setString(1, usuario.getUsuario()); // INSERE O USUARIO NO PRIMEIRO ' ? '
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet(); // RETORNA TREU SE USUARIO EXISTIR
        
        return resultSet.next();
        }
        
    
}
