package com.minhpt.bot.service;

import com.minhpt.bot.entity.TelegramUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.List;

public interface BotTelegramService {
    TelegramUser findByUserId(Long userId);
    TelegramUser findByPhoneNumber(Long userId);
    Page<TelegramUser> findAll (PageRequest request);
    TelegramUser save(TelegramUser telegramUser);
    void delete(TelegramUser telegramUser);
    void delete(Long id);
    void deleteAll();
    void deleteAll(List<TelegramUser> telegramUserList);

}
