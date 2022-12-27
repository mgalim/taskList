package TaskList.controller;

import TaskList.dto.ResponseDto;
import TaskList.dto.TaskDto;
import TaskList.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    ITaskService taskService;

    @GetMapping("/employee/{id}/tasks")
    public ResponseEntity<List<TaskDto>> findAllTaskByEmployeeId(@PathVariable Long id){
        return new ResponseEntity<>(taskService.getAllTasksByEmployeeId(id), HttpStatus.OK);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> findTaskById(@PathVariable Long id){
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @PostMapping("/create/task/employee/{id}")
    public ResponseEntity<ResponseDto> addTask(@PathVariable Long id,@Valid @RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.createTask(id,taskDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/task/{id}")
    public ResponseEntity<ResponseDto> deleteTask(@PathVariable Long id){
        return new ResponseEntity<>(taskService.deleteTask(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/tasks/employee/{id}")
    public ResponseEntity<ResponseDto> deleteAllTasksByEmployeeId(@PathVariable Long id){
        return new ResponseEntity<>(taskService.deleteAllTaskOfEmployee(id),HttpStatus.OK);
    }

    @PutMapping("/update/task/{id}")
    public ResponseEntity<ResponseDto> updateTask(@PathVariable Long id,@Valid @RequestBody TaskDto taskDto){
        return new ResponseEntity<>(taskService.updateTask(id,taskDto), HttpStatus.OK);
    }
}
