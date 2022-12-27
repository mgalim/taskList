package TaskList.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class ResponseDto {
    
    @NonNull
    private String message;
}
