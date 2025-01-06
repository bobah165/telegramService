package ru.otus.bot.telegram.config.apiConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CarMaintenanceConfig {
    @Value("${bot.api.subPath.car-maintenance}")
    private String maintenanceSubPath;

    @Value("${bot.api.baseurlForCarMaintenanceService}")
    private String baseurlForCarMaintenanceService;
}
