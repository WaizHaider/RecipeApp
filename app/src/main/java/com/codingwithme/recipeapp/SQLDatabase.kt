package com.codingwithme.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_show_dbdata.*
import kotlinx.android.synthetic.main.activity_sqldatabase.*
import kotlinx.android.synthetic.main.activity_sqldatabase.drink

class SQLDatabase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqldatabase)
        back.setOnClickListener{
            val db= DBHelper(this,null)

            // creating variables for values
            // in name and age edit texts
            val meal = Meal.text.toString()
            val Drink = drink.text.toString()
            val category = Category.text.toString()
            val area = Area.text.toString()
            val instruction = Instruction.text.toString()
            val mealthumb = Mealthumb.text.toString()
            val tag = Tag.text.toString()
            val youtube = Youtube.text.toString()
            val ingrenMeasure = IngrenMeasure.text.toString()

            // calling method to add
            // name to our database
            db.addName(
                meal,
                Drink,
                category,
                area,
                instruction,
                mealthumb,
                tag,
                youtube,
                ingrenMeasure
            )

            // Toast to message on the screen
            Toast.makeText(this, meal + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            Meal.text.clear()
            drink.text.clear()
            Category.text.clear()
            Area.text.clear()
            Instruction.text.clear()
            Mealthumb.text.clear()
            Tag.text.clear()
            Youtube.text.clear()
            IngrenMeasure.text.clear()
            var intent = Intent(this@SQLDatabase, ShowDBData::class.java)
            startActivity(intent)
            finish()
        }
    }
}