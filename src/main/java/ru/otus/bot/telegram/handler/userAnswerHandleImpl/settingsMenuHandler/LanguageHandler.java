package ru.otus.bot.telegram.handler.userAnswerHandleImpl.settingsMenuHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.otus.bot.telegram.builder.MessageBuilder;
import ru.otus.bot.telegram.data.enums.BotApiNames;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.handler.UserAnswerHandler;
import ru.otus.bot.telegram.utils.BotApiFactory;
import ru.otus.bot.telegram.utils.SettingMenuFactory;


@Component
@RequiredArgsConstructor
public class LanguageHandler implements UserAnswerHandler {
    private final MessageBuilder messageBuilder;
    private final BotApiFactory botApiFactory;
    private final SettingMenuFactory settingMenuFactory;

    @Override
    public SendMessage handleUserAnswer(String usersAnswer, long userId, String chatId) {
        settingMenuFactory.getSettingMenuByState(BotState.LANGUAGE).processUserAnswer(userId, usersAnswer);
        return messageBuilder.createMessageWithKeyboard(Long.parseLong(chatId), messageBuilder.getTranslatedMessage("language.data"),
                botApiFactory.getBotApi(BotApiNames.LANGUAGE_API).getApi());
    }

    @Override
    public BotState getHandlerName() {
        return BotState.LANGUAGE;
    }
}
