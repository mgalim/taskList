package TaskList.service;

import TaskList.dto.EmployeeDto;
import TaskList.dto.ResponseDto;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeDto> getAllEmployee();

    ResponseDto createEmployee(EmployeeDto employeeDto);

    ResponseDto deleteEmployee(long id);

    ResponseDto updateEmployee(long id, EmployeeDto employeeDto);


}
