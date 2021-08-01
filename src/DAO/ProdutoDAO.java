/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.ConexaoBD;
import Entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanyuratakano
 */
public class ProdutoDAO {
    
    public static void cadProduto(Produto p) throws ClassNotFoundException, SQLException{
            Connection con = ConexaoBD.getConexao();
           
            PreparedStatement ps = null;
        try {
            
            ps = con.prepareStatement("insert into produto (nome, quantidade, valor) values (?,?,?)");

            ps.setString(1, p.getNome());
            ps.setInt(2, p.getQuantidade());
            ps.setDouble(3, p.getValor());
            
            ps.execute();            
           
        } catch (SQLException e) {
            
        }
    }
    
    public static List<Produto> getProdutos(){
        
        List<Produto> produtos = new ArrayList();
        int id = 0;
        Produto p = new Produto();
        String nome = "";
        int quantidade = 0;
        double valor = 0;
        
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from produto";            
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                id = rs.getInt("id");
                nome = rs.getString("nome");
                quantidade = rs.getInt("quantidade");
                valor = rs.getDouble("valor");
                produtos.add(new Produto(id, nome, quantidade, valor));
            }           
            
        } catch (ClassNotFoundException | SQLException e) {
        }
        return produtos;
    }
    
    public static Produto getProdutoid (int id){
        
        Produto p = new Produto();
        String nome = "";
        int quantidade = 0;
        double valor = 0;
        
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from produto where id = " + id;            
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id");
                nome = rs.getString("nome");
                quantidade = rs.getInt("quantidade");
                valor = rs.getDouble("valor");
                p = new Produto(id, nome, quantidade, valor);
            }           
            
        } catch (ClassNotFoundException | SQLException e) {
        }
        return p;
    }
    
    public static Produto getProdutoNome (String pesquisa){
        
        int id =0;
        Produto p = new Produto();
        String nome = "";
        int quantidade = 0;
        double valor = 0;
        
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "select * from produto where nome like '%" + pesquisa + "%'";            
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                id = rs.getInt("id");
                nome = rs.getString("nome");
                quantidade = rs.getInt("quantidade");
                valor = rs.getDouble("valor");
                p = new Produto(id, nome, quantidade, valor);
            }           
            
        } catch (ClassNotFoundException | SQLException e) {
        }
        return p;
    }
    
    public static void updateProduto(Produto p){
        try {
            Connection con = ConexaoBD.getConexao();
            String query = "update produto set nome = ?, quantidade = ?, valor = ? where id = ?";            
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getQuantidade());
            ps.setDouble(3, p.getValor());
            ps.setInt(4, p.getId());
            
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public static void deletarProduto(int id){
        try {
            
            Connection con = ConexaoBD.getConexao();
            String query = "";            
           
            query = "delete from produto where id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
