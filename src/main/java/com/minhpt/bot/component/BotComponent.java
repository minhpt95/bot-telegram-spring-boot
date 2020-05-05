package com.minhpt.bot.component;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ReplyKeyboardRemove;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class BotComponent {
    private final TelegramBot telegramBot;

    public BotComponent(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void SendMessageFromBot(Integer chatID, String message, ReplyKeyboardMarkup replyKeyboardMarkup, ReplyKeyboardRemove replyKeyboardRemove){
        SendMessage sendMessage = new SendMessage(chatID,message);

        if(Objects.nonNull(replyKeyboardMarkup)){
            sendMessage.replyMarkup(replyKeyboardMarkup);
        }

        if(Objects.nonNull(replyKeyboardRemove)){
            sendMessage.replyMarkup(replyKeyboardRemove);
        }

        telegramBot.execute(sendMessage, new Callback<SendMessage, SendResponse>() {
            @Override
            public void onResponse(SendMessage request, SendResponse response) {

            }

            @Override
            public void onFailure(SendMessage request, IOException e) {

            }
        });
    }
}
