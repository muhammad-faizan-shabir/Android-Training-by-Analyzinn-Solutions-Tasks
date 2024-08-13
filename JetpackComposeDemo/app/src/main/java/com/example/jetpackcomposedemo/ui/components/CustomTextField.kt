package com.example.jetpackcomposedemo.ui.components

import android.os.Build
import android.webkit.WebSettings
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CustomTextField(
    value: String,
    placeHolder: String,
    modifier:Modifier,
    fontSize: TextUnit,
    fontWeight:FontWeight,
    backgroundColor:Color
)
{
    var text by remember { mutableStateOf(value) }
    TextField(value = text,
        onValueChange = {newValue-> text=newValue},
        placeholder = { Text(text = placeHolder)},
        modifier = modifier,
        textStyle= androidx.compose.ui.text.TextStyle(fontSize =fontSize, fontWeight = fontWeight),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = backgroundColor
            // backgroundColor = Color.LightGray, // Use this if `containerColor` becomes obsolete
        )
    )


}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewCustomTextField()
{
    JetpackComposeDemoTheme {
        CustomTextField(
            value = "",
            placeHolder = "Enter Text",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.Green,
            fontWeight = FontWeight.Bold
        )

    }
}