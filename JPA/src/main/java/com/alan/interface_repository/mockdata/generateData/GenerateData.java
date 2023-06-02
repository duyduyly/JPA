package com.alan.interface_repository.mockdata.generateData;

import com.alan.interface_repository.mockdata.entity.MockData;
import com.alan.interface_repository.mockdata.repository.BookRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class GenerateData {

    @Autowired
    private BookRepository bookRepository;

    public Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run(){
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            MockData mockData = MockData.builder()
                    .author(faker.book().author())
                    .title(faker.book().title())
                    .publishDate(this.between(new Date("01/01/2000"),new Date()))
                    .build();
            bookRepository.save(mockData);
        }

            bookRepository.save(MockData.builder()
                    .id(1L)
                    .author("edit")
                    .title(faker.book().title())
                    .publishDate(this.between(new Date("01/01/2000"),new Date()))
                    .build());
    }
}
