package TaskList.exception;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorMessage {

    @NonNull
    private int statusCode;
    @NonNull
    private String message;
}
