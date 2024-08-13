package com.example.jetpackcomposedemo.ui.screens.welcome

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.ui.components.CustomButton
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WelcomeScreen4() {
    WelcomeScreenContent4()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun WelcomeScreenContent4()
{
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize()
    )
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
                    .size(width=10.dp, height = num.dp)
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
fun PreviewWelcomeScreenContent4()
{
    JetpackComposeDemoTheme {
        WelcomeScreenContent4()
    }
}