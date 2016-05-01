package com.jfilowk.elementstest.data.cache;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.entity.mapper.ItemEntityMapper;
import com.jfilowk.elementstest.data.network.CallbackGeneric;
import java.util.Collection;

public class ItemCacheImpl extends CacheApplicationDB implements ItemCache {

  private ItemEntityMapper itemEntityMapper;

  public ItemCacheImpl(Context context, ItemEntityMapper itemEntityMapper) {
    super(context);
    this.itemEntityMapper = itemEntityMapper;
  }

  @Override
  public void obtainListDeviceApplicationEntity(CallbackGeneric<Collection<ItemEntity>> callback) {
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
}
