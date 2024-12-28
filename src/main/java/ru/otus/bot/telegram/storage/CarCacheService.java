package ru.otus.bot.telegram.storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Service;
import ru.otus.bot.telegram.data.Car;

@Service
public class CarCacheService {
    private final ConcurrentMap<Long, Car> carCache = new ConcurrentHashMap<>();

    public void saveCarInCache(long userId, Car car) {
        carCache.put(userId, car);
    }

    public void setCarMileage(long userId, String mileage){
        carCache.computeIfPresent(userId, (k, v) -> v.setMileage(Integer.parseInt(mileage)));
    }

    public void setCarEngine(long userId, String engine){
        carCache.computeIfPresent(userId, (k, v) -> v.setEngineVolume(Float.parseFloat(engine)));
    }

    public void setCarYear(long userId, String year){
        carCache.computeIfPresent(userId, (k, v) -> v.setYear(Integer.parseInt(year)));
    }

    public void setCarTransmission(long userId, String transmission){
        carCache.computeIfPresent(userId, (k, v) -> v.setTransmission(transmission));
    }

    public void setCarModel(long userId, String model){
        carCache.computeIfPresent(userId, (k, v) -> v.setModel(model));
    }

    public Car getCarByUserId(Long userId){
        return carCache.get(userId);
    }
}
