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
public class ModelValidator implements UserAnswerValidator {
    private final LanguageTranslatorService translator;

    @Override
    public void validateUserAnswer(String usersAnswer, String chatId) {
        final Pattern pattern = Pattern.compile("\\w+");
        if (!pattern.matcher(usersAnswer).matches()) {
            throw new UserAnswerValidationException(chatId, translator.translateMessage("model.wrong.format"));
        }
    }

    @Override
    public BotState getValidatorState() {
        return BotState.MODEL;
    }
}
