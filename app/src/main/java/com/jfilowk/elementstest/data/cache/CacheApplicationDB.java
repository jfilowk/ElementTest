package com.jfilowk.elementstest.data.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CacheApplicationDB extends SQLiteOpenHelper {

  public static final String DATABASE_NAME = "elementstest.db";

  public static final String ITEMS_TABLE = "items";

  public static final String ID = "id";
  public static final String TITLE = "title";
  public static final String DESCRIPTION = "description";
  public static final String URL = "url";
  public static final String EXPIRES = "expires";
  public static final String CREATED_AT = "created_at";

  private static final int DB_VERSION = 1;

  public static final String DELETE_TABLE_APPLICATION =
      "DELETE TABLE IF EXISTS " + ITEMS_TABLE;

  public static final String CREATE_TABLE_APPLICATIONS = "CREATE TABLE "
      + ITEMS_TABLE
      + "("
      + ID
      + " integer primary key autoincrement, "
      + TITLE
      + " TEXT, "
      + DESCRIPTION
      + " TEXT, "
      + URL
      + " TEXT, "
      + EXPIRES
      + " INTEGER, "
      + CREATED_AT
      + " DATETIME DEFAULT CURRENT_TIMESTAMP);";


  public CacheApplicationDB(Context context) {
    super(context, DATABASE_NAME, null, DB_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_TABLE_APPLICATIONS);
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DELETE_TABLE_APPLICATION);
    onCreate(db);
  }

  public static void deleteDataTable(SQLiteDatabase db, String nameTable) {
    db.execSQL("DELETE FROM " + nameTable);
  }
}
