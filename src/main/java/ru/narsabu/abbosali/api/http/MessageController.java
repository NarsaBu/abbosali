package ru.narsabu.abbosali.api.http;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.narsabu.abbosali.model.Message;
import ru.narsabu.abbosali.service.MessageService;

import java.util.List;

@RestController("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/all")
    @Operation(summary = "get all messages")
    public List<String> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    @Operation(summary = "get message by id")
    public String getMessageBy(@PathVariable Long id) {
        return messageService.getMessageBy(id);
    }

    @PostMapping
    @Operation(summary = "create new message")
    public Message addNewMessage(@RequestBody String message) {
        return messageService.createNewMessage(message);
    }

    @PostMapping
    @Operation(summary = "create new messages")
    public List<Message> addNewMessages(@RequestBody List<String> messages) {
        return messageService.createNeMessages(messages);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete message by id")
    public void deleteMessageBy(@PathVariable Long id) {
        messageService.deleteMessageBy(id);
    }

    @GetMapping("/random")
    @Operation(summary = "get random message")
    public String getRandomMessage() {
        return messageService.getRandomMessage();
    }
}
