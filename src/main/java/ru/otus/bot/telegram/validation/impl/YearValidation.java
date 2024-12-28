package ru.otus.bot.telegram.validation.impl;

import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.exception.UserAnswerValidationException;
import ru.otus.bot.telegram.service.LanguageTranslatorService;
import ru.otus.bot.telegram.validation.UserAnswerValidator;


@Component
@RequiredArgsConstructor
public class YearValidation implements UserAnswerValidator {
    private final LanguageTranslatorService translator;

    @Override
    public void validateUserAnswer(String usersAnswer, String chatId) {
        final Pattern pattern = Pattern.compile("^\\d{4}?");
        if (!pattern.matcher(usersAnswer).matches()) {
            throw new UserAnswerValidationException(chatId, translator.translateMessage("year.wrong.format"));
        }
    }

    @Override
    public BotState getValidatorState() {
        return BotState.YEAR;
    }
}
