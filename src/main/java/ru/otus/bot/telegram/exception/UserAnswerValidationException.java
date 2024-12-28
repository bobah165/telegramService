package ru.otus.bot.telegram.exception;

import lombok.Getter;

@Getter
public class UserAnswerValidationException extends RuntimeException{
    private String chartId;
    private String message;

    public UserAnswerValidationException(String chartId, String message) {
        this.chartId = chartId;
        this.message = message;
    }
}
