package ru.otus.bot.telegram.integration.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.config.apiConfig.CarHandlerConfig;
import ru.otus.bot.telegram.data.Car;

@Service
@RequiredArgsConstructor
public class CarHandlerRequestService {

    private final CarHandlerConfig carHandlerConfig;


    public void sendCarToCarHandler(Car car) {
    }


    public Car getCarFromCarHandler(Long id) {
        return new Car();
    }
}
