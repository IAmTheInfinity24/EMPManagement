package org.infi.EMPManagement.Repo;

import org.infi.EMPManagement.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepoInf extends JpaRepository<Employee,Long> {
}
