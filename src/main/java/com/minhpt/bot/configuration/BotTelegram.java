package com.minhpt.bot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.NoRepositoryBean;

@Configuration
public class BotTelegram {

    @Value("${bot.token}")
    private String token;

    @Bean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient();
    }

    @Bean
    public TelegramBot telegramBot(){
        return new TelegramBot.Builder(token).okHttpClient(okHttpClient()).build();
    }
}
