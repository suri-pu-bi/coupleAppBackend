package coupleApp.coupleApp.data.dto.response;

import lombok.Data;

@Data
public class ResponseDTO<T> {

    private Boolean isSuccess;
    private String message;
    private T result;

    public ResponseDTO(boolean isSuccess, String message, T result) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.result = result;
    }
}
