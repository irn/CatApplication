package exam.catapp.sourceit.catapplication.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DBinitialize {
    public static CatDatabase initialize(Context context){
        CatDatabase catDatabase = Room.
                databaseBuilder(context, CatDatabase.class, "cats.db").
                addMigrations(CatDatabase.MIGRATION_1_2).
                build();
        return catDatabase;
    }
}
