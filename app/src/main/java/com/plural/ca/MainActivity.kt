package com.plural.ca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count: Int = (0..10).random()
        val songsFound = resources.getQuantityString(R.plurals.numberOfSongsAvailable, count, count)

        quantity.text = songsFound

        val df: DateFormat = SimpleDateFormat("HH")
        val time: String = df.format(Calendar.getInstance().time)

        timeView.text = resources.getQuantityString(
            R.plurals.timeOfTheDay,
            getTime(time.toInt())
        )
    }

    private fun getTime(time: Int): Int {
        return when {
            time > 19 -> { 3 }
            time > 16 -> { 2 }
            time > 11 -> { 1 }
            else -> { 0 }
        }
    }
}
