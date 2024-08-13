package com.example.jetpackcomposedemo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposedemo.ui.screens.welcome.WelcomeScreen
import com.example.jetpackcomposedemo.ui.screens.welcome.WelcomeScreen2
import com.example.jetpackcomposedemo.ui.screens.welcome.WelcomeScreen3
import com.example.jetpackcomposedemo.ui.screens.welcome.WelcomeScreen4
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           //WelcomeScreen()
           //WelcomeScreen2() // LazyColumn
           //WelcomeScreen3() // LazyVerticalGrid
           //WelcomeScreen4() // LazyVerticalStaggeredGrid
        }
    }
}

