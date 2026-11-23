package com.sonms.ylog.core.trigger

import androidx.compose.runtime.staticCompositionLocalOf
import com.sonms.ylog.core.trigger.model.GlobalUiEventHolder

val LocalGlobalUiEventTrigger = staticCompositionLocalOf<GlobalUiEventHolder> {
    error("No GlobalUiEvent Trigger provided")
}
