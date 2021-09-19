package aulas;

import aulas.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResgatarDados {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM coursejdbc.department;");

            while (rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

            DB.closeResultSet(rs);
            DB.closeStetment(st);
            DB.closeConnection();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }
}

