package ru.otus.bot.telegram.data.api.botApiImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.otus.bot.telegram.builder.ButtonBuilder;
import ru.otus.bot.telegram.data.api.BotApi;
import ru.otus.bot.telegram.data.enums.BotApiNames;
import ru.otus.bot.telegram.data.enums.KeyboardMenuButtons;
import ru.otus.bot.telegram.utils.KeyboardButtonsFactory;

@Component
@RequiredArgsConstructor
public class MainMenuApi implements BotApi {
    private final ButtonBuilder buttonBuilder;
    private final KeyboardButtonsFactory keyboardButtonsFactory;

    @Override
    public ReplyKeyboardMarkup getApi() {
        return buttonBuilder.addKeyboardButtons(keyboardButtonsFactory.getButtons(KeyboardMenuButtons.MAIN_MENU)
                                                                      .getButtonNames());
    }

    @Override
    public BotApiNames getBotApiName() {
        return BotApiNames.MAIN_MENU_API;
    }
}
