package TaskList.controller;

import TaskList.dto.EmployeeDto;
import TaskList.dto.ResponseDto;
import TaskList.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> findAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @PostMapping("/create/employee")
    public ResponseEntity<ResponseDto> addEmployees(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity<ResponseDto> deleteEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }

    @PutMapping("/update/employee/{id}")
    public ResponseEntity<ResponseDto> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.updateEmployee(id,employeeDto), HttpStatus.ACCEPTED);
    }
}
