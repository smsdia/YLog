package com.sonms.ylog.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.sonms.ylog.core.navigation.NavigationState
import com.sonms.ylog.core.navigation.Navigator
import com.sonms.ylog.core.navigation.rememberNavigationState
import com.sonms.ylog.navigation.MainTab
import com.sonms.ylog.navigation.YLogNavConfig
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Stable
class YLogAppState(val navigationState: NavigationState) {
    val navigator = Navigator(navigationState)

    val tabs: ImmutableList<MainTab> = MainTab.entries.toImmutableList()

    /** 화면에 보이는 키가 탭의 루트이면 해당 탭, 아니면 null이다. null이면 바텀 바를 숨긴다. */
    val currentTab: MainTab?
        get() = navigationState.currentKey.let { key -> MainTab.entries.find { it.route == key } }

    /** 탭 전환은 바텀 바에서만 호출한다. 이미 선택된 탭이면 그 탭의 루트로 돌아간다. */
    fun navigateToTab(tab: MainTab) = navigator.navigate(tab.route)
}

@Composable
fun rememberYLogAppState(): YLogAppState {
    val navigationState = rememberNavigationState(
        configuration = YLogNavConfig,
        startKey = MainTab.entries.first().route,
        topLevelKeys = MainTab.entries.map { it.route }.toSet(),
    )
    return remember(navigationState) { YLogAppState(navigationState = navigationState) }
}
