/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import javax.xml.crypto.Data;

/**
 *
 * @author ivanyuratakano
 */
public class Venda {
    
    private int idVenda;
    private String cpf;
    private int idVendedor;
    private Data data;
    private double valor;

    public Venda() {
    }

    public Venda(int idVenda, String cpf, int idVendedor, Data data, double valor) {
        this.idVenda = idVenda;
        this.cpf = cpf;
        this.idVendedor = idVendedor;
        this.data = data;
        this.valor = valor;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Venda{" + "idVenda=" + idVenda + ", cpf=" + cpf + ", idVendedor=" + idVendedor + ", data=" + data + ", valor=" + valor + '}';
    }

    public void setData(Entidade.Data dt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
