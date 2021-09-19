package mySQL.db;

import aulas.InserirDados;
import aulas.db.DB;
import aulas.db.DbException;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class MySQL {

    private static Connection connection = null;

    public static Connection getConnection (){

        if (connection == null) {

            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                connection = DriverManager.getConnection(url, props);

            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }

    private static Properties loadProperties() {

        try (FileInputStream fs = new FileInputStream("src//mySQL//db//db.properties")){

            Properties props = new Properties();
            props.load(fs);
            return props;

        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection() {

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static String resgatarDados (String codeSQL, String... columnLabels ){

        StringBuilder sb = new StringBuilder();

        Statement st = null;
        ResultSet rs = null;

        try {

            st = connection.createStatement();
            rs = st.executeQuery(codeSQL);

            while (rs.next()){
                for (String columnLabel : columnLabels) {
                    sb.append(columnLabel).append(":").append(rs.getObject(columnLabel)).append(',');
                }
                sb.delete(sb.length()-1, sb.length());
                sb.append("\n");
            }

        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            DB.closeResultSet(rs);
            DB.closeStetment(st);
        }

        return sb.toString();
    }

    public static void InserirDados ( String codeSQL, Object... values ){

        PreparedStatement ps = null;

        try {

            ps =connection.prepareStatement(codeSQL);

            for (int i = 1; i<values.length-1; i++) {
                Object value = values[i-1];
                if(value instanceof Integer) ps.setInt(i, (Integer) value);
                if(value instanceof Double) ps.setDouble(i, (Double) value);
                if(value instanceof String) ps.setString(i, (String) value);

            }

            ps.executeUpdate();

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

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DB.closeStetment(ps);
        }
    }
}
