package ru.otus.bot.telegram.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.otus.bot.telegram.data.enums.BotState;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BotStateDto {
    private String id;
    private BotState botState;
}
