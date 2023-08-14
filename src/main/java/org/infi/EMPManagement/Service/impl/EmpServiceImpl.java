package org.infi.EMPManagement.Service.impl;

import org.infi.EMPManagement.Entities.Employee;
import org.infi.EMPManagement.Exception.ResourceNotFoundException;
import org.infi.EMPManagement.Repo.EmpRepoInf;
import org.infi.EMPManagement.Service.EmpServceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpServceInf {

    @Autowired
    private EmpRepoInf empRepoInf;

    @Override
    public Employee addEmployee(Employee emp) {
        return empRepoInf.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        this.empRepoInf.findById(emp.getEId())
                .orElseThrow(() -> new ResourceNotFoundException("Emp not found with id : "+ emp.getEId()));
        return this.empRepoInf.save(emp);
    }

    @Override
    public Employee getEmployee(Long eid) {
        Employee employee = this.empRepoInf.findById(eid).orElseThrow(() -> new ResourceNotFoundException("Emp not found with id : ",eid));
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = this.empRepoInf.findAll();
        return employees;
    }

    @Override
    public void deleteEmployee(long id) {
        this.empRepoInf.findById(id).orElseThrow(() -> new ResourceNotFoundException("Emp not found with id : "+id));
        this.empRepoInf.deleteById(id);
    }
}
