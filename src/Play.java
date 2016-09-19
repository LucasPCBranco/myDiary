import static javax.swing.JOptionPane.*;

public class Play {

    //Feito por Lucas Pereira Castelo Branco - 3° ID
    BancoDados mt = new BancoDados();
    public static Login l = new Login();
    public static void main(String[] args) {
        BancoDados.conectar();
        Cadastro c = new Cadastro();
        
        
        Object[] opt = {"Login", "Cadastrar"};
        
        int a = showOptionDialog(null, "Selecione", "Diário", YES_NO_OPTION, 
                QUESTION_MESSAGE, null, opt, opt[0]);
        
        //Validar login
        if(a == YES_OPTION){
            l.setVisible(true);
        }if(a == NO_OPTION){
            //Cadastro
            c.setVisible(true);
        }

        //sql = conexao.createStatement();
        //String query = "SELECT * FROM ";//champ
        //resultado = sql.executeQuery(query);
        //while(resultado.next()){
        //    msg = msg + "Id: " + resultado.getInt("id_champ") +
        //            "\n" + "Nome: " + resultado.getString("nome_champ") + "\n"  ;      
        //}
        // showMessageDialog(null, msg);
        // conexao.close();
    }

}
