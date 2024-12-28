package ru.otus.bot.telegram.service;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.config.LanguageProperty;

@Service
@RequiredArgsConstructor
public class LanguageTranslatorService {

    private final MessageSource messageSource;
    private final LanguageProperty languageProperty;

    public String translateMessage(String message) {
        Locale locale = new Locale(languageProperty.getCurrentLanguage(), languageProperty.getCurrentLanguage().toUpperCase());
        return messageSource.getMessage(message, new Object[0], locale);
    }
}
