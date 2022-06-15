package com.contact.contact.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourseNotFound extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private long fieldValue;
    public ResourseNotFound(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s :%s ",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}





