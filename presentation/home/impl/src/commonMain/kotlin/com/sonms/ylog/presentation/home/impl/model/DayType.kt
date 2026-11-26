package com.sonms.ylog.presentation.home.impl.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.sonms.ylog.core.designsystem.theme.YLog

enum class DayType {
    SUN,
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT;

    @Composable
    fun textColor(): Color = with(YLog.colors) {
        when (this@DayType) {
            SUN -> system.danger600
            SAT -> system.info600
            else -> neutral.n900
        }
    }
}
