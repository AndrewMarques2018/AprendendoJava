package mySQL;

import mySQL.db.MySQL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Aplication {

    public static void main(String[] args) {

        Connection connection = MySQL.getConnection();

        String codeSQL = " Insert into seller " +
                " (Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                " values " +
                " (?, ?, ?, ?, ?) ";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date BirthDate = null;
        
        try {
            BirthDate = new Date(sdf.parse("22/04/1985").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        MySQL.InserirDados(codeSQL, "Carl purple 3", "Carl@gmail.com", BirthDate, 3000.0, 4);

        MySQL.closeConnection();

    }
}
