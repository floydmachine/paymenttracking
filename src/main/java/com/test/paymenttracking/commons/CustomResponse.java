package com.test.paymenttracking.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse<T> {

    private boolean success;

    private T data;

    private String error;

    private HttpStatus status;

    public CustomResponse(T data, HttpStatus status) {
        if (status.isError()) {
            this.success = false;
            if (data instanceof Exception) {
                Exception exception = (Exception) data;
                this.error = exception.getMessage();
            } else {
                this.error = data.toString();
            }
            this.data = (T) "Error Occurred";
        } else {
            this.success = true;
            this.data = data;
        }
        this.status = status;
    }
}
