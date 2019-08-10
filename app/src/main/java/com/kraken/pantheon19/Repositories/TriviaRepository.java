package com.kraken.pantheon19.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.kraken.pantheon19.Dao.TriviaDao;
import com.kraken.pantheon19.Database.TriviaDatabase;
import com.kraken.pantheon19.Entities.Trivia;

import java.util.List;

public class TriviaRepository {
    private static final String TAG = "TriviaRepository";

    private LiveData<Trivia> trivia;
    private LiveData<List<Trivia>> trivias;

    private TriviaDao triviaDao;

    public TriviaRepository(Application application) {
        TriviaDatabase triviaDatabase = TriviaDatabase.getInstance(application);
        triviaDao = triviaDatabase.triviaDao();
        trivia = triviaDao.getTrivia();
        trivias = triviaDao.getAllTrivia();
    }

    // triviaDao methods
    public void insertTrivia(Trivia trivia) {

    }

    public void updateTrivia(Trivia trivia) {

    }

    public void deleteTrivia(Trivia trivia) {

    }

    public void deleteAllTrivia() {

    }

    public LiveData<Trivia> getTrivia() {
        return trivia;
    }

    public LiveData<List<Trivia>> getAllTrivias() {
        return trivias;
    }

    /*
    Async tasks for trivia table transactions
     */

}
