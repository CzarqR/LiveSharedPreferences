package com.myniprojects.livesh

import android.content.SharedPreferences
import androidx.lifecycle.LiveData

class LiveSharedPreferences<T>(
    val key: String,
    val defValue: T,
    private val sharedPrefs: SharedPreferences
) : LiveData<T>()
{

    constructor(
        pair: Pair<String, T>, sharedPrefs: SharedPreferences
    ) : this(pair.first, pair.second, sharedPrefs)

    private val preferenceChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (key == this.key)
            {
                value = getValueFromPreferences()
            }
        }


    @Suppress("UNCHECKED_CAST")
    private fun getValueFromPreferences(): T
    {
        when (defValue)
        {
            is Boolean ->
            {
                return sharedPrefs.getBoolean(key, defValue) as T
            }
            is Int ->
            {
                return sharedPrefs.getInt(key, defValue) as T
            }
            is Long ->
            {
                return sharedPrefs.getLong(key, defValue) as T
            }
            is String ->
            {
                return (sharedPrefs.getString(key, defValue) ?: defValue) as T
            }
            is Float ->
            {
                return sharedPrefs.getFloat(key, defValue) as T
            }
            //is Set<String>?->
            //{
            //    return sharedPrefs.getStringSet(key, defValue) as T
            //}
            else ->
            {
                throw IllegalArgumentException("Unsupported SharedPreferences type. Currently supported types: [Boolean, Int, Long, Float, String]")
            }
        }
    }

    override fun onActive()
    {
        super.onActive()
        value = getValueFromPreferences()
        sharedPrefs.registerOnSharedPreferenceChangeListener(preferenceChangeListener)
    }

    override fun onInactive()
    {
        sharedPrefs.unregisterOnSharedPreferenceChangeListener(preferenceChangeListener)
        super.onInactive()
    }
}