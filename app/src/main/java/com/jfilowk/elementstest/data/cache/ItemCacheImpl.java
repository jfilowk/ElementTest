package com.jfilowk.elementstest.data.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.entity.mapper.ItemEntityMapper;
import com.jfilowk.elementstest.data.network.CallbackGeneric;
import java.util.Collection;
import javax.inject.Inject;

public class ItemCacheImpl extends CacheApplicationDB implements ItemCache {

  private ItemEntityMapper itemEntityMapper;

  @Inject public ItemCacheImpl(Context context, ItemEntityMapper itemEntityMapper) {
    super(context);
    this.itemEntityMapper = itemEntityMapper;
  }

  @Override public boolean insertItemListEntity(Collection<ItemEntity> itemEntityCollection) {
    boolean success = true;
    SQLiteDatabase db = this.getWritableDatabase();
    if (itemEntityCollection != null) {
      CacheApplicationDB.deleteDataTable(db, ITEMS_TABLE);
      db.beginTransaction();
      try {
        for (ItemEntity itemEntity : itemEntityCollection) {
          long insert = db.insertOrThrow(ITEMS_TABLE, null, bindItemEntity(itemEntity));
          if (insert < 0) {
            success = false;
            break;
          }
        }
        db.setTransactionSuccessful();
      } catch (SQLException e) {
        success = false;
      } finally {
        db.endTransaction();
        db.close();
      }
    } else {
      success = false;
    }
    return success;
  }

  @Override public void obtainItemListEntity(CallbackGeneric<Collection<ItemEntity>> callback) {
    SQLiteDatabase db = this.getReadableDatabase();
    String selectQuery = "SELECT * FROM " + ITEMS_TABLE;
    try {
      Cursor cursor = db.rawQuery(selectQuery, null);
      Collection<ItemEntity> itemEntityCollection = itemEntityMapper.transform(cursor);
      callback.onSuccess(itemEntityCollection);
    } catch (Exception e) {
      callback.onError(e);
    } finally {
      db.close();
    }
  }

  private ContentValues bindItemEntity(ItemEntity itemEntity) {
    ContentValues values = new ContentValues();

    values.put("title", itemEntity.getTitle());
    values.put("description", itemEntity.getDescription());
    values.put("url", itemEntity.getUrl());
    values.put("expires", 100);

    return values;
  }
}
