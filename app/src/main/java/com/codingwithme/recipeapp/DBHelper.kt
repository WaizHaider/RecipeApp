package com.codingwithme.recipeapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                DRINK_COL + " TEXT," +
                CAT_COL + " TEXT," +
                AREA_COL + " TEXT," +
                INSTRUCT_COL + " TEXT," +
                MEAL_COL + " TEXT," +
                TAG_COL + " TEXT," +
                YOUTUBE_COL + " TEXT," +
                INGRE_COL + " TEXT" + ")")
        db.execSQL(query)
    }
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }
    fun addName(name : String, drink : String, category : String, area: String, instruction: String,
    meal: String, tags: String, youtube: String, ingrediants: String){
        val values = ContentValues()
        values.put(NAME_COl, name)
        values.put(DRINK_COL, drink)
        values.put(CAT_COL, category)
        values.put(AREA_COL, area)
        values.put(INSTRUCT_COL, instruction)
        values.put(MEAL_COL, meal)
        values.put(TAG_COL, tags)
        values.put(YOUTUBE_COL, youtube)
        values.put(INGRE_COL, ingrediants)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
    fun getName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }
    companion object{
        private val DATABASE_NAME = "GEEKS_FOR_GEEKS"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "gfg_table"
        val ID_COL = "id"
        val NAME_COl = "name"
        val DRINK_COL = "drink"
        val CAT_COL = "category"
        val AREA_COL = "area"
        val INSTRUCT_COL = "instruction"
        val MEAL_COL = "meal"
        val TAG_COL = "tags"
        val YOUTUBE_COL = "youtube"
        val INGRE_COL = "ingrediants"
    }
}