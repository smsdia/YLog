package com.sonms.ylog.presentation.home.impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sonms.ylog.core.designsystem.theme.YLogTheme

@Composable
fun HomeRoute() {
    HomeScreen()
}

@Composable
private fun HomeScreen() {
}

@Composable
@Preview
private fun HomeScreenPreview() {
    YLogTheme {
        HomeScreen()
    }
}
