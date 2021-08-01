/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.ConexaoBD;
import Entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanyuratakano
 */
public class UsuarioDAO {
    public static void cadUsuario(Usuario u){
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "insert into usuario(nome, cpf, telefone, funcao) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, u.getNome());
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getTelefone());
            ps.setString(4, u.getFuncao());
            
            
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
    public static Usuario getUsuario(int idUsuario){
        Usuario u = new Usuario();
        
        try {
            String query = "select * from usuario where idusuario = " + idUsuario;
            Connection con = ConexaoBD.getConexao();

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setTelefone(rs.getString("telefone"));
                u.setFuncao(rs.getString("funcao"));
                
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return u;
    }
    
    public static void updadeUsuario(Usuario u){
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "update usuario set nome = ?, cpf = ?, telefone = ?, funcao = ? where idusuario = ?";
            PreparedStatement ps = con.prepareStatement(query);            
            
            ps.setString(1, u.getNome());    
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getTelefone());
            ps.setString(4, u.getFuncao());
            ps.setInt(5, u.getIdUsuario());
            
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no BD!");
        }
    }
    
     public static void deletarUsuario(int idUsuario){
        try {
            
            Connection con = ConexaoBD.getConexao();
            String query = "";
            
           
            query = "delete from usuario where id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idUsuario);
            ps.execute();

        
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
