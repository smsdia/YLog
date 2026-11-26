package com.sonms.ylog.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import ylog.core.designsystem.generated.resources.Res
import ylog.core.designsystem.generated.resources.pretendard_bold
import ylog.core.designsystem.generated.resources.pretendard_medium
import ylog.core.designsystem.generated.resources.pretendard_regular
import ylog.core.designsystem.generated.resources.pretendard_semibold

/**
 * Figma 텍스트 스타일(DESIGN.md)과 이름이 일대일로 대응하는 토큰 모음.
 * 사용처: `YLog.typography.bodyLarge`
 */
@Immutable
data class YLogTypography(
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val headingLarge: TextStyle,
    val headingMedium: TextStyle,
    val headingSmall: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val bodyLarge: TextStyle,
    val bodyLargeMedium: TextStyle,
    val bodyLargeStrong: TextStyle,
    val bodySmall: TextStyle,
    val labelRegular: TextStyle,
    val labelMedium: TextStyle,
    val labelStrong: TextStyle,
    val captionRegular: TextStyle,
    val captionMedium: TextStyle,
    val captionStrong: TextStyle,
    val microRegular: TextStyle,
    val microMedium: TextStyle,
)

@Composable
fun ylogFontFamily(): FontFamily = FontFamily(
    Font(Res.font.pretendard_regular, FontWeight.Normal),
    Font(Res.font.pretendard_medium, FontWeight.Medium),
    Font(Res.font.pretendard_semibold, FontWeight.SemiBold),
    Font(Res.font.pretendard_bold, FontWeight.Bold),
)

fun ylogTypography(fontFamily: FontFamily): YLogTypography {
    // 자간은 전 스타일 0sp이므로 TextStyle 기본값을 그대로 쓴다
    fun style(size: Int, lineHeight: Int, weight: Int) = TextStyle(
        fontFamily = fontFamily,
        fontSize = size.sp,
        lineHeight = lineHeight.sp,
        fontWeight = FontWeight(weight),
    )

    return YLogTypography(
        displayLarge = style(40, 48, 600),
        displayMedium = style(32, 40, 700),
        headingLarge = style(24, 30, 700),
        headingMedium = style(20, 26, 700),
        headingSmall = style(18, 24, 700),
        titleLarge = style(16, 22, 700),
        titleMedium = style(16, 22, 600),
        titleSmall = style(16, 22, 500),
        bodyLarge = style(14, 20, 400),
        bodyLargeMedium = style(14, 20, 500),
        bodyLargeStrong = style(14, 20, 600),
        bodySmall = style(13, 18, 400),
        labelRegular = style(12, 16, 400),
        labelMedium = style(12, 16, 500),
        labelStrong = style(12, 16, 600),
        captionRegular = style(11, 15, 400),
        captionMedium = style(11, 15, 500),
        captionStrong = style(11, 15, 600),
        microRegular = style(10, 14, 400),
        microMedium = style(10, 14, 500),
    )
}
