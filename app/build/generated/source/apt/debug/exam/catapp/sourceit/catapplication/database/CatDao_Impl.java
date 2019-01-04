package exam.catapp.sourceit.catapplication.database;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import exam.catapp.sourceit.catapplication.model.Cat;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class CatDao_Impl implements CatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCat;

  public CatDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCat = new EntityInsertionAdapter<Cat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Cat`(`id`,`age`,`name`,`breed`,`imageUrl`,`description`,`gender`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Cat value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getAge());
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getBreed() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBreed());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescription());
        }
        if (value.getGender() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGender());
        }
      }
    };
  }

  @Override
  public void insertCat(List<Cat> cats) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCat.insert(cats);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Cat> getAll() {
    final String _sql = "select * from Cat";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("age");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfBreed = _cursor.getColumnIndexOrThrow("breed");
      final int _cursorIndexOfImageUrl = _cursor.getColumnIndexOrThrow("imageUrl");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("gender");
      final List<Cat> _result = new ArrayList<Cat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Cat _item;
        _item = new Cat();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        _item.setAge(_tmpAge);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpBreed;
        _tmpBreed = _cursor.getString(_cursorIndexOfBreed);
        _item.setBreed(_tmpBreed);
        final String _tmpImageUrl;
        _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        _item.setImageUrl(_tmpImageUrl);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final String _tmpGender;
        _tmpGender = _cursor.getString(_cursorIndexOfGender);
        _item.setGender(_tmpGender);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Cat>> getLiveDataAll() {
    final String _sql = "select * from Cat";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Cat>>() {
      private Observer _observer;

      @Override
      protected List<Cat> compute() {
        if (_observer == null) {
          _observer = new Observer("Cat") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("age");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfBreed = _cursor.getColumnIndexOrThrow("breed");
          final int _cursorIndexOfImageUrl = _cursor.getColumnIndexOrThrow("imageUrl");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("gender");
          final List<Cat> _result = new ArrayList<Cat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Cat _item;
            _item = new Cat();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            _item.setAge(_tmpAge);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpBreed;
            _tmpBreed = _cursor.getString(_cursorIndexOfBreed);
            _item.setBreed(_tmpBreed);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            _item.setImageUrl(_tmpImageUrl);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            _item.setGender(_tmpGender);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<Cat> getCat(int catId) {
    final String _sql = "select * from Cat where id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, catId);
    return new ComputableLiveData<Cat>() {
      private Observer _observer;

      @Override
      protected Cat compute() {
        if (_observer == null) {
          _observer = new Observer("Cat") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("age");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfBreed = _cursor.getColumnIndexOrThrow("breed");
          final int _cursorIndexOfImageUrl = _cursor.getColumnIndexOrThrow("imageUrl");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("gender");
          final Cat _result;
          if(_cursor.moveToFirst()) {
            _result = new Cat();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            _result.setAge(_tmpAge);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result.setName(_tmpName);
            final String _tmpBreed;
            _tmpBreed = _cursor.getString(_cursorIndexOfBreed);
            _result.setBreed(_tmpBreed);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            _result.setImageUrl(_tmpImageUrl);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _result.setDescription(_tmpDescription);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            _result.setGender(_tmpGender);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<Cat>> getCatsByGender(String gender) {
    final String _sql = "select * from Cat where gender=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (gender == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, gender);
    }
    return new ComputableLiveData<List<Cat>>() {
      private Observer _observer;

      @Override
      protected List<Cat> compute() {
        if (_observer == null) {
          _observer = new Observer("Cat") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfAge = _cursor.getColumnIndexOrThrow("age");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfBreed = _cursor.getColumnIndexOrThrow("breed");
          final int _cursorIndexOfImageUrl = _cursor.getColumnIndexOrThrow("imageUrl");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfGender = _cursor.getColumnIndexOrThrow("gender");
          final List<Cat> _result = new ArrayList<Cat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Cat _item;
            _item = new Cat();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final int _tmpAge;
            _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            _item.setAge(_tmpAge);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpBreed;
            _tmpBreed = _cursor.getString(_cursorIndexOfBreed);
            _item.setBreed(_tmpBreed);
            final String _tmpImageUrl;
            _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            _item.setImageUrl(_tmpImageUrl);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            _item.setGender(_tmpGender);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
