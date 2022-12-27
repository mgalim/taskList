package TaskList;

import TaskList.dto.EmployeeDto;
import TaskList.dto.ResponseDto;
import TaskList.service.IEmployeeService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeApplicationTest {

    @Autowired
    IEmployeeService employeeService;

    @Test
    @Order(1)
    void getAllEmployeeTestOk(){
        EmployeeDto employeeDto1 = new EmployeeDto(1,"Marcelo",45);
        EmployeeDto employeeDto2 = new EmployeeDto(2,"Carlos",34);
        List<EmployeeDto> employeesExpected = Arrays.asList(employeeDto1,employeeDto2);

        List<EmployeeDto> employeesReal = employeeService.getAllEmployee();

        Assertions.assertEquals(employeesExpected,employeesReal);
    }

    @Test
    @Order(2)
    void createEmployeeTestOk(){
        EmployeeDto employeeDto = new EmployeeDto("Pepe",22);
        ResponseDto responseDtoExpected = new ResponseDto("The employee was created successfully.");

        ResponseDto responseDtoReal = employeeService.createEmployee(employeeDto);

        Assertions.assertEquals(responseDtoExpected,responseDtoReal);
    }

    @Test
    @Order(3)
    void deleteEmployeeTestOk(){
        ResponseDto responseDtoExpected = new ResponseDto("The employee was successfully deleted along with their tasks.");

        ResponseDto responseDtoReal = employeeService.deleteEmployee(3);

        Assertions.assertEquals(responseDtoExpected,responseDtoReal);
    }

    @Test
    @Order(4)
    void updateEmployeeTestOk() {
        EmployeeDto employeeDto = new EmployeeDto("Martin", 38);
        ResponseDto responseDtoExpected = new ResponseDto("The employee was updated successfully.");

        ResponseDto responseDtoReal = employeeService.updateEmployee(1, employeeDto);

        Assertions.assertEquals(responseDtoExpected, responseDtoReal);
    }
}
