package com.sakeenahstudios.roomwordsample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
 db tables are called Entities which equate to SQLite tables. Each property represents
 a column in the table
 */

// @Entity annotation to declare the tableName
@Entity(tableName = "word_table")

public class Word {

    // Annotations to set PrimaryKey, Constraints, column name
    // word = NonNull
    // word = Primary Key

    // autogenerate option
    /* @PrimaryKey(autoGenerate = true)
        private int id;
     */
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    // Class constructor
    public Word(@NonNull String word) {this.mWord = word;}

    // get word
    public String getWord () {
        return this.mWord;
    }
}
