package com.example.demo.service.impl;
import com.example.demo.model.VideoEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service

public class VideoEventService {
    @Bean
    public Consumer<VideoEvent> pageEventConsumer(){
        return(input) -> {
            System.out.println("********************");
            System.out.println(input.getName());
            System.out.println("********************");
        };
    }

    @Bean
    public Supplier<VideoEvent> pageEventSupplier(){
        return() -> new VideoEvent(Math.random()>0.5?"X1":"X3",
                Math.random()>0.5?"A1":"AS",
                new Date(),
                new Random().nextInt(9000));
    }
}
