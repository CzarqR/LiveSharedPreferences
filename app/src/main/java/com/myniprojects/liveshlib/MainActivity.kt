package com.myniprojects.liveshlib

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myniprojects.liveshlib.databinding.ActivityMainBinding

const val SHARED_PREFERENCES_NAME = "test_app_sh"

class MainActivity : AppCompatActivity()
{
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        val viewModelFactory = MainViewModelFactory(sharedPreferences)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.viewModel = viewModel


        //region  observe live shared preferences

        viewModel.testValueString.observe(this, {
            Log.d("MainActivity", "Observed. testValueString = \"$it\"")
        })

        viewModel.testValueInt.observe(this, {
            Log.d("MainActivity", "Observed. testValueInt = $it")
        })

        viewModel.testValueBoolean.observe(this, {
            Log.d("MainActivity", "Observed. testValueBoolean = $it")
        })

        viewModel.testValueFloat.observe(this, {
            Log.d("MainActivity", "Observed. testValueFloat = $it")
        })

        viewModel.testValueLong.observe(this, {
            Log.d("MainActivity", "Observed. testValueLog = $it")
        })

        viewModel.testValueSet.observe(this, {
            Log.d("MainActivity", "Observed. testValueSet = ${it.joinToString()}")
        })

        //endregion


        //region  errors

        //viewModel.testValueDouble.observe(this, {
        //    Log.d("MainActivity", "Observed. testValueDouble = $it")
        //})

        // Error Unsupported SharedPreferences type. Currently supported types: [Boolean, Int, Long, Float, String, Set<String>]

        //endregion

    }
}
