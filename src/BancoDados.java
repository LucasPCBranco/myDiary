import java.sql.*;
import java.util.logging.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lucas "xRocket" Pereira - 3° ID
 */
public class BancoDados {
    public static Connection con;

    public static Connection conectar() {
        Connection conexao = null;
        boolean status = false;
        String msg = "";

        try {
            String nomeDriver = "com.mysql.jdbc.Driver";
            Class.forName(nomeDriver);

            String servidor = "localhost",
                    bd = "mydb", //Mudar nome do Banco de Dados
                    url = "jdbc:mysql://" + servidor + "/" + bd,
                    usuario = "root",
                    senha = "";

            con = DriverManager.getConnection(url, usuario, senha);

            if (con != null) {
                status = true;
            }
            //Confirma (ou não) a conexão
            System.out.println("Status Conexão: " + status);
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar!\n" + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;

    }

    public static String selectAll(String tab){
        String msg = "";
        try{
            Statement ps = con.createStatement();
            ResultSet s = ps.executeQuery("SELECT * FROM " + tab);
            ResultSetMetaData r = s.getMetaData();
            while(s.next()){
                for (int i = 1; i < r.getColumnCount(); i++) { //Pega o número de colunas
                    msg += s.getString(i) + "\n";
                }
            }
            return msg;
        }catch(SQLException e){
            return "ERRO\n" + e;
        }
    }
    
    public static String select(String campo, String tb, String param) {
        String msg = "";
        String query = "SELECT " + campo + " FROM " + tb + " " + param;
        System.out.println(query);
        try {
            Statement sql = con.createStatement();
            ResultSet resultado = sql.executeQuery(query);
            while (resultado.next()) {
                msg = resultado.getString(campo);
            }
            return msg;
        } catch (SQLException e) {
            return "ERROR\n" + e;
        }
    }

    public static void insert(String t, String col, String val) {
        try {
            Statement sql = con.createStatement();
            String query = "INSERT INTO " + t + "(" + col + ")VALUES(" + val + ")";
            System.out.println(query);
            sql.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("ERROR\n" + e);
        }
    }
    /* tab = tabela; ref = referência; n = valor referência; col = coluna a ser modificada*/
    public static void update(String tab, String ref, String n, String col) {
        try {
            Statement sql = con.createStatement();
            String query = "UPDATE " + tab + " SET " + col + " WHERE " + ref + " = " + "'" + n + "';";

            sql.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("ERROR\n" + e);

        }
    }

    public static void delete(String t, String param) {
        try {
            Statement sql = con.createStatement();
            String query = "DELETE FROM " + t + " WHERE " + param;
            System.out.println(query);
            sql.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("ERROR\n" + e);
        }
    }

    public static void encerrar(Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
    }
}
