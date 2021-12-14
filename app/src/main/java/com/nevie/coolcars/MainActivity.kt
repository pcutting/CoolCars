package com.nevie.coolcars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.nevie.coolcars.Model.Car

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var car : Car = Car().getExample1()
        var car2 : Car = Car().getExample2()


        val cardFirstCar = findViewById<CardView>(R.id.card_view)
        cardFirstCar.setOnClickListener{
            openActivityCar(car)
        }
        val cardSecondCar = findViewById<CardView>(R.id.card_view_2)
        cardSecondCar.setOnClickListener {
            openActivityCar(car2)

        }

        var make = findViewById<TextView>(R.id.make_text)
        var model  = findViewById<TextView>(R.id.model_text)
        var zeroTo60 = findViewById<TextView>(R.id.zero_to_60_text)
        var hp = findViewById<TextView>(R.id.hp_text)
        var mpg = findViewById<TextView>(R.id.mpg_city_highway_text)
        var  year = findViewById<TextView>(R.id.year_text)
        var image = findViewById<ImageView>(R.id.imageView)

        //var imageFile = findt
        //image.setImageResource(R.drawable.)
        //image.drawable.s
        make.text = car.make
        model.text = car.model
        zeroTo60.text = car.zeroToSixty.toString()
        hp.text = car.hp.toString()
        mpg.text = "${car.rangeCity} / ${car.rangeHighway}"
        year.text = car.year.toString()



        var make2 = findViewById<TextView>(R.id.make_text2)
        var model2  = findViewById<TextView>(R.id.model_text2)
        var zeroTo602 = findViewById<TextView>(R.id.zero_to_60_text2)
        var hp2 = findViewById<TextView>(R.id.hp_text2)
        var mpg2 = findViewById<TextView>(R.id.mpg_city_highway_text2)
        var  year2 = findViewById<TextView>(R.id.year_text2)

        make2.text = car2.make
        model2.text = car2.model
        zeroTo602.text = car2.zeroToSixty.toString()
        hp2.text = car2.hp.toString()
        mpg2.text = "${car2.rangeCity} / ${car.rangeHighway}"
        year2.text = car2.year.toString()






    }
    private fun openActivityCar(aCar: Car) {
        Log.d("MainActivity", "open car detail window.")
        val intent = ActivityCar.createIntent(this, aCar)
        startActivity(intent)
    }


}
