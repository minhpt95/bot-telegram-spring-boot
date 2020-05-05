package com.minhpt.bot.service;

import com.minhpt.bot.entity.TelegramUser;
import com.minhpt.bot.repository.BotTelegramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotTelegramServiceImpl implements BotTelegramService {

    private final BotTelegramRepository botTelegramRepository;

    public BotTelegramServiceImpl(BotTelegramRepository botTelegramRepository) {
        this.botTelegramRepository = botTelegramRepository;
    }

    @Override
    public TelegramUser findByUserId(Long userId) {
        return botTelegramRepository.findByUserId(userId);
    }

    @Override
    public TelegramUser findByPhoneNumber(Long userId) {
        return botTelegramRepository.findByUserId(userId);
    }

    @Override
    public Page<TelegramUser> findAll(PageRequest request) {
        return botTelegramRepository.findAll(request);
    }

    @Override
    public TelegramUser save(TelegramUser telegramUser) {
        return botTelegramRepository.save(telegramUser);
    }

    @Override
    public void delete(TelegramUser telegramUser) {
        botTelegramRepository.delete(telegramUser);
    }

    @Override
    public void delete(Long id) {
        botTelegramRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        botTelegramRepository.deleteAll();
    }

    @Override
    public void deleteAll(List<TelegramUser> telegramUserList) {
        botTelegramRepository.deleteAll(telegramUserList);
    }
}
