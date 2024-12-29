package ru.otus.bot.telegram.handler.userAnswerHandleImpl.settingsMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.config.LanguageProperty;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.integration.http.LanguageRequestService;
import ru.otus.bot.telegram.service.LanguageTranslatorService;
import ru.otus.bot.telegram.utils.SettingMenuFactory;


@Component
@RequiredArgsConstructor
public class ProcessLanguageHandler implements UserAnswerHandler {
    private final LanguageProperty languageProperty;
    private final LanguageTranslatorService translatorService;
    private final SettingMenuFactory settingMenuFactory;
    private final LanguageRequestService languageRequestService;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        settingMenuFactory.getSettingMenuByState(BotState.SETTINGS).processUserAnswer(userId, usersAnswer);
        String data = getData(userId, usersAnswer);
        languageRequestService.sendCurrentLanguage();
        return SendMessage.builder()
                          .chatId(chatId)
                          .text(data)
                          .build();
    }

    @Override
    public BotState getHandlerName() {
        return BotState.PROCESS_LANGUAGE;
    }

    private String getData(long userId, String usersAnswer) {
        switch (usersAnswer) {
            case "russia":
                languageProperty.setLanguage("ru");
                return translatorService.translateMessage("message.language.ru");
            case "english":
                languageProperty.setLanguage("en");
                return translatorService.translateMessage("message.language.en");
            default:
                return "";
        }
    }
}
