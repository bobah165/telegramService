package ru.otus.bot.telegram.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.bot.telegram.config.callBackButtons.CallBackButtonNames;
import ru.otus.bot.telegram.data.enums.CallBackMenu;

@Component
@RequiredArgsConstructor
public class CallBackMenuFactory {
    private final List<CallBackButtonNames> callBackButtonNames;

    public CallBackButtonNames getButtons(CallBackMenu callBackMenu) {
        return callBackButtonNames.stream()
                                  .collect(Collectors.toMap(CallBackButtonNames::getCallBackMenuName, Function.identity()))
                                  .get(callBackMenu);
    }
}
