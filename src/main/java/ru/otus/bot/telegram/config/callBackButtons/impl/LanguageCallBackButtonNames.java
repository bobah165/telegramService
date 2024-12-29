package ru.otus.bot.telegram.config.callBackButtons.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.builder.MessageBuilder;
import ru.otus.bot.telegram.config.callBackButtons.CallBackButtonNames;
import ru.otus.bot.telegram.data.ButtonSateWrapper;
import ru.otus.bot.telegram.data.CallBackButtons;
import ru.otus.bot.telegram.data.enums.BotState;
import ru.otus.bot.telegram.data.enums.CallBackMenu;


@Component
public class LanguageCallBackButtonNames implements CallBackButtonNames {
    private final MessageBuilder messageBuilder;
    private final Map<String, String> buttonNames;

    public LanguageCallBackButtonNames(@Value("#{${buttons.callback.language}}") Map<String, String> buttonNames, MessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
        this.buttonNames = buttonNames;
    }

    @Override
    public List<CallBackButtons> getButtonNames() {
        return buttonNames.entrySet()
                          .stream()
                          .map(entry -> new CallBackButtons().setCallBackKey(entry.getKey())
                                                             .setButtonName(messageBuilder.getTranslatedMessage(entry.getValue())))
                          .collect(Collectors.toList());
    }

    @Override
    public ButtonSateWrapper getButtonWrapper() {
        return new ButtonSateWrapper().setButtonNames(buttonNames)
                                      .setBotState(BotState.PROCESS_LANGUAGE);
    }

    @Override
    public CallBackMenu getCallBackMenuName() {
        return CallBackMenu.LANGUAGE_MENU;
    }
}
