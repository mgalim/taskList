package TaskList.dto;

import TaskList.entity.Employee;
import TaskList.utils.EnumValidator;
import TaskList.entity.StateType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TaskDto  {

    private long id;

    @NotBlank(message = "The description must have at least one character.")
    private String description;

    @EnumValidator(enumClass = StateType.class, message = "The stateType '${validatedValue}' is not valid. Please put one of this: COMPLETED, PENDING, SUSPENDED")
    private String stateType;

    @JsonIgnore
    private Employee employee;

}
