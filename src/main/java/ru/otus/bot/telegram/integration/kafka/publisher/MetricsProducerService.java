package ru.otus.bot.telegram.integration.kafka.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.data.Metrics;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetricsProducerService {

  @Value("${topic.producer.metric}")
  private String metricClientTopic;

  private final KafkaTemplate<String , Object> kafkaTemplate;

  public void sendMetric(Metrics metrics) {
    kafkaTemplate.send(metricClientTopic, metrics.getId(), metrics);
    log.info("Send metrics from producer {}", metrics);
  }
}
