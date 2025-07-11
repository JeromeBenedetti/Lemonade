package com.example.lemonade

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LemonadeProcess(modifier: Modifier = Modifier) {
    val steps = listOf<StepData>(LemonTreeStep, LemonSqueezeStep, GlassDrinkStep, RestartStep)

    var currentStepIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val currentStep = steps[currentStepIndex]
        Button(
            onClick = { currentStepIndex = (currentStepIndex + 1) % steps.size },
        ) {
            Image(
                painter = painterResource(currentStep.imageId),
                contentDescription = stringResource(currentStep.contentDescriptionId),
                modifier = modifier
                    .width(120.dp)
                    .background(colorResource(R.color.pale_green)),
                contentScale = ContentScale.Crop,

            )
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(currentStep.textId),
            color = Color.Black,
            fontSize = 18.sp,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeProcess()
}