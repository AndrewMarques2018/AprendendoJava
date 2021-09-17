package aulas;

import aulas.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarDados {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try{

            conn = DB.getConection();

            st = conn.prepareStatement(
              "update seller " +
              "set BaseSalary = BaseSalary + ? " +
              "where " +
              "(DepartmentId = ?)"
            );

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsEfect = st.executeUpdate();
            System.out.println("rows efected " + rowsEfect);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DB.closeStetment(st);
            DB.closeConnection();
        }

    }
}
