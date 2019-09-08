package com.kraken.pantheon19.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.kraken.pantheon19.Dao.TriviaDao;
import com.kraken.pantheon19.Entities.Trivia;

@Database(entities = {Trivia.class}, version = 1, exportSchema = false)
public abstract class TriviaDatabase extends RoomDatabase {
    private static final String TAG = "TriviaDatabase";

    public static TriviaDatabase instance;

    public abstract TriviaDao triviaDao();

    public static TriviaDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, TriviaDatabase.class, "trivia_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(triviaCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback triviaCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InitTriviaDatabaseAsyncTask(instance).execute();
        }
    };

    private static class InitTriviaDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {
        TriviaDao triviaDao;

        InitTriviaDatabaseAsyncTask(TriviaDatabase triviaDatabase) {
            triviaDao = triviaDatabase.triviaDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            triviaDao.insert(new Trivia(1, "trivia1", "desc1", "url1", "url1"));
            triviaDao.insert(new Trivia(2, "trivia2", "desc2", "url2", "url2"));
            triviaDao.insert(new Trivia(3, "trivia3", "desc3", "url3", "url3"));
            return null;
        }
    }
}
