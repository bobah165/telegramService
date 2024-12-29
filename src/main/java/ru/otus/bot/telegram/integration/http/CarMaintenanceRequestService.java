package ru.otus.bot.telegram.integration.http;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.config.apiConfig.CarMaintenanceConfig;
import ru.otus.bot.telegram.data.CarMaintenance;

@Service
@RequiredArgsConstructor
public class CarMaintenanceRequestService {

    private final CarMaintenanceConfig config;


    public void sendCarMaintenance(CarMaintenance carMaintenance){

    }

    public List<CarMaintenance> getCarMaintenance(String id){
        return new ArrayList<>();
    }
}
