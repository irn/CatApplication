package exam.catapp.sourceit.catapplication.database;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by Ruslan Ivakhnenko on 04.01.2019.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class DBInitializer {

    public static CatDatabase initialize(Context context){
        CatDatabase catDatabase = Room.
                databaseBuilder(context, CatDatabase.class, "cats.db").
                addMigrations(CatDatabase.MIGRATION_1_2).
                build();
        return catDatabase;

    }
}
