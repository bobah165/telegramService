package ru.otus.bot.telegram.integration.http;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.config.apiConfig.CarHandlerConfig;
import ru.otus.bot.telegram.data.Car;
import ru.otus.bot.telegram.integration.kafka.publisher.CarSavingProducerService;
import ru.otus.bot.telegram.service.RequestService;

@Service
@RequiredArgsConstructor
public class CarHandlerRequestService {

    private final CarSavingProducerService carSavingProducerService;
    private final RequestService requestService;
    private final CarHandlerConfig carHandlerConfig;


    public void sendCarToCarHandler(Car car) {
        carSavingProducerService.sendCar(car);
    }


    public Car getCarFromCarHandler(Long id) {
        ParameterizedTypeReference<Car> typeReference = new ParameterizedTypeReference<>() {};
        return requestService.get(carHandlerConfig.getBaseurlForCarService() + carHandlerConfig.getCarSubPath() + "/" + id, typeReference);
    }
}
