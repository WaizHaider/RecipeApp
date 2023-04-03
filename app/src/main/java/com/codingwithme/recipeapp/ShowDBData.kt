package com.codingwithme.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingwithme.recipeapp.R
import kotlinx.android.synthetic.main.activity_show_dbdata.*
import kotlinx.android.synthetic.main.activity_sqldatabase.*

class ShowDBData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_dbdata)
        val db = DBHelper(this, null)
        val cursor = db.getName()
        cursor!!.moveToFirst()
        meal.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
        drinks.append(cursor.getString(cursor.getColumnIndex(DBHelper.DRINK_COL)) + "\n")
        areas.append(cursor.getString(cursor.getColumnIndex(DBHelper.AREA_COL)) + "\n")
        instructions.append(cursor.getString(cursor.getColumnIndex(DBHelper.INSTRUCT_COL)) + "\n")
        mealthumbs.append(cursor.getString(cursor.getColumnIndex(DBHelper.MEAL_COL)) + "\n")
        tagss.append(cursor.getString(cursor.getColumnIndex(DBHelper.TAG_COL)) + "\n")
        youtubes.append(cursor.getString(cursor.getColumnIndex(DBHelper.YOUTUBE_COL)) + "\n")
        ingrediants.append(cursor.getString(cursor.getColumnIndex(DBHelper.INGRE_COL)) + "\n")

        // moving our cursor to next
        // position and appending values
        while(cursor.moveToNext()){
            meal.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
            drinks.append(cursor.getString(cursor.getColumnIndex(DBHelper.DRINK_COL)) + "\n")
            areas.append(cursor.getString(cursor.getColumnIndex(DBHelper.AREA_COL)) + "\n")
            instructions.append(cursor.getString(cursor.getColumnIndex(DBHelper.INSTRUCT_COL)) + "\n")
            mealthumbs.append(cursor.getString(cursor.getColumnIndex(DBHelper.MEAL_COL)) + "\n")
            tagss.append(cursor.getString(cursor.getColumnIndex(DBHelper.TAG_COL)) + "\n")
            youtubes.append(cursor.getString(cursor.getColumnIndex(DBHelper.YOUTUBE_COL)) + "\n")
            ingrediants.append(cursor.getString(cursor.getColumnIndex(DBHelper.INGRE_COL)) + "\n")
        }

        // at last we close our cursor
        cursor.close()
        backto.setOnClickListener{
            var intent = Intent(this@ShowDBData, OptionMenu::class.java)
            startActivity(intent)
            finish()
        }
    }
}