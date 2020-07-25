package com.sakeenahstudios.roomwordsample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    // Constructor
    // Pass in the repository the DAO, it contains all the read/write methods
    // The entire db doesn't need to be exposed to the repository
    WordRepository(Application application) {

        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    // getAllWords returns live data a list of words
    // getAllWords is connected to getAlphabetizedWords which returns LiveData
    // Observed LiveData will notify the observer when the data has changed
    LiveData<List<Word>> getAllWords() {
        return  mAllWords;
    }

    void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute( () -> {
            mWordDao.insert(word);});
    }
}
