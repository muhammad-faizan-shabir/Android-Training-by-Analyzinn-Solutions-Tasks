package com.example.jetpackcomposedemo.ui.components

import android.annotation.SuppressLint
import android.widget.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

@SuppressLint("UnrememberedMutableState")
@Composable
fun CustomButton(
    initialBackgroundColor: Color,
    text: String,
    textColor: Color,
    modifier: Modifier,
    onClick:()->Unit
)
{
    val backgroundColor =remember{ mutableStateOf(initialBackgroundColor)}
    Button(
        onClick ={
            backgroundColor.value = if (backgroundColor.value == initialBackgroundColor) Color.Gray else initialBackgroundColor
            onClick()},
        modifier= modifier,
        colors= ButtonDefaults.buttonColors(containerColor=backgroundColor.value)
    )
    {
        Text(text=text,
            color= textColor
        )

    }
}

@Preview
@Composable
fun PreviewCustomButton()
{
    JetpackComposeDemoTheme {
        CustomButton(
            initialBackgroundColor = Color.Red,
            text="Press Me",
            textColor = Color.Black,
            modifier= Modifier.fillMaxWidth().padding(16.dp)
        )
        {
            print("I am clicked")
        }
    }
}