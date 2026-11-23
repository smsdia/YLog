package com.sonms.ylog.presentation.home.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.sonms.ylog.core.navigation.Navigator
import com.sonms.ylog.presentation.home.api.Home

fun EntryProviderScope<NavKey>.homeEntry(navigator: Navigator) {
    entry<Home> {
        HomeRoute()
    }
}
