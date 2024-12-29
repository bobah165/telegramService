package ru.otus.bot.telegram.integration.kafka.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.data.BotStateDto;
import ru.otus.bot.telegram.data.Car;

@Service
@RequiredArgsConstructor
@Slf4j
public class BotStateProducerService {

  @Value("${topic.producer.state}")
  private String metricClientTopic;

  private final KafkaTemplate<String , Object> kafkaTemplate;

  public void sendBotState(BotStateDto botStateDto) {
    kafkaTemplate.send(metricClientTopic, botStateDto.getId(), botStateDto);
    log.info("Send botStateDto to save from producer {}", botStateDto);
  }
}
