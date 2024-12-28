package ru.otus.bot.telegram.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import ru.otus.bot.telegram.config.TelegramBotConfig;


@Service
public class TelegramBotService extends SpringWebhookBot {

    private final UpdateService updateService;
    private final TelegramBotConfig botConfig;

    public TelegramBotService(UpdateService updateService, SetWebhook setWebhook, TelegramBotConfig botConfig) {
        super(setWebhook, botConfig.getToken());
        this.updateService = updateService;
        this.botConfig = botConfig;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return updateService.processUpdate(update);
    }

    @Override
    public String getBotPath() {
        return botConfig.getPath();
    }

    @Override
    public String getBotUsername() {
        return botConfig.getUsername();
    }
}
