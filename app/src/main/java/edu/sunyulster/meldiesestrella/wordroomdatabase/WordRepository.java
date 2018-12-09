package edu.sunyulster.meldiesestrella.wordroomdatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by meldiesestrella on 12/8/18.
 */

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application){
        WordRoomDatabase database = WordRoomDatabase.getINSTANCE(application);
        mWordDao = database.wordDao();
        mAllWords = mWordDao.getAll();
    }

    public LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }


    public void insert(Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        private insertAsyncTask(WordDao dao){
           this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }


    //Optional
    public void update(Word word){

    }
    //Optional
    public void delete(Word word){

    }


    //Opt out
    public void deleteAll(){

    }

}
