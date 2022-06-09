package ru.narsabu.abbosali.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.narsabu.abbosali.exception.ElementNotFoundException;
import ru.narsabu.abbosali.model.Message;
import ru.narsabu.abbosali.repository.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    public List<String> getAllMessages() {
        val allMessages = repository.findAll();

        return allMessages.stream()
                          .map(Message::getContent)
                          .collect(Collectors.toList());
    }

    public String getMessageBy(Long id) {
        val message = repository.findById(id)
                                .orElseThrow(() -> new ElementNotFoundException("message with id " + id + " does not exist"));

        return message.getContent();
    }

    public Message createNewMessage(String message) {
        return repository.save(new Message(null, message));
    }

    public List<Message> createNeMessages(List<String> messages) {
        val list = messages.stream()
                           .map(it -> new Message(null, it))
                           .toList();

        return repository.saveAll(list);
    }

    public void deleteMessageBy(Long id) {
        repository.deleteById(id);
    }

    public String getRandomMessage() {
        return repository.getRandomMessage().getContent();
    }
}
