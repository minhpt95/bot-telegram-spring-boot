package com.minhpt.bot.repository;

import com.minhpt.bot.entity.TelegramUser;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface BotTelegramRepository extends PagingAndSortingRepository<TelegramUser, Long> {
    TelegramUser findByUserId(Long userId);
    TelegramUser findByPhoneNumber(Long userId);
}
