package com.sonms.ylog.presentation.splash.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.sonms.ylog.core.navigation.Navigator
import com.sonms.ylog.presentation.splash.api.Splash

fun EntryProviderScope<NavKey>.splashEntry(navigator: Navigator) {
    entry<Splash> {
        SplashRoute()
    }
}
