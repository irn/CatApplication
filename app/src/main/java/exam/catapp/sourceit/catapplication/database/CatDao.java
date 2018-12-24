package exam.catapp.sourceit.catapplication.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import java.util.List;

import exam.catapp.sourceit.catapplication.model.Cat;

/**
 * Created by Ruslan Ivakhnenko on 07.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
@Dao
public interface CatDao {

    @Query("select * from Cat")
    List<Cat> getAll();

    @Query("select * from Cat")
    LiveData<List<Cat>> getLiveDataAll();

    @Query("select * from Cat where id=:catId")
    LiveData<Cat> getCat(int catId);

    @Insert
    void insertCat(List<Cat> cats);
}
