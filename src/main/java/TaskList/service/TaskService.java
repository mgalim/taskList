package TaskList.service;

import TaskList.entity.Task;
import TaskList.exception.ResourceNotFoundException;
import TaskList.dto.ResponseDto;
import TaskList.dto.TaskDto;
import TaskList.entity.Employee;
import TaskList.entity.StateType;
import TaskList.repository.IEmployeeRepository;
import TaskList.repository.ITaskRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService implements ITaskService {

    @Autowired
    ITaskRespository taskRespository;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<TaskDto> getAllTasksByEmployeeId(long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found employee with id: " + id);
        }
        if (taskRespository.findByEmployeeId(id).isEmpty()) {
            throw new ResourceNotFoundException("No content found.");
        }
        return taskRespository.findByEmployeeId(id)
                .stream()
                .map(task -> mapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskById(long id) {
        Task task = taskRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found task with id: " + id));
        return mapper.map(task, TaskDto.class);
    }

    @Override
    public ResponseDto createTask(long id, TaskDto taskDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found employee with id: " + id));
        taskDto.setEmployee(employee);
        taskRespository.save(mapper.map(taskDto, Task.class));
        return new ResponseDto("The task was created successfully.");

    }

    @Override
    public ResponseDto deleteTask(long id) {
        if (!taskRespository.existsById(id)) {
            throw new ResourceNotFoundException("Not found task with id: " + id);
        }
        taskRespository.deleteById(id);
        return new ResponseDto("The task was successfully deleted.");
    }

    @Override
    public ResponseDto deleteAllTaskOfEmployee(long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found employee with id: " + id);
        }
        taskRespository.deleteByEmployeeId(id);
        return new ResponseDto("All tasks were successfully deleted.");
    }

    @Override
    public ResponseDto updateTask(long id, TaskDto taskDto) {
        Task task = taskRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found task with id: " + id));
        task.setDescription(taskDto.getDescription());
        task.setStateType(StateType.valueOf(taskDto.getStateType()));
        taskRespository.save(task);
        return new ResponseDto("The task was updated successfully.");
    }
}
