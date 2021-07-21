package org.nwolfhub.works;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

public abstract class UserWorking {
    private static TelegramBot bot;
    public static void initUserWorking(TelegramBot bot) {
        UserWorking.bot = bot;
    }
    public static void sendMessage(Integer chatId, String text) {
        SendMessage request = new SendMessage(chatId, text);
        bot.execute(request);
    }
    public static void sendMessage(Integer chatId, String text, InlineKeyboardMarkup markup) {
        SendMessage request = new SendMessage(chatId, text).replyMarkup(markup);
        bot.execute(request);
    }
    public static void sendInlineQuery(AnswerInlineQuery query) {
        bot.execute(query);
    }

}
