package com.byted.camp.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public class TodoDbHelper extends SQLiteOpenHelper {

    // TODO 定义数据库名、版本；创建数据库
    private static final String DB_NAME = "todolist.db";
    private static final int DB_VERSION = 1;

    public TodoDbHelper(Context context) {
        super(context, "todolist", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoContract.SQL_CREATE_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            if(oldVersion == 0) {
                db.execSQL(TodoContract.SQL_ADD_PRIORITY_COLUMN);
            }
        }
    }

}
