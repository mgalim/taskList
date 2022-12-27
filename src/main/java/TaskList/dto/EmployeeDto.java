package TaskList.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private long id;

    @NotBlank(message = "the name must have at least one character.")
    private String name;

    @NotNull
    @Max(value = 120, message = "the age '${validatedValue}' is greater than {value}, which is the maximum.")
    private Integer age;

    public EmployeeDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
