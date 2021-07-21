package org.nwolfhub.worker;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineQueryResult;
import com.pengrad.telegrambot.model.request.InlineQueryResultPhoto;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import org.nwolfhub.db.DBActions;
import org.nwolfhub.db.Wrestler;
import org.nwolfhub.works.UserWorking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageWorker {
    public static void work(Update update) {
        String query = update.inlineQuery().query();
        List<Wrestler> found = DBActions.searchWrestlers(query);
        if(!found.isEmpty()) {
            InlineQueryResult<InlineQueryResultPhoto>[] res = new InlineQueryResultPhoto[Math.min(found.size(), 5)];
            for (int max = 5, now = 0; now < max && now < found.size(); now++) {
                res[now] = new InlineQueryResultPhoto(String.valueOf(now), found.get(now).getPhoto(), found.get(now).getPhoto());
            }
            UserWorking.sendInlineQuery(new AnswerInlineQuery(update.inlineQuery().id(), res).cacheTime(1));
        } else {
            InlineQueryResult<InlineQueryResultPhoto> nothing = new InlineQueryResultPhoto("nothing", "https://droider.ru/wp-content/uploads/2021/01/nothing_blog_-_graph_image_2x_c9a4ec76-256c-400d-979d-6349ca93f3f4.png", "https://droider.ru/wp-content/uploads/2021/01/nothing_blog_-_graph_image_2x_c9a4ec76-256c-400d-979d-6349ca93f3f4.png").title("Nothing was found");
            UserWorking.sendInlineQuery(new AnswerInlineQuery(update.inlineQuery().id(), nothing));
        }
    }
}
