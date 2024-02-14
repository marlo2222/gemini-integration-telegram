package com.gemini.integration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotService extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(BotService.class);
    private final String bot_name = System.getenv("BOT_NAME");
    private final String bot_token = System.getenv("TOKEN_BOT");
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (update.hasMessage()){
            long chatId = message.getChatId();
            String input = message.getText();
            logger.info("Receiving user msg:" +  chatId);
            String resposta_ia = new GeminiService().gemini_generate(input);
            executeMessage(sendMessage(chatId, resposta_ia));
        }
    }

    @Override
    public String getBotUsername() {
        return bot_name;
    }

    @Override
    public String getBotToken() {
        return bot_token;
    }

    public SendMessage sendMessage(long chatId, String message){
        SendMessage send = new SendMessage();
        send.setChatId(chatId);
        send.setText(message);
        send.enableHtml(true);
        return send;
    }

    public void executeMessage(SendMessage message){
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
