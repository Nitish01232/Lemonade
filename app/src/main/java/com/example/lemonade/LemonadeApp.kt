package com.example.lemonade

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

    var step by rememberSaveable { mutableStateOf(LemonadeStep.TREE) }
    var squeezeCount by rememberSaveable { mutableStateOf(0) }
    var squeezeTarget by rememberSaveable { mutableStateOf(0) }

    when (step) {

        LemonadeStep.TREE -> {
            LemonadeScreen(
                imageRes = R.drawable.lemon_tree,
                textRes = R.string.Lemon_tree,
                onClick = {
                    squeezeTarget = (4..6).random()
                    squeezeCount = 0
                    step = LemonadeStep.SQUEEZE
                }
            )
        }

        LemonadeStep.SQUEEZE -> {
            LemonadeScreen(
                imageRes = R.drawable.lemon_squeeze,
                textRes = R.string.Lemon,
                onClick = {
                    squeezeCount++
                    if (squeezeCount >= squeezeTarget) {
                        step = LemonadeStep.DRINK
                    }
                }
            )
        }

        LemonadeStep.DRINK -> {
            LemonadeScreen(
                imageRes = R.drawable.lemon_drink,
                textRes = R.string.Glass_of_lemonade,
                onClick = {
                    step = LemonadeStep.RESTART
                }
            )
        }

        LemonadeStep.RESTART -> {
            LemonadeScreen(
                imageRes = R.drawable.lemon_restart,
                textRes = R.string.Empty_glass,
                onClick = {
                    step = LemonadeStep.TREE
                }
            )
        }
    }
}
