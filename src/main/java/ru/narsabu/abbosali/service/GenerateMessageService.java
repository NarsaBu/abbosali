package ru.narsabu.abbosali.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerateMessageService {

    private final MessageService messageService;

    public String generateMessageTo(String user) {
        return user + " " + messageService.getRandomMessage();
    }
}
