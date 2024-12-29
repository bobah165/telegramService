package ru.otus.bot.telegram.integration.http;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.config.LanguageProperty;
import ru.otus.bot.telegram.config.apiConfig.LocaleConfig;

@Service
@RequiredArgsConstructor
public class LanguageRequestService  {

    private final LanguageProperty languageProperty;
    private final LocaleConfig config;


    public void sendCurrentLanguage(){

    }
}
