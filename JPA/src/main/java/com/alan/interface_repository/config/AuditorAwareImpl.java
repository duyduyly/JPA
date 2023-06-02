package com.alan.interface_repository.config;

import com.alan.interface_repository.utils.BookUtils;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private BookUtils bookUtils;

    @Override
    public Optional<String> getCurrentAuditor() {
        Faker faker = new Faker();
        return Optional.of(faker.superhero().name());
    }
}
