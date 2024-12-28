package ru.otus.bot.telegram.data;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.otus.bot.telegram.data.enums.MaintenanceType;

@Data
@Accessors(chain = true)
public class CarMaintenance {
    private String userId;
    private int value;
    private MaintenanceType maintenanceType;

}
