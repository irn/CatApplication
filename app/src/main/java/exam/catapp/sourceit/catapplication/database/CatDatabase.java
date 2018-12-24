package exam.catapp.sourceit.catapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import exam.catapp.sourceit.catapplication.model.Cat;

/**
 * Created by Ruslan Ivakhnenko on 10.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
@Database(entities = {Cat.class}, version = 1)
public abstract class CatDatabase extends RoomDatabase {

    public abstract CatDao catDao();
}
