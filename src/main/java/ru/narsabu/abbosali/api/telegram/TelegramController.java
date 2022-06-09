package ru.narsabu.abbosali.api.telegram;

import com.github.kshashov.telegram.api.MessageType;
import com.github.kshashov.telegram.api.TelegramMvcController;
import com.github.kshashov.telegram.api.TelegramRequest;
import com.github.kshashov.telegram.api.bind.annotation.BotController;
import com.github.kshashov.telegram.api.bind.annotation.BotPathVariable;
import com.github.kshashov.telegram.api.bind.annotation.BotRequest;
import com.github.kshashov.telegram.api.bind.annotation.request.MessageRequest;
import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.PathVariable;
import ru.narsabu.abbosali.configuration.properties.TelegramBotConfigurationProperties;
import ru.narsabu.abbosali.service.GenerateMessageService;

import java.io.IOException;

@BotController
@RequiredArgsConstructor
public class TelegramController implements TelegramMvcController {

    private final TelegramBotConfigurationProperties properties;
    private final GenerateMessageService service;

    @BotRequest("/help")
    public String help() {
        return """
                /help - руковоство пользователя
                /обоссать *кого обоссать* - начнет обоссывать челика по-всякому
                """;
    }

    @BotRequest("/обоссать {param:[^\\s]+}")
    public String piss(TelegramRequest request) {
        val user = request.getText().split(" ")[1];
        return service.generateMessageTo(user);
    }

    @Override
    public String getToken() {
        return properties.getToken();
    }
}
