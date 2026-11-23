package com.sonms.ylog.core.common.util
sealed interface LoadErrorHandleAction {
    data object Retry : LoadErrorHandleAction

    data object Back : LoadErrorHandleAction

    data object NotFound : LoadErrorHandleAction
}
