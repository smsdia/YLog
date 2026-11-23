package com.sonms.ylog.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import coil3.compose.setSingletonImageLoaderFactory
import com.sonms.ylog.core.designsystem.theme.YLogTheme
import com.sonms.ylog.di.AppGraph
import dev.zacsweers.metrox.viewmodel.LocalMetroViewModelFactory

/** 모든 플랫폼이 거치는 공통 진입점: DI, 이미지 로더, 테마를 주입하고 [YLogApp]을 그린다. */
@Composable
fun YLogRoot(appGraph: AppGraph) {
    setSingletonImageLoaderFactory { appGraph.imageLoader }

    val appState = rememberYLogAppState()

    CompositionLocalProvider(
        LocalMetroViewModelFactory provides appGraph.metroViewModelFactory,
    ) {
        YLogTheme {
            YLogApp(appState = appState)
        }
    }
}
