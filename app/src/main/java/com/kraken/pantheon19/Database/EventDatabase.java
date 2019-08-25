package com.kraken.pantheon19.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.kraken.pantheon19.Dao.EventDao;
import com.kraken.pantheon19.Dao.WinnerDao;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.Entities.Winner;

/**
 * Singleton class pattern
 */
@Database(entities = {Event.class, Winner.class}, version = 1)
public abstract class EventDatabase extends RoomDatabase {
    private static final String TAG = "EventDatabase";

    private static EventDatabase instance;

    public abstract EventDao eventDao();
    public abstract WinnerDao winnerDao();

    public static EventDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, EventDatabase.class, "event_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(eventDbCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback eventDbCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InitEventDbAsyncTask(instance).execute();
        }
    };

    private static class InitEventDbAsyncTask extends AsyncTask<Void, Void, Void> {
        EventDao eventDao;
        WinnerDao winnerDao;

        InitEventDbAsyncTask(EventDatabase eventDatabase) {
            this.eventDao = eventDatabase.eventDao();
            this.winnerDao = eventDatabase.winnerDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            eventDao.insert(new Event(1, "event1", "desc1", "complete", "10:00", "IC", 1,  4, "Rahul", flagship));
            eventDao.insert(new Event(2, "event2", "desc2", "complete", "11:00", "IC", 1,  4, "Rahul", flagship));
            eventDao.insert(new Event(3, "event3", "desc3", "complete", "13:00", "IC", 2,  4, "Rahul", flagship));

            winnerDao.insert(new Winner(1, "Rahul", "Kraken", "RahulKraken"));
            winnerDao.insert(new Winner(2, "Kraken", "Rahul", "RahulKraken"));
            winnerDao.insert(new Winner(3, "Rahul", "RahulKraken", "Kraken"));
            return null;
        }
    }
}
