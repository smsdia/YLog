package com.sonms.ylog.navigation

import com.sonms.ylog.core.navigation.MainRouteTab
import com.sonms.ylog.core.navigation.Route
import com.sonms.ylog.presentation.home.api.Home

// TODO 탭이 확정되면 contentDescription을 StringResource(_a11y 키)로 바꾸고, YLogApp의 임시 라벨도 함께 정리한다
// 탭을 추가하려면 presentation 모듈의 MainRouteTab 라우트를 여기에 등록한다
enum class MainTab(
    val route: MainRouteTab,
    val contentDescription: String
) {
    HOME(
        route = Home,
        contentDescription = "홈",
    ),
    ;

    companion object {
        fun find(predicate: (Route) -> Boolean): MainTab? = entries.find { predicate(it.route) }

        fun contains(predicate: (Route) -> Boolean): Boolean = entries.any { predicate(it.route) }
    }
}
