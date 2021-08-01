/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.ConexaoBD;
import Entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanyuratakano
 */
public class ClienteDAO {
    public static void cadCliente(Cliente c){
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "insert into cliente(nome, cpf, telefone, endereco, numero, complemento, cidade, estado) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getEnd());
            ps.setInt(5, c.getNumero());
            ps.setString(6, c.getComplemento());
            ps.setString(7, c.getCidade());
            ps.setString(8, c.getEstado());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no BD!");
        }
    }
    
    public static Cliente getCliente(String cpf){
        Cliente c = new Cliente();
        
        try {
            String query = "select * from cliente where cpf like '%" + cpf + "%'";

            Connection con = ConexaoBD.getConexao();

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEnd(rs.getString("endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setComplemento(rs.getString("complemento"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return c;
    }
    
    public static Cliente getClienteNome(String nome){
        Cliente c = new Cliente();
        
        try {
            String query = "select * from cliente where nome like '%" + nome + "%'";

            Connection con = ConexaoBD.getConexao();

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){                
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEnd(rs.getString("endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setComplemento(rs.getString("complemento"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return c;
    }
    
    public static void updadeCliente(Cliente c){
        try {
            Connection con = ConexaoBD.getConexao();

            String query = "update cliente set nome = ?, telefone = ?, endereco = ?, numero = ?,"
                    + "complemento = ?, cidade = ?, estado = ?  where cpf = ?";

            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, c.getNome());            
            ps.setString(2, c.getTelefone());
            ps.setString(3, c.getEnd());
            ps.setInt(4, c.getNumero());
            ps.setString(5, c.getComplemento());
            ps.setString(6, c.getCidade());
            ps.setString(7, c.getEstado());
            ps.setString(8, c.getCpf());            
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no BD!");
        }
    }
    
     public static void deletarCliente(String cpf){
        try {
            
            Connection con = ConexaoBD.getConexao();
            String query = "";
            
           
            query = "delete from cliente where cpf = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.execute();

        
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
