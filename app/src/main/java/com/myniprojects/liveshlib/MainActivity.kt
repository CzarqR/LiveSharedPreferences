package com.myniprojects.liveshlib

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.myniprojects.livesh.liveData
import java.util.*

const val SHARED_PREFERENCES_NAME = "test_app_sh"

val TEST_VALUE_STRING = "TEST_VALUE_STRING_KEY" to "default value"
val TEST_VALUE_INT = "TEST_VALUE_INT_KEY" to 420
val TEST_VALUE_BOOLEAN = "TEST_VALUE_BOOLEAN_KEY" to false

class MainActivity : AppCompatActivity()
{
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        viewModel = MainViewModel(sharedPreferences)

        //observe live shared preferences
        viewModel.testValueString.observe(this, {
            Log.d("MainActivity", "Observed. testValueString = \"$it\"")
        })

        viewModel.testValueInt.observe(this, {
            Log.d("MainActivity", "Observed. testValueInt = \"$it\"")
        })


        viewModel.testValueBoolean.observe(this, {
            Log.d("MainActivity", "Observed. testValueBoolean = \"$it\"")
        })

        // change value after 5 seconds to check if observer function is fired
        Timer().schedule(
            object : TimerTask()
            {
                override fun run()
                {
                    viewModel.changeValues()
                }
            }, 5000
        )
    }
}

// simple example of ViewModel
class MainViewModel(
    private val sharedPreferences: SharedPreferences
)
{
    val testValueString = sharedPreferences.liveData(TEST_VALUE_STRING)
    val testValueInt = sharedPreferences.liveData(TEST_VALUE_INT)
    val testValueBoolean = sharedPreferences.liveData(TEST_VALUE_BOOLEAN)

    fun changeValues()
    {
        sharedPreferences.edit().putString(testValueString.key, "New value").apply()
        sharedPreferences.edit().putInt(testValueInt.key, 1337).apply()
        sharedPreferences.edit().putBoolean(testValueBoolean.key, true).apply()
    }
}