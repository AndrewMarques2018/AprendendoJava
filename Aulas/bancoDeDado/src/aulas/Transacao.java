package aulas;

import aulas.db.DB;
import aulas.db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transacao {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConection();

            conn.setAutoCommit(false); // nao salvar atualizaçoes sem permisao

            st = conn.createStatement();

            int rows1 = st.executeUpdate("update seller set BaseSalary = 2090 where DepartmentId = 1");

            // forçar um erro fake
            int x = 1;
            if (x < 2) {
                throw new SQLException("Fake error");
            }

            int rows2 = st.executeUpdate("update seller set BaseSalary = 3090 where DepartmentId = 2");

            conn.commit(); // permisao

            System.out.println("rows1: " + rows1 + '\n' + "rows2: " + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! caused by: " + e.getMessage());

            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! caused by: " + e1.getMessage());
            }

        } finally {
            DB.closeStetment(st);
            DB.closeConnection();
        }
    }
}

