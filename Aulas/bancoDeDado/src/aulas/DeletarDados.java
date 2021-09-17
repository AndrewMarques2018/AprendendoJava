package aulas;

import aulas.db.DB;
import aulas.db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarDados {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConection();
            st = conn.prepareStatement(
                    "delete from department "+
                            "where "+
                            "Id = ?"
            );

            st.setInt(1, 6);

            int rowsAffected = st.executeUpdate();
            System.out.println("rowsAffected : " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }finally {
            DB.closeStetment(st);
            DB.closeConnection();
        }
    }
}
