package com.nhnacademy.projectbulk.rest;

import java.util.Map;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * 예외 발생시 반환할 엔티티
 *
 * @author 김민수
 * @since 1.0
 */
public class ExceptionEntity extends HalObject<Map<String, Object>> {
    private Integer errorState;

    public ExceptionEntity(Integer errorState) {
        this.errorState = errorState;
    }

    private void setExceptionMessage(RuntimeException exception) {
        super.setResource(
            Map.of("message", ExceptionUtils.getMessage(exception),
                "status", errorState));
    }
}

