package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                AllScreens()
            }
        }
    }
}

@Composable
fun AllScreens(modifier: Modifier = Modifier){
    var currentStep by remember { mutableStateOf(  1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var randomNumber by remember { mutableStateOf(0) }


    when(currentStep){

        1 -> {
                Screen_one(
                    modifier = modifier,
                    onImageClick = {
                        randomNumber = (4..6).random()
                        squeezeCount = 0
                        currentStep++
                    }
                )
        }2 -> {
                Screen_two (
                    modifier = modifier,
                    onImageClick = {
                        squeezeCount++
                        if (squeezeCount == randomNumber){
                            currentStep++
                        }
                    }
                )
        }3 -> {
                Screen_three(
                    modifier = modifier,
                    onImageClick = {
                        currentStep++
                    }
                )
        }4 -> {
                Screen_four(
                    modifier = modifier,
                    onImageClick = {
                        currentStep++
                        if(currentStep > 4){currentStep = 1}
                    }
                )
        }

    }
}

@Composable
fun Screen_one(modifier: Modifier, onImageClick: () -> Unit){
    Column (
            modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.lemon_tree),
            contentDescription = "First Screen",
            modifier = Modifier.clickable(onClick = onImageClick)
        )
        Text(
            text = stringResource(R.string.Lemon_tree)
        )
    }
}@Composable
fun Screen_two(modifier: Modifier, onImageClick: () -> Unit){
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.lemon_squeeze),
            contentDescription = "First Screen",
            modifier = Modifier.clickable(onClick = onImageClick)
        )
        Text(
            text = stringResource(R.string.Lemon)
        )
    }
}
@Composable
fun Screen_three(modifier: Modifier, onImageClick: () -> Unit){
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.lemon_drink),
            contentDescription = "First Screen",
            modifier = Modifier.clickable(onClick = onImageClick)
        )
        Text(
            text = stringResource(R.string.Glass_of_lemonade)
        )
    }
}
@Composable
fun Screen_four(modifier: Modifier, onImageClick: () -> Unit){
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.lemon_restart),
            contentDescription = "First Screen",
            modifier = Modifier.clickable(onClick = onImageClick)
        )
        Text(
            text = stringResource(R.string.Empty_glass)
        )
    }
}

@Preview
@Composable
fun LemonadeApp(){
    AllScreens()
}