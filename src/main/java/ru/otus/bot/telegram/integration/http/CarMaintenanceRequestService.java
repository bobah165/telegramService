package ru.otus.bot.telegram.integration.http;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.config.apiConfig.CarMaintenanceConfig;
import ru.otus.bot.telegram.data.CarMaintenance;
import ru.otus.bot.telegram.service.RequestService;

@Service
@RequiredArgsConstructor
public class CarMaintenanceRequestService {

    private final CarMaintenanceConfig config;
    private final RequestService requestService;


    public List<CarMaintenance> getCarMaintenance(String id){
        ParameterizedTypeReference<List<CarMaintenance>> typeReference = new ParameterizedTypeReference<>() {};
        return requestService.get(config.getBaseurlForCarMaintenanceService() + config.getMaintenanceSubPath() + "/" + id, typeReference);
    }
}
