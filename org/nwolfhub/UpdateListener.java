package org.nwolfhub;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import org.nwolfhub.worker.MessageWorker;

import java.util.ArrayList;
import java.util.List;

public class UpdateListener {
    private static Integer offset = 0;
    private static boolean isWorking = true;
    private static void listen(TelegramBot bot) {
        List<Update> updates = new ArrayList<>();
        while(isItWorking()) {
            try {
                GetUpdates request = new GetUpdates().limit(100).offset(getOffset()).timeout(10);
                GetUpdatesResponse response = bot.execute(request);
                updates = response.updates();
                if (updates.size() > 0) {
                    setOffset(updates.get(updates.size() - 1).updateId() + 1);
                    for (Update update : updates) {
                        try {
                            String a = update.inlineQuery().query();
                            MessageWorker.work(update);
                        } catch (NullPointerException ignored) {
                        }
                    }
                }
            } catch (Exception ignored) {}
        }
    }
    public static void startListening(TelegramBot bot){
        Thread listeningThread = new Thread(() -> {
            listen(bot);
        });
        listeningThread.start();
    }


    //getters, setters, other shit
    private static void setOffset(Integer offset) {UpdateListener.offset = offset;}
    private static Integer getOffset() {return UpdateListener.offset;}
    public static boolean isItWorking() {return isWorking;}
    public static void setWorking(boolean isWorking) {UpdateListener.isWorking = isWorking;}
}
