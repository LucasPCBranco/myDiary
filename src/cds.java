import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC-LAB8
 */
public class cds extends BancoDados { //Ver a funcionalidade e validade da Herança

    /* Atributos baseados nos campos de DB*/
    public int id;
    public String titel;
    public String interpret;
    public int jahr;


    /*Como temos na classe 4 atributos ligados ao CD, logo temos que usá-los de alguma forma
     Assim, temos a opção de usarmos como parâmetro*/
    public void select() {
        if (id != 0) {
            try {
                Statement x = BancoDados.con.createStatement();
                x.executeQuery("SELECT * FROM cds WHERE id = " + id + ";");
            } catch (SQLException e) {
                System.out.println("ERRO\n" + e);
            }
        } else {
            try {
                Statement x = con.createStatement();
                x.executeQuery("SELECT * FROM cds WHERE id = " + id + ";");

                Statement d = con.createStatement();
                ResultSet r = d.executeQuery("SELECT id FROM cds WHERE titel = '" + titel + "';");
                while (r.next()) {
                    id = r.getInt("id");
                    System.out.println("ID: " + id);
                }
            } catch (SQLException e) {
                System.out.println("ERRO\n" + e);
            }
        }
    }

    public void insert() { //ORDEM: titel, interpret, jahr
        try {
            Statement st = con.createStatement();
            st.execute("INSERT INTO cds(titel, interpret, jahr) VALUES('" + titel + "', '" + interpret + "', " + jahr + ");");
        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
        }
    }

    public void update() {
        try{
        Statement st = con.createStatement();
        st.execute("UPDATE cds SET titel = '" + titel + "', interpret = '" + interpret + "', jahr=" + jahr + "WHERE id = " + id);
    }catch(SQLException e){
        System.out.println("ERRO\n" + e);
    }
    }
    
    public void delete(){
        try{
            Statement st = con.createStatement();
            st.execute("DELETE FROM cds WHERE id=" + id);
        }catch(SQLException e){
            System.out.println("ERRO\n" + e);
        }
    }
}
