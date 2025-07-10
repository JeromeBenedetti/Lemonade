package com.example.lemonade

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LemonadeProcess(modifier: Modifier = Modifier) {
    val steps = listOf<StepData>(LemonTreeStep, LemonSqueezeStep, GlassDrinkStep, RestartStep)

    var currentStepIndex by remember { mutableIntStateOf(0) }

    Button(
        onClick = {
            currentStepIndex = (currentStepIndex + 1) % steps.size
        },
        modifier = modifier.fillMaxWidth(),

        ) {
        val currentStep = steps[currentStepIndex]
        Step(
            modifier = modifier,
            stepData = currentStep,
        )
    }
}


@Composable
internal fun Step(
    modifier: Modifier = Modifier,
    stepData: StepData = LemonTreeStep,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(stepData.imageId),
            contentDescription = stringResource(stepData.contentDescriptionId),
            modifier = modifier.aspectRatio(1f).width(5.dp),
            contentScale = ContentScale.Companion.Crop

        )
        Spacer(Modifier.Companion.height(16.dp))
        Text(
            text = stringResource(stepData.textId),
            color = Color.Companion.Black,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeProcess(Modifier.Companion.fillMaxSize())
}