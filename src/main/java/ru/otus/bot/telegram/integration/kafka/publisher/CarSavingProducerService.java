package ru.otus.bot.telegram.integration.kafka.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.data.Car;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarSavingProducerService {

  @Value("${topic.producer.car}")
  private String metricClientTopic;

  private final KafkaTemplate<String , Object> kafkaTemplate;

  public void sendCar(Car car) {
    kafkaTemplate.send(metricClientTopic, car.getId(), car);
    log.info("Send car to save from producer {}", car);
  }
}
