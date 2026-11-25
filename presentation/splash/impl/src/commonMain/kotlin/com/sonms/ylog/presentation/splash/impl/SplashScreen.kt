package com.sonms.ylog.presentation.splash.impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sonms.ylog.core.designsystem.theme.YLogTheme

@Composable
internal fun SplashRoute() {
    SplashScreen()
}

@Composable
private fun SplashScreen() {
}

@Composable
@Preview
private fun SplashScreenPreview() {
    YLogTheme {
        SplashScreen()
    }
}
