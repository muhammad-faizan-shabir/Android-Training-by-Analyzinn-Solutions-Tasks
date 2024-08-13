package com.example.jetpackcomposedemo.ui.screens.welcome

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.ui.components.CustomButton
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WelcomeScreen2() {
    WelcomeScreenContent2()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun WelcomeScreenContent2()
{
    LazyColumn(modifier= Modifier.fillMaxSize().padding(top = 30.dp))
    {
        items(100)
        {
            buttonNo->
            val num=buttonNo+1
            CustomButton(
            initialBackgroundColor = Color.Cyan,
            text = "Button $num",
            textColor = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        {
            print("I am clicked")
        }

        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewWelcomeScreenContent2(){
    JetpackComposeDemoTheme {
        WelcomeScreenContent2()
    }
}