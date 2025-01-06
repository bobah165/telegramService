package ru.otus.bot.telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.otus.bot.telegram.service.TelegramBotService;

@SpringBootApplication
public class TelegramServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TelegramServiceApplication.class, args);
  }
}
