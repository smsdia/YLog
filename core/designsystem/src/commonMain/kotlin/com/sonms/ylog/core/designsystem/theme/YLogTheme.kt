package com.sonms.ylog.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalYLogColors = staticCompositionLocalOf<YLogColors> {
    error("YLogTheme 안에서만 YLog.colors를 쓸 수 있습니다")
}
private val LocalYLogTypography = staticCompositionLocalOf<YLogTypography> {
    error("YLogTheme 안에서만 YLog.typography를 쓸 수 있습니다")
}

/** 사용처: `YLog.colors.primary.violet500`, `YLog.typography.bodyLarge` */
object YLog {
    val colors: YLogColors
        @Composable @ReadOnlyComposable
        get() = LocalYLogColors.current
    val typography: YLogTypography
        @Composable @ReadOnlyComposable
        get() = LocalYLogTypography.current
}

@Composable
fun YLogTheme(content: @Composable () -> Unit) {
    val fontFamily = ylogFontFamily()
    val typography = remember(fontFamily) { ylogTypography(fontFamily) }
    val colors = remember { YLogColors() }

    CompositionLocalProvider(
        LocalYLogColors provides colors,
        LocalYLogTypography provides typography,
    ) {
        // 메인 컬러 확정 전이라 primary 계열은 Material 기본값이다. 확정 후 연결한다.
        MaterialTheme(
            colorScheme = lightColorScheme(
                background = colors.neutral.n50,
                surface = colors.neutral.n0,
                onBackground = colors.neutral.n900,
                onSurface = colors.neutral.n900,
            ),
            content = content,
        )
    }
}
