package aulas;

import aulas.db.DB;

import java.sql.*;

public class InserirDados {

    public static void main(String[] args) {


        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConection();

            /*
            ps =conn.prepareStatement(
                    " Insert into seller " +
                            " (Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                            " values " +
                            " (?, ?, ?, ?, ?) ",
                            Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            ps.setString(1, "Carl purple 2");
            ps.setString(2, "Carl@gmail.com");
            ps.setDate(3, new Date(sdf.parse("22/04/1985").getTime()));
            ps.setDouble(4, 3000);
            ps.setInt(5, 4);

            ps.executeUpdate();
             */

            ps = conn.prepareStatement(
                    "insert into department (Name) values ('D1'),('D2')",
                    Statement.RETURN_GENERATED_KEYS
            );

            int rowsEfected = ps.executeUpdate();

            if(rowsEfected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("id : " + id);
                }
            }else{
                System.out.println("no rows efected");
            }

        } catch (SQLException ignored) {

        }
        finally {
            DB.closeStetment(ps);
            DB.closeConnection();
        }

    }
}
