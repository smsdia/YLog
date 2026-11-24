package com.sonms.ylog.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * 색상 토큰 모음. 값의 기준은 DESIGN.md이다.
 * 용도(brand 등)는 정하지 않고 화면 코드가 직접 고른다. 사용처: `YLog.colors.primary.violet500`
 */
@Immutable
data class YLogColors(
    val primary: YLogPrimaryColors = YLogPrimaryColors(),
    val neutral: YLogNeutralColors = YLogNeutralColors(),
    val system: YLogSystemColors = YLogSystemColors(),
    val glass: YLogGlassColors = YLogGlassColors(),
)

/** Primary/Violet(브랜드), Primary/Pink(강조), Primary/Peach(보조) 스케일. */
@Immutable
data class YLogPrimaryColors(
    val violet50: Color = Color(0xFFFAF8FC),
    val violet100: Color = Color(0xFFF3F0FF),
    val violet200: Color = Color(0xFFEBE4FF),
    val violet300: Color = Color(0xFFD6C8FF),
    val violet400: Color = Color(0xFFA58BFC),
    val violet500: Color = Color(0xFF7153F5),
    val violet600: Color = Color(0xFF5E3BE6),
    val violet700: Color = Color(0xFF53389E),
    val violet800: Color = Color(0xFF3B2375),
    val violet900: Color = Color(0xFF221834),

    val pink50: Color = Color(0xFFFFF0F5),
    val pink100: Color = Color(0xFFFFE0EC),
    val pink200: Color = Color(0xFFFFB8D2),
    val pink300: Color = Color(0xFFFF80AE),
    val pink400: Color = Color(0xFFFF4D90),
    val pink500: Color = Color(0xFFFF2D78),
    val pink600: Color = Color(0xFFE01863),
    val pink700: Color = Color(0xFFB80A4C),
    val pink800: Color = Color(0xFF8A0035),

    val peach50: Color = Color(0xFFFFF7F2),
    val peach100: Color = Color(0xFFFFEBDD),
    val peach200: Color = Color(0xFFFFD4BA),
    val peach300: Color = Color(0xFFFFB388),
    val peach400: Color = Color(0xFFFA9251),
    val peach500: Color = Color(0xFFF77626),
    val peach600: Color = Color(0xFFD65C13),
    val peach700: Color = Color(0xFFA84206),
    val peach800: Color = Color(0xFF7A2D00),
)

/** Neutral/0 ~ 950. 속성 이름은 숫자로 시작할 수 없어 `n` 접두어를 붙인다. */
@Immutable
data class YLogNeutralColors(
    val n0: Color = Color(0xFFFFFFFF),
    val n50: Color = Color(0xFFFAF8FB),
    val n100: Color = Color(0xFFEDE8F5),
    val n200: Color = Color(0xFFDDD7E7),
    val n300: Color = Color(0xFFCDD0D5),
    val n400: Color = Color(0xFFB1B6BE),
    val n500: Color = Color(0xFF8A949E),
    val n600: Color = Color(0xFF6E6480),
    val n700: Color = Color(0xFF454C53),
    val n800: Color = Color(0xFF31363D),
    val n900: Color = Color(0xFF1E152A),
    val n950: Color = Color(0xFF110C18),
)

/** System/Success, Warning, Danger, Info. 단계는 50, 200, 400, 600, 800만 있다. */
@Immutable
data class YLogSystemColors(
    val success50: Color = Color(0xFFEFFCF3),
    val success200: Color = Color(0xFFB5F2C4),
    val success400: Color = Color(0xFF43D66A),
    val success600: Color = Color(0xFF1EAC44),
    val success800: Color = Color(0xFF126829),

    val warning50: Color = Color(0xFFFFF7ED),
    val warning200: Color = Color(0xFFFFD7A8),
    val warning400: Color = Color(0xFFFF9B38),
    val warning600: Color = Color(0xFFE0740E),
    val warning800: Color = Color(0xFF8C4300),

    val danger50: Color = Color(0xFFFFF0F2),
    val danger200: Color = Color(0xFFFFBDC6),
    val danger400: Color = Color(0xFFFF697C),
    val danger600: Color = Color(0xFFE6203D),
    val danger800: Color = Color(0xFF8A0C1E),

    val info50: Color = Color(0xFFF3F0FF),
    val info200: Color = Color(0xFFD6C8FF),
    val info400: Color = Color(0xFFA58BFC),
    val info600: Color = Color(0xFF7153F5),
    val info800: Color = Color(0xFF3B2375),
)

/** 반투명 글래스 표면과 딤, 그림자용 알파 토큰. 접미어 숫자가 불투명도(%)이다. */
@Immutable
data class YLogGlassColors(
    val glassWhite80: Color = Color(0xCCFFFFFF),
    val glassWhite50: Color = Color(0x80FFFFFF),
    val glassWhite20: Color = Color(0x33FFFFFF),
    val dimBlack70: Color = Color(0xB3000000),
    val dimBlack40: Color = Color(0x66000000),
    val shadowBlack10: Color = Color(0x1A000000),
)
