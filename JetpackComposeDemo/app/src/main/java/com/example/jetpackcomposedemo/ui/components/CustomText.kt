package com.example.jetpackcomposedemo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

@Composable
fun CustomText(
    text: String,
    color: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    textAlign: TextAlign,
    modifier:Modifier
    )
{
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewCustomText()
{
    JetpackComposeDemoTheme {
        CustomText(text = "Hello World",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign =TextAlign.Center ,
            modifier =Modifier.fillMaxWidth()
                .background(Color.Cyan) )
    }
}