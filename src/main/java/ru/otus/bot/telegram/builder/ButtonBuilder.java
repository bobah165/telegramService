package ru.otus.bot.telegram.builder;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.otus.bot.telegram.data.CallBackButtons;
import ru.otus.bot.telegram.data.KeyboardButtonName;

@Component
public class ButtonBuilder {

    public ReplyKeyboardMarkup addKeyboardButtons(List<KeyboardButtonName> buttonNames) {
        final List<KeyboardRow> keyboardRowList = buttonNames.stream()
                                                             .map(KeyboardButtonName::getName)
                                                             .map(KeyboardButton::new)
                                                             .map(button -> {
                                                                 KeyboardRow row = new KeyboardRow();
                                                                 row.add(button);
                                                                 return row;
                                                             })
                                                             .collect(Collectors.toList());

        return ReplyKeyboardMarkup.builder()
                                  .selective(true)
                                  .resizeKeyboard(true)
                                  .oneTimeKeyboard(false)
                                  .keyboard(keyboardRowList)
                                  .build();

    }

    public InlineKeyboardMarkup addCallBackButtons(List<CallBackButtons> buttonNames) {
        final List<InlineKeyboardButton> row = buttonNames.stream()
                                                          .map(button -> createButton(button.getCallBackKey(), button.getButtonName()))
                                                          .collect(Collectors.toList());

        return InlineKeyboardMarkup.builder()
                                   .keyboard(List.of(row))
                                   .build();
    }

    private InlineKeyboardButton createButton(String callBackData, String text) {
        return InlineKeyboardButton.builder()
                                   .text(text)
                                   .callbackData(callBackData)
                                   .build();
    }
}
