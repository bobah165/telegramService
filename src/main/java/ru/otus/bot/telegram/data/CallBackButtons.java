package ru.otus.bot.telegram.data;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CallBackButtons {
    private String callBackKey;
    private String buttonName;
}
