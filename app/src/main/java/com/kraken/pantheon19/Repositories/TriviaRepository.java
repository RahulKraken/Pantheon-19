package com.kraken.pantheon19.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kraken.pantheon19.Dao.TriviaDao;
import com.kraken.pantheon19.Database.TriviaDatabase;
import com.kraken.pantheon19.Entities.Trivia;

import java.util.List;

public class TriviaRepository {
    private static final String TAG = "TriviaRepository";

    private static LiveData<Trivia> trivia;
    private static LiveData<List<Trivia>> trivias;

    private TriviaDao triviaDao;

    public TriviaRepository(Application application) {
        TriviaDatabase triviaDatabase = TriviaDatabase.getInstance(application);
        triviaDao = triviaDatabase.triviaDao();
        trivia = triviaDao.getTrivia();
        trivias = triviaDao.getAllTrivia();
    }

    // triviaDao methods
    public void insertTrivia(Trivia trivia) {
        new InsertTriviaAsyncTask(triviaDao).execute(trivia);
    }

    public void updateTrivia(Trivia trivia) {
        new UpdateTriviaAsyncTask(triviaDao).execute(trivia);
    }

    public void deleteTrivia(Trivia trivia) {
        new DeleteTriviaAsyncTask(triviaDao).execute(trivia);
    }

    public void deleteAllTrivia() {
        new DeleteAllTriviaAsyncTask(triviaDao).execute();
    }

    public LiveData<Trivia> getTrivia() {
        new GetTriviaAsyncTask(triviaDao).execute();
        return trivia;
    }

    public LiveData<List<Trivia>> getAllTrivias() {
        new GetAllTriviaAsyncTask(triviaDao).execute();
        return trivias;
    }

    /*
    Async tasks for trivia table transactions
     */
    private static class InsertTriviaAsyncTask extends AsyncTask<Trivia, Void, Void> {
        TriviaDao triviaDao;

        public InsertTriviaAsyncTask(TriviaDao triviaDao) {
            this.triviaDao = triviaDao;
        }

        @Override
        protected Void doInBackground(Trivia... trivias) {
            triviaDao.insert(trivias[0]);
            return null;
        }
    }

    private static class UpdateTriviaAsyncTask extends AsyncTask<Trivia, Void, Void> {
        TriviaDao triviaDao;

        public UpdateTriviaAsyncTask(TriviaDao triviaDao) {
            this.triviaDao = triviaDao;
        }

        @Override
        protected Void doInBackground(Trivia... trivias) {
            triviaDao.update(trivias[0]);
            return null;
        }
    }

    private static class DeleteTriviaAsyncTask extends AsyncTask<Trivia, Void, Void> {
        TriviaDao triviaDao;

        public DeleteTriviaAsyncTask(TriviaDao triviaDao) {
            this.triviaDao = triviaDao;
        }

        @Override
        protected Void doInBackground(Trivia... trivias) {
            triviaDao.delete(trivias[0]);
            return null;
        }
    }

    private static class DeleteAllTriviaAsyncTask extends AsyncTask<Void, Void, Void> {
        TriviaDao triviaDao;

        public DeleteAllTriviaAsyncTask(TriviaDao triviaDao) {
            this.triviaDao = triviaDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            triviaDao.deleteAllTrivia();
            return null;
        }
    }

    private static class GetTriviaAsyncTask extends AsyncTask<Void, Void, Void> {
        TriviaDao triviaDao;

        public GetTriviaAsyncTask(TriviaDao triviaDao) {
            this.triviaDao = triviaDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            trivia = triviaDao.getTrivia();
            return null;
        }
    }

    private static class GetAllTriviaAsyncTask extends AsyncTask<Void, Void, Void> {
        TriviaDao triviaDao;

        public GetAllTriviaAsyncTask(TriviaDao triviaDao) {
            this.triviaDao = triviaDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            trivias = triviaDao.getAllTrivia();
            return null;
        }
    }
}
