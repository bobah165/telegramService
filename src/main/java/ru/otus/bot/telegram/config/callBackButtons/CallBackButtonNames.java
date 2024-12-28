package ru.otus.bot.telegram.config.callBackButtons;

import java.util.List;
import ru.otus.bot.telegram.data.ButtonSateWrapper;
import ru.otus.bot.telegram.data.CallBackButtons;
import ru.otus.bot.telegram.data.enums.CallBackMenu;

public interface CallBackButtonNames {
    List<CallBackButtons> getButtonNames();
    ButtonSateWrapper getButtonWrapper();
    CallBackMenu getCallBackMenuName();

}
