package com.myniprojects.livesh

import android.content.SharedPreferences

fun <T> SharedPreferences.liveData(
    key: String,
    defValue: T
): LiveSharedPreferences<T>
{
    return LiveSharedPreferences(key, defValue, this)
}

fun <T> SharedPreferences.liveData(
    pair: Pair<String, T>
): LiveSharedPreferences<T>
{
    return LiveSharedPreferences(pair, this)
}