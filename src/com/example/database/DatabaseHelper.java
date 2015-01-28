package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "mydata.db";
	private static final int DATABASE_VERSION = 2;
	private static final String TABLE_NAME ="bbs";
	private static final String ID = "id";
	private static final String CREATED= "created";
	private static final String COMMENT = "comment";

	DatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	public void onCreate(SQLiteDatabase db){
		String query = "create table " + TABLE_NAME + "(" + ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," + CREATED + " TEXT,"+ COMMENT + " TEXT);";
		db.execSQL(query);
		}

	public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
		db.execSQL("drop table if exists " + TABLE_NAME);
		onCreate(db);
	}

}
