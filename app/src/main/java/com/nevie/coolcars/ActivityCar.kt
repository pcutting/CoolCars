package com.nevie.coolcars

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nevie.coolcars.Model.Car
import kotlinx.android.synthetic.main.activity_car.*

class ActivityCar : AppCompatActivity() {

    companion object {
        private const val KEY = "CAR"

        fun createIntent(context: Context, car : Car) : Intent {
            val intent = Intent(context, ActivityCar::class.java)
            intent.putExtra(KEY, car)
            return intent
        }
    }

    private lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)


        car = intent.extras?.getParcelable(KEY) ?: Car()
        Log.d("ActivityCar.kt", "Recieved car: $car")

        //var car: Car = Car().getExample1()
        var backButton = findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            goBack()
        }


        //var imageResource = findViewById<Drawable>()
        var image = findViewById<ImageView>(R.id.imageView)
        var make = findViewById<TextView>(R.id.make_text)
        var model = findViewById<TextView>(R.id.model_text)
        var zeroTo60 = findViewById<TextView>(R.id.zero_to_60_text)
        var hp = findViewById<TextView>(R.id.hp_text)
        var mpg = findViewById<TextView>(R.id.mpg_city_highway_text)
        var year = findViewById<TextView>(R.id.year_text)

        make.text = car.make
        model.text = car.model
        zeroTo60.text = car.zeroToSixty.toString()
        hp.text = car.hp.toString()
        mpg.text = "${car.rangeCity} / ${car.rangeHighway}"
        year.text = car.year.toString()

        if (car.make.toLowerCase() == "jaguar" ) {
            imageView.setImageResource(R.drawable.jagwar_big)
        } else {
            imageView.setImageResource(R.drawable.mustang_big)
        }
    }


    private fun goBack() {
        onBackPressed()
    }

}