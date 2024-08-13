package com.example.jetpackcomposedemo.ui.screens.welcome

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.ui.components.CustomButton
import com.example.jetpackcomposedemo.ui.components.CustomText
import com.example.jetpackcomposedemo.ui.components.CustomTextField
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WelcomeScreen() {
    WelcomeScreenContent()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun WelcomeScreenContent() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(top = 30.dp)
        )
        {
            CustomButton(
                initialBackgroundColor = Color.Red,
                text = "Button 1",
                textColor = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            {
                print("I am clicked")
            }

            CustomButton(
                initialBackgroundColor = Color.Cyan,
                text = "Button 2",
                textColor = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            {
                print("I am clicked")
            }

            CustomButton(
                initialBackgroundColor = Color.Green,
                text = "Button 3",
                textColor = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                print("I am clicked")
            }

            CustomButton(
                initialBackgroundColor = Color.Yellow,
                text = "Button 4",
                textColor = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                print("I am clicked")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(horizontal = 15.dp)
            ,
            horizontalArrangement = Arrangement.Center

        )
        {
            CustomButton(
                initialBackgroundColor = Color.Red,
                text = "Button 5",
                textColor = Color.Black,
                modifier = Modifier
                    .size(width = 120.dp, height = 50.dp)
                    .padding(5.dp)

            ) {
                print("I am clicked")
            }
            CustomButton(
                initialBackgroundColor = Color.Cyan,
                text = "Button 6",
                textColor = Color.Black,
                modifier = Modifier
                    .size(width = 120.dp, height = 50.dp)
                    .padding(5.dp)

            ) {
                print("I am clicked")
            }

            CustomButton(
                initialBackgroundColor = Color.Green,
                text = "Button 7",
                textColor = Color.Black,
                modifier = Modifier
                    .size(width = 120.dp, height = 50.dp)
                    .padding(5.dp)

            ) {
                print("I am clicked")
            }

        }

        CustomText(text = "Hello World",
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center ,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan) )

        CustomTextField(
            value = "",
            placeHolder = "Enter Text into TextField",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.Green,
            fontWeight = FontWeight.Bold
        )


        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Yellow))
        {
            CustomText(text = "Hello World",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center ,
                modifier = Modifier
                    .background(Color.Cyan)
                    .align(Alignment.TopEnd) )

            CustomButton(
                initialBackgroundColor = Color.Cyan,
                text = "Button 8",
                textColor = Color.Black,
                modifier = Modifier
                    .size(width = 120.dp, height = 50.dp)
                    .align(Alignment.Center)

            ) {
                print("I am clicked")
            }

            CustomTextField(
                value = "",
                placeHolder = "TextField",
                fontSize = 20.sp,
                modifier = Modifier
                    .size(width = 120.dp, height = 60.dp)
                    .align(Alignment.BottomStart),
                backgroundColor = Color.Green,
                fontWeight = FontWeight.Bold
            )


        }

        Canvas(modifier = Modifier
            .size(200.dp)
            .background(Color.Red)) {
            // Draw a filled circle at the center of the canvas
            drawCircle(
                color = Color.White,
                radius = 100f,
                center = Offset(x = size.width / 4, y = size.height / 3),
                style = Stroke(width = 18f)
            )

            drawRect(
                color = Color.White,
                topLeft = Offset(x=250f,y=200f),
                size = size.copy(width = size.width / 2, height = size.height / 2),
                style = Stroke(width = 18f)
            )

        }







    }


    




}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewWelcomeScreenContent() {
    JetpackComposeDemoTheme {
        WelcomeScreenContent()
    }
}

