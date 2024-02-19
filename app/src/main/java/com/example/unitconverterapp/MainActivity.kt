package com.example.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.unitconverterapp.compose.BaseScreen
import com.example.unitconverterapp.data.ConverterDatabase
import com.example.unitconverterapp.data.ConvertorRepositoryImpl
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val dao = ConverterDatabase.getInstance(application).converterDAO
        val repository = ConvertorRepositoryImpl(dao)
        val factory = ConverterViewModelFactory(repository)
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BaseScreen(factory = factory)
                }
            }
        }
    }
}
