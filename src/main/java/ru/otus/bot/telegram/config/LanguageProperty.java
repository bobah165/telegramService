package ru.otus.bot.telegram.config;


import java.util.Locale;
import org.springframework.stereotype.Component;

@Component
public class LanguageProperty {
    private String language = "ru";

    public String getCurrentLanguage() {
        return new Locale(language,language.toUpperCase()).getLanguage();
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
