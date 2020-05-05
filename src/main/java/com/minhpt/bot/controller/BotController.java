package com.minhpt.bot.controller;

import com.minhpt.bot.component.BotComponent;
import com.minhpt.bot.constant.BotConstantCommand;
import com.minhpt.bot.entity.TelegramUser;
import com.minhpt.bot.service.BotTelegramService;
import com.minhpt.bot.util.BotTelegramUtil;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class BotController implements BotConstantCommand {

    private final BotComponent botComponent;

    private final BotTelegramService botTelegramService;


    public BotController(TelegramBot telegramBot, BotComponent botComponent, BotTelegramService botTelegramService){
        this.botComponent = botComponent;
        this.botTelegramService = botTelegramService;

        telegramBot.setUpdatesListener(updates -> {
            updates.forEach(update -> doAction(update.message().from().id(),update.message()));
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void doAction(Integer userId, Message message) {
        ReplyKeyboardMarkup replyKeyboardMarkup;
        if(Objects.nonNull(message.contact())){
            TelegramUser newTelegramUser = newTelegramUser(message.contact());
            newTelegramUser = botTelegramService.save(newTelegramUser);
            replyKeyboardMarkup = new ReplyKeyboardMarkup(
                    new String[]{"Start Question","My Statistics"}
            ).selective(true).resizeKeyboard(true);
            botComponent.SendMessageFromBot(userId,"Welcome to our system, " + BotTelegramUtil.checkStringNull(newTelegramUser.getFirstName()) + " " + BotTelegramUtil.checkStringNull(newTelegramUser.getLastName()) + " Please choose command to continue" ,replyKeyboardMarkup,null);
        }else{
            TelegramUser checkExistTelegramUser = botTelegramService.findByUserId(Long.valueOf(message.from().id()));
            switch (message.text()){
                case BotConstantCommand.START_BOT:
                    if(Objects.nonNull(checkExistTelegramUser)){
                        replyKeyboardMarkup = new ReplyKeyboardMarkup(
                                new String[]{"Start Question","My Statistic"}
                        ).selective(true).resizeKeyboard(true);
                        botComponent.SendMessageFromBot(userId,"Welcome back our system, " + BotTelegramUtil.checkStringNull(checkExistTelegramUser.getFirstName()) + " " + BotTelegramUtil.checkStringNull(checkExistTelegramUser.getLastName()) + " Please choose command to continue" ,replyKeyboardMarkup,null);
                    }else{
                        botComponent.SendMessageFromBot(
                                userId,
                                "Hello, I'm bot created by Minh Con Meo",
                                null,
                                null);
                        replyKeyboardMarkup = new ReplyKeyboardMarkup(
                                new KeyboardButton[]{
                                        new KeyboardButton("Share Contact").requestContact(true)
                                }
                        ).selective(true).resizeKeyboard(true);
                        botComponent.SendMessageFromBot(userId,"Please click button Share Contact to register Meo's System",replyKeyboardMarkup,null);
                    }
                    break;
                case BotConstantCommand.START_QUESTION:
                    if(Objects.nonNull(checkExistTelegramUser)){

                    }else{
                        botComponent.SendMessageFromBot(
                                userId,
                                "Hello, I'm bot created by Minh Con Meo",
                                null,
                                null);
                        replyKeyboardMarkup = new ReplyKeyboardMarkup(
                                new KeyboardButton[]{
                                        new KeyboardButton("Share Contact").requestContact(true)
                                }
                        ).selective(true).resizeKeyboard(true);
                        botComponent.SendMessageFromBot(userId,"Please click button Share Contact to register Meo's System",replyKeyboardMarkup,null);
                    }
                    break;
                case BotConstantCommand.MY_STATISTICS:
                    if(Objects.nonNull(checkExistTelegramUser)){

                    }else {
                        botComponent.SendMessageFromBot(
                                userId,
                                "Hello, I'm bot created by Minh Con Meo",
                                null,
                                null);
                        replyKeyboardMarkup = new ReplyKeyboardMarkup(
                                new KeyboardButton[]{
                                        new KeyboardButton("Share Contact").requestContact(true)
                                }
                        ).selective(true).resizeKeyboard(true);
                        botComponent.SendMessageFromBot(userId, "Please click button Share Contact to register Meo's System", replyKeyboardMarkup, null);
                        break;
                    }
                        default:
                            replyKeyboardMarkup = new ReplyKeyboardMarkup(
                                    new String[]{"Start Question","My Statistics"}
                            ).selective(true).resizeKeyboard(true);
                            botComponent.SendMessageFromBot(userId,"Command not available, Please choose again !",replyKeyboardMarkup,null);
                    }
            }
        }

        private TelegramUser newTelegramUser(Contact contact){
            TelegramUser newTelegramUser = new TelegramUser();
            newTelegramUser.setFirstName(contact.firstName());
            newTelegramUser.setLastName(contact.lastName());
            newTelegramUser.setPhoneNumber(contact.phoneNumber());
            newTelegramUser.setUserId(Long.valueOf(contact.userId()));
            newTelegramUser.setvCard(contact.vcard());
            return newTelegramUser;
        }
    }
