package ru.otus.bot.telegram.data;

import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.otus.bot.telegram.data.enums.MetricType;

@Data
@Accessors(chain = true)
public class Metrics {
    private String userId;
    private MetricType metricType;
    private String value;
    private LocalDate date;
}
