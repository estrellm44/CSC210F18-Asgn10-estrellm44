package edu.sunyulster.meldiesestrella.wordroomdatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by meldiesestrella on 12/8/18.
 */

@Entity(tableName = "word_table")
public class Word {

    public Word(String mWord, String mDef) {
        this.mWord = mWord;
        this.mDef = mDef;
    }

    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "word_column")
    private String mWord;

    @ColumnInfo(name = "def_column")
    private String mDef;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return mWord;
    }

    public String getDef() {
        return mDef;
    }
}
