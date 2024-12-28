package ru.otus.bot.telegram.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.validation.UserAnswerValidator;


@Component
@RequiredArgsConstructor
public class UserAnswerValidatorFactory {
    private final List<UserAnswerValidator> userAnswerValidators;

    public UserAnswerValidator getUserAnswerValidator(BotState botState) {
        return userAnswerValidators.stream()
                                   .collect(Collectors.toMap(UserAnswerValidator::getValidatorState, Function.identity()))
                                   .get(botState);
    }
}
