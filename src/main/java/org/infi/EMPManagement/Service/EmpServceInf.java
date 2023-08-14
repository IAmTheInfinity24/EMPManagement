package org.infi.EMPManagement.Service;

import org.infi.EMPManagement.Entities.Employee;

import java.util.List;

public interface EmpServceInf {

    Employee addEmployee(Employee emp);

    Employee updateEmployee(Employee emp);

    Employee getEmployee(Long eid);

    List<Employee> getEmployees();

    void deleteEmployee(long id);
}
