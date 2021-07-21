package org.nwolfhub;

import com.pengrad.telegrambot.TelegramBot;
import org.nwolfhub.db.DBActions;
import org.nwolfhub.works.UserWorking;

public class Main {

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("your token here");
        UserWorking.initUserWorking(bot);
        DBActions.InitializeWrestlingDb();
        UpdateListener.startListening(bot);
    }
}
