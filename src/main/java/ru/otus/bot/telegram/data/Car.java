package ru.otus.bot.telegram.data;


import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Car {
    private String id;
    private String chatId;
    private String model;
    private int year;
    private float engineVolume;
    private String transmission;
    @Min(value = 0, message = "Wrong number")
    private int mileage;
}
