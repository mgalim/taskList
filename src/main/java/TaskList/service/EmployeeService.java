package TaskList.service;

import TaskList.dto.EmployeeDto;
import TaskList.dto.ResponseDto;
import TaskList.entity.Employee;
import TaskList.exception.ResourceNotFoundException;
import TaskList.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("No content found.");
        }
        return employees
                .stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDto createEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(mapper.map(employeeDto, Employee.class));
        return new ResponseDto("The employee was created successfully.");
    }

    @Override
    public ResponseDto deleteEmployee(long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found employee with id: " + id);
        }
        employeeRepository.deleteById(id);
        return new ResponseDto("The employee was successfully deleted along with their tasks.");
    }

    @Override
    public ResponseDto updateEmployee(long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found employee with id: " + id));
        employee.setAge(employeeDto.getAge());
        employee.setName(employeeDto.getName());
        employeeRepository.save(employee);
        return new ResponseDto("The employee was updated successfully.");
    }

}
