package ru.otus.bot.telegram.data.api.botApiImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import ru.otus.bot.telegram.builder.ButtonBuilder;
import ru.otus.bot.telegram.data.api.BotApi;
import ru.otus.bot.telegram.data.enums.BotApiNames;
import ru.otus.bot.telegram.data.enums.CallBackMenu;
import ru.otus.bot.telegram.utils.CallBackMenuFactory;


@Component
@RequiredArgsConstructor
public class LanguageMenuApi implements BotApi {
    private final ButtonBuilder buttonBuilder;
    private final CallBackMenuFactory callBackMenuFactory;

    @Override
    public ReplyKeyboard getApi() {
        return buttonBuilder.addCallBackButtons(callBackMenuFactory.getButtons(CallBackMenu.LANGUAGE_MENU)
                                                             .getButtonNames());
    }

    @Override
    public BotApiNames getBotApiName() {
        return BotApiNames.LANGUAGE_API;
    }
}
