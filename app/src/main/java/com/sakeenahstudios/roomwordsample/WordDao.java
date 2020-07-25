package com.sakeenahstudios.roomwordsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

// DAOs must either be interfaces or abstract classes.
@Dao
public interface WordDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy

    // DAO method annotation where you don't have to provide any SQL
    // The selected on conflict strategy ignores a new word if it's exactly the same as one already in the list
    @Insert(onConflict = OnConflictStrategy.IGNORE)

    //Declare a method to insert one word
    void insert(Word word);

    // declares a method to delete all the words
    // There is no convenience annotation for deleting multiple entities, so it's annotated with the generic @Query
    // @Query requires you to provide a SQL query as a string
    @Query("DELETE FROM word_table")
    void deleteALL();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    // A method to get all the words and have it return a List of Words
   LiveData<List<Word>> getAlphabetizedWords();

}
