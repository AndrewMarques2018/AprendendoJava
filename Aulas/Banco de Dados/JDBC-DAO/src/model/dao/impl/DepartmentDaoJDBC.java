package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "insert into department " +
                            "(Name) " +
                            "values " +
                            "(?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, department.getName());

            int rowsEfected = st.executeUpdate();

            if (rowsEfected > 0){
                ResultSet rs = st.getGeneratedKeys();

                if (rs.next()){
                    int id = rs.getInt(1);
                    department.setId(id);
                }
                DB.closeResultSet(rs);

            }else{
                throw new DbException("Erro inesperado! nenhuma linha afetada!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }finally {
            DB.closeStetment(st);
        }
    }

    @Override
    public void update(Department department) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "update department " +
                            "set Name = ? " +
                            "where Id = ?",Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, department.getName());
            st.setInt(2, department.getId());

            int rowsEfected = st.executeUpdate();
            System.out.println("Update rows efected: " + rowsEfected);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }finally {
            DB.closeStetment(st);
        }
    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "delete from department where Id = ?"
            );

            st.setInt(1, id);

            int rowsEfected = st.executeUpdate();
            System.out.println("rows efected: " + rowsEfected);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }finally {
            DB.closeStetment(st);
        }
    }

    @Override
    public Department findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                    "select * from department " +
                            "where Id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();

            if(rs.next()){

                return new Department(rs.getInt("Id"), rs.getString("Name"));

            }else {
                return null;
            }


        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }finally {
            DB.closeStetment(st);
            DB.closeResultSet(rs);
        }

    }

    @Override
    public List<Department> findAll() {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                    "select * from department"
            );

            rs = st.executeQuery();

            List<Department> departmentList = new ArrayList<>();

            while (rs.next()){
                departmentList.add(new Department(rs.getInt("Id"), rs.getString("Name")));
            }

            return departmentList;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        }finally {
            DB.closeStetment(st);
            DB.closeResultSet(rs);
        }
    }

}
