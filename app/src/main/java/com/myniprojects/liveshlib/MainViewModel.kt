package com.myniprojects.liveshlib

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.myniprojects.livesh.liveData
import kotlin.random.Random

// supported values
val TEST_VALUE_STRING = "TEST_VALUE_STRING_KEY" to "default value"
val TEST_VALUE_INT = "TEST_VALUE_INT_KEY" to 0
val TEST_VALUE_BOOLEAN = "TEST_VALUE_BOOLEAN_KEY" to false
val TEST_VALUE_LONG = "TEST_VALUE_LONG_KEY" to 0L
val TEST_VALUE_FLOAT = "TEST_VALUE_FLOAT_KEY" to 0.0f
val TEST_VALUE_SET = "TEST_VALUE_SET_KEY" to setOf("This", "is", "default")

// unsupported value, error test
val TEST_VALUE_DOUBLE = "TEST_VALUE_DOUBLE_KEY" to 123.321

class MainViewModel(
    private val sharedPreferences: SharedPreferences
) : ViewModel()
{
    // supported values
    val testValueString = sharedPreferences.liveData(TEST_VALUE_STRING)
    val testValueInt = sharedPreferences.liveData(TEST_VALUE_INT)
    val testValueBoolean = sharedPreferences.liveData(TEST_VALUE_BOOLEAN)
    val testValueFloat = sharedPreferences.liveData(TEST_VALUE_FLOAT)
    val testValueLong = sharedPreferences.liveData(TEST_VALUE_LONG)
    val testValueSet = sharedPreferences.liveData(TEST_VALUE_SET)

    // unsupported value, error test
    val testValueDouble = sharedPreferences.liveData(TEST_VALUE_DOUBLE)

    fun randomizeValues()
    {
        // set random values to SharedPreferences

        sharedPreferences.edit()
            .putString(testValueString.key, listOf("A", "B", "C", "D", "E", "F", "G").random())
            .putInt(testValueInt.key, (0..1000).random())
            .putBoolean(testValueBoolean.key, listOf(true, false).random())
            .putFloat(testValueFloat.key, Random.nextFloat())
            .putLong(testValueLong.key, (0..1234567890).random().toLong())
            .putStringSet(
                testValueSet.key,
                setOf(listOf("One", "Second").random(), listOf("Three", "Four").random())
            ).apply()
    }
}