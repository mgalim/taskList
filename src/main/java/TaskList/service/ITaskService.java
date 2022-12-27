package TaskList.service;

import TaskList.dto.TaskDto;
import TaskList.dto.ResponseDto;

import java.util.List;

public interface ITaskService {

    List<TaskDto> getAllTasksByEmployeeId(long id);

    TaskDto getTaskById(long id);

    ResponseDto createTask(long id,TaskDto taskDto);

    ResponseDto deleteTask(long id);

    ResponseDto deleteAllTaskOfEmployee(long id);

    ResponseDto updateTask(long id,TaskDto taskDto);
}
