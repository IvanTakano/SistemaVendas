/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexaoBD.ConexaoBD;
import Entidade.Data;
import Entidade.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ivanyuratakano
 */
public class VendaDAO {
    
    public static void cadVenda(Venda v) throws ClassNotFoundException, SQLException{
        
        Connection con = ConexaoBD.getConexao();
           
            PreparedStatement ps = null;
        try {
            
            ps = con.prepareStatement("insert into venda (cpf, idVendedor, data, valor) values (?,?,?,?)");

            ps.setString(1, v.getCpf());
            ps.setInt(2, v.getIdVendedor());
            ps.setDate(3, (Date) v.getData());
            ps.setDouble(4, v.getValor());
            
            ps.execute();            
           
        } catch (SQLException e) {
            
        }
    }
    
    //public static List<Venda> getVendas(){
        
       
    //}
    
    public static Venda getVendaById(int id) {

        Venda v = new Venda();

        try {
            String query = "select * from venda where id = ?";
            Connection con = ConexaoBD.getConexao();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                v.setIdVenda(rs.getInt("idvenda"));
                v.setIdVendedor(rs.getInt("vendedor"));
                v.setCpf("cpf");
                v.setValor(rs.getDouble("valor"));
                Data dt = new Data(rs.getString("data"));
                dt.setData();
                v.setData(dt);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
}
