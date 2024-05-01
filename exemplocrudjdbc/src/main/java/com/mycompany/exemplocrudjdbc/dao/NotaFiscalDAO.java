/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplocrudjdbc.dao;

import com.mycompany.exemplocrudjdbc.models.NotaFiscal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tfernandes
 */
public class NotaFiscalDAO {
    
    public static String URL = "jdbc:mysql://localhost:3306/basenotafiscal";
    public static String login = "root";
    public static String senha = "P@$$w0rd";
    
    public static boolean salvar(NotaFiscal obj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("INSERT INTO notafiscal (numeroNota,valorNota) VALUES(?,?)");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setInt(1, obj.getNumeroNota());
            comandoSQL.setDouble(2, obj.getValorNota());
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
    
    public static ArrayList<NotaFiscal> listar(){
        
        //Variavel de retorno
        ArrayList<NotaFiscal> lstNotas = new ArrayList<>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM NotaFiscal");
            
            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();

            //Enquanto houver linhas
            while(rs.next()){
                //Para cada linha do rs, crio um objeto e jogo na lista
                int idNota = rs.getInt("idNota");
                int numeroNota = rs.getInt("numeroNota");
                double valorNota = rs.getDouble("valorNota");
                
                NotaFiscal itemNota = new NotaFiscal(idNota, numeroNota, valorNota);
                
                //Adicionar o objeto à lista de retorno
                lstNotas.add(itemNota);
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lstNotas;
    }
    
    public static boolean alterar(NotaFiscal obj){
        boolean retorno = false;
         Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("UPDATE NotaFiscal SET numeroNota = ?, valorNota=? WHERE idNota= ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setInt(1, obj.getNumeroNota());
            comandoSQL.setDouble(2, obj.getValorNota());
            comandoSQL.setInt(3, obj.getIdNota());
            
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return retorno;
        
    }
    
    public static boolean excluir(int idExcluir){
        boolean retorno = false;
         Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("DELETE FROM NotaFiscal WHERE idNota = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setInt(1, idExcluir);
            
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return retorno;
        
    }
}//Fim da classe
