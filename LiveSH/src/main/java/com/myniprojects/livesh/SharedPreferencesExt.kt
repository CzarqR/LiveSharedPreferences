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

// get T from pair with default value from pair

fun SharedPreferences.getBoolean(pair: Pair<String, Boolean>): Boolean
{
    return getBoolean(pair.first, pair.second)
}

fun SharedPreferences.getInt(pair: Pair<String, Int>): Int
{
    return getInt(pair.first, pair.second)
}

fun SharedPreferences.getLong(pair: Pair<String, Long>): Long
{
    return getLong(pair.first, pair.second)
}

fun SharedPreferences.getFloat(pair: Pair<String, Float>): Float
{
    return getFloat(pair.first, pair.second)
}

fun SharedPreferences.getString(pair: Pair<String, String>): String?
{
    return getString(pair.first, pair.second)
}

fun SharedPreferences.getStringSet(pair: Pair<String, Set<String>>): Set<String>?
{
    return getStringSet(pair.first, pair.second)
}


// get T from pair with given default value

fun SharedPreferences.getBoolean(pair: Pair<String, Boolean>, default: Boolean): Boolean
{
    return getBoolean(pair.first, default)
}

fun SharedPreferences.getInt(pair: Pair<String, Int>, default: Int): Int
{
    return getInt(pair.first, default)
}

fun SharedPreferences.getLong(pair: Pair<String, Long>, default: Long): Long
{
    return getLong(pair.first, default)
}

fun SharedPreferences.getFloat(pair: Pair<String, Float>, default: Float): Float
{
    return getFloat(pair.first, default)
}

fun SharedPreferences.getString(pair: Pair<String, String>, default: String?): String?
{
    return getString(pair.first, default)
}

fun SharedPreferences.getStringSet(
    pair: Pair<String, Set<String>>,
    default: Set<String>?
): Set<String>?
{
    return getStringSet(pair.first, default)
}

// put value by pair with given value

fun SharedPreferences.Editor.putBoolean(
    pair: Pair<String, Boolean>,
    value: Boolean
): SharedPreferences.Editor
{
    return putBoolean(pair.first, value)
}


fun SharedPreferences.Editor.putInt(
    pair: Pair<String, Int>,
    value: Int
): SharedPreferences.Editor
{
    return putInt(pair.first, value)
}


fun SharedPreferences.Editor.putLong(
    pair: Pair<String, Long>,
    value: Long
): SharedPreferences.Editor
{
    return putLong(pair.first, value)
}


fun SharedPreferences.Editor.putFloat(
    pair: Pair<String, Float>,
    value: Float
): SharedPreferences.Editor
{
    return putFloat(pair.first, value)
}


fun SharedPreferences.Editor.putString(
    pair: Pair<String, String>,
    value: String?
): SharedPreferences.Editor
{
    return putString(pair.first, value)
}


fun SharedPreferences.Editor.putStringSet(
    pair: Pair<String, Set<String>?>,
    value: Set<String>?
): SharedPreferences.Editor
{
    return putStringSet(pair.first, value)
}


// put value by pair with default value from pair

fun SharedPreferences.Editor.putBoolean(
    pair: Pair<String, Boolean>
): SharedPreferences.Editor
{
    return putBoolean(pair.first, pair.second)
}


fun SharedPreferences.Editor.putInt(
    pair: Pair<String, Int>
): SharedPreferences.Editor
{
    return putInt(pair.first, pair.second)
}


fun SharedPreferences.Editor.putLong(
    pair: Pair<String, Long>
): SharedPreferences.Editor
{
    return putLong(pair.first, pair.second)
}


fun SharedPreferences.Editor.putFloat(
    pair: Pair<String, Float>
): SharedPreferences.Editor
{
    return putFloat(pair.first, pair.second)
}


fun SharedPreferences.Editor.putString(
    pair: Pair<String, String>
): SharedPreferences.Editor
{
    return putString(pair.first, pair.second)
}


fun SharedPreferences.Editor.putStringSet(
    pair: Pair<String, Set<String>?>
): SharedPreferences.Editor
{
    return putStringSet(pair.first, pair.second)
}

