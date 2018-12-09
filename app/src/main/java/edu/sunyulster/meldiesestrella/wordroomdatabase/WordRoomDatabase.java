package edu.sunyulster.meldiesestrella.wordroomdatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by meldiesestrella on 12/8/18.
 */

@Database(entities =  {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static WordRoomDatabase INSTANCE;

    public abstract WordDao wordDao();

    public static synchronized WordRoomDatabase getINSTANCE(Context context){
        if (INSTANCE == null){
            // Create database
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WordRoomDatabase.class, "word_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(sRoomDatabaseCallback)
                    .build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{

        private WordDao mDao;
        String [] words = {"dolphin", "crocodile", "cobra"};
        String [] defs = {"A small gregarious toothed whale that typically has a beaklike snout and a curved fin on the back. Dolphins have become well known for their sociable nature and high intelligence.",
                "A large predatory semiaquatic reptile with long jaws, long tail, short legs, and a horny textured skin.",
                "A highly venomous African or Asian snake that spreads the skin of its neck into a hood when disturbed."};

        private PopulateDbAsync(WordRoomDatabase db){
            mDao = db.wordDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            for( int i = 0; i <= words.length - 1; i++) {
                //Word word = new Word(words[i], defs[i]);
                mDao.insert(new Word(words[i], defs[i]));
            }
            return null;
        }
    }

}
