package edu.sunyulster.meldiesestrella.wordroomdatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by meldiesestrella on 12/8/18.
 */

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getmAllWords();
    }


    public void insert(Word word){
        mRepository.insert(word);
    }

    public LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }
}
