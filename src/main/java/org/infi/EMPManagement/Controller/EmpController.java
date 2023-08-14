package org.infi.EMPManagement.Controller;

import org.infi.EMPManagement.Entities.Employee;
import org.infi.EMPManagement.Service.impl.EmpServiceImpl;
import org.infi.EMPManagement.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("apis/employees")
public class EmpController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmpServiceImpl empServiceImpl;

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        this.empServiceImpl.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added SuccessFully!...");
    }

    @PutMapping("/")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return new ResponseEntity<>(modelMapper.map(this.empServiceImpl.updateEmployee(employee), EmployeeDto.class), HttpStatus.OK);
    }

    @GetMapping("/{eId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long eId) {
        Employee employee = this.empServiceImpl.getEmployee(eId);
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<Employee> employees = this.empServiceImpl.getEmployees();
        List<EmployeeDto> dtos = employees.stream().map(emp -> {
            return modelMapper.map(emp, EmployeeDto.class);
        }).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping("/{eId}")
    public ResponseEntity<String> delete(@PathVariable Long eId) {
        this.empServiceImpl.deleteEmployee(eId);
        return ResponseEntity.ok().body("Employee deleted Successfully : " + eId);
    }
}
