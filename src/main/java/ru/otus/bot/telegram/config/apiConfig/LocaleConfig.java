package ru.otus.bot.telegram.config.apiConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class LocaleConfig {
    @Value("${bot.api.subPath.local}")
    private String localSubPath;
}
