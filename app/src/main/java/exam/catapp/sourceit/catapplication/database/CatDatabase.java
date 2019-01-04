package exam.catapp.sourceit.catapplication.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

import exam.catapp.sourceit.catapplication.model.Cat;

/**
 * Created by Ruslan Ivakhnenko on 10.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
@Database(entities = {Cat.class}, version = 2)
public abstract class CatDatabase extends RoomDatabase {

    public abstract CatDao catDao();

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Cat ADD COLUMN gender VARCHAR(100)");
            database.execSQL("delete from Cat");
        }
    };
}
