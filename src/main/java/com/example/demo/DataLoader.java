package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CarRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Car car;
        car = new Car("2019", "Maserati", "Vroom");
        repository.save(car);

        car = new Car("2019", "Ferrari", "Testoserosa");
        repository.save(car);

        car = new Car("2018", "Nissan", "Testoserosa");
        repository.save(car);
    }
}
