package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Progam {

    public static void main(String[] args) {

        DepartmentDao departmentDao= DaoFactory.createDepartmentDao();

        //System.out.println(departmentDao.findAll());

        //System.out.println(departmentDao.findById(1));

        //departmentDao.insert(new Department(null, "D12"));

        //departmentDao.deleteById(12);

        System.out.println(departmentDao.findById(13));

        Department d13 = departmentDao.findById(13);
        d13.setName("Department D13");
        departmentDao.update(d13);

        System.out.println(departmentDao.findById(13));

    }
}
