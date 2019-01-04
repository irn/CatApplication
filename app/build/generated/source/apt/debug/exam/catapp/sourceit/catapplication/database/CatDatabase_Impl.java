package exam.catapp.sourceit.catapplication.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class CatDatabase_Impl extends CatDatabase {
  private volatile CatDao _catDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Cat` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `age` INTEGER NOT NULL, `name` TEXT, `breed` TEXT, `imageUrl` TEXT, `description` TEXT, `gender` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"9e80c3cbdc5a897174e94a172a5682b4\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Cat`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCat = new HashMap<String, TableInfo.Column>(7);
        _columnsCat.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsCat.put("age", new TableInfo.Column("age", "INTEGER", true, 0));
        _columnsCat.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsCat.put("breed", new TableInfo.Column("breed", "TEXT", false, 0));
        _columnsCat.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0));
        _columnsCat.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        _columnsCat.put("gender", new TableInfo.Column("gender", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCat = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCat = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCat = new TableInfo("Cat", _columnsCat, _foreignKeysCat, _indicesCat);
        final TableInfo _existingCat = TableInfo.read(_db, "Cat");
        if (! _infoCat.equals(_existingCat)) {
          throw new IllegalStateException("Migration didn't properly handle Cat(exam.catapp.sourceit.catapplication.model.Cat).\n"
                  + " Expected:\n" + _infoCat + "\n"
                  + " Found:\n" + _existingCat);
        }
      }
    }, "9e80c3cbdc5a897174e94a172a5682b4", "b38ab6e27f5c4071942024dd847a2409");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Cat");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Cat`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CatDao catDao() {
    if (_catDao != null) {
      return _catDao;
    } else {
      synchronized(this) {
        if(_catDao == null) {
          _catDao = new CatDao_Impl(this);
        }
        return _catDao;
      }
    }
  }
}
