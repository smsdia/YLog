package com.sonms.ylog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.sonms.ylog.core.designsystem.component.dialog.YLogDialog
import com.sonms.ylog.core.designsystem.theme.YLog
import com.sonms.ylog.core.navigation.toEntries
import com.sonms.ylog.core.trigger.LocalGlobalUiEventTrigger
import com.sonms.ylog.core.trigger.model.DialogState
import com.sonms.ylog.core.trigger.ui.GlobalMessageHost
import com.sonms.ylog.core.trigger.ui.rememberDialogStateHolder
import com.sonms.ylog.core.trigger.ui.rememberGlobalMessageState
import com.sonms.ylog.core.trigger.ui.rememberGlobalUiEventHolder
import com.sonms.ylog.presentation.home.impl.homeEntry
import com.sonms.ylog.presentation.splash.impl.splashEntry
import com.sonms.ylog.navigation.MainTab
import dev.zacsweers.metrox.viewmodel.metroViewModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun YLogApp(
    appState: YLogAppState,
    viewModel: MainViewModel = metroViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    if (uiState is MainUiState.Loading) return

    // 화면에 보이는 키가 탭 루트일 때만 currentTab이 null이 아니므로 바텀 바가 보인다
    val currentTab = appState.currentTab

    val messageState = rememberGlobalMessageState()
    val dialogStateHolder = rememberDialogStateHolder()
    val globalUiEventHolder = rememberGlobalUiEventHolder(messageState, dialogStateHolder)

    CompositionLocalProvider(
        LocalGlobalUiEventTrigger provides globalUiEventHolder,
    ) {
        Scaffold(
            containerColor = YLog.colors.neutral.n50,
            snackbarHost = { GlobalMessageHost(messageState) },
            bottomBar = {
                YLogBottomBar(
                    isVisible = currentTab != null,
                    tabs = appState.tabs,
                    currentTab = currentTab,
                    onTabClick = appState::navigateToTab,
                )
            },
        ) { padding ->
            NavDisplay(
                entries = appState.navigationState.toEntries(
                    entryProvider {
                        homeEntry(appState.navigator)
                        splashEntry(appState.navigator)
                    },
                ),
                onBack = appState.navigator::goBack,
                modifier = Modifier.padding(padding),
            )
        }

        YLogDialogSlot(
            dialogState = dialogStateHolder.dialogState,
            onDismiss = dialogStateHolder::dismissDialog,
        )
    }
}

/** 앱에서 다이얼로그는 하나만 뜬다. */
@Composable
private fun YLogDialogSlot(dialogState: DialogState, onDismiss: () -> Unit) {
    val type = dialogState.type ?: return

    YLogDialog(
        title = type.title,
        content = type.content,
        confirmText = type.confirmText,
        dismissible = type.dismissible,
        onConfirm = {
            dialogState.onConfirm()
            onDismiss()
        },
        onDismissRequest = onDismiss,
    )
}

@Composable
private fun YLogBottomBar(
    isVisible: Boolean,
    tabs: ImmutableList<MainTab>,
    currentTab: MainTab?,
    onTabClick: (MainTab) -> Unit,
) {
    if (!isVisible) return

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(YLog.colors.neutral.n0)
            .navigationBarsPadding()
            .padding(vertical = 12.dp),
    ) {
        tabs.forEach { tab ->
            // 아이콘이 생기기 전까지 contentDescription을 라벨로 대신 쓴다
            Text(
                text = tab.contentDescription,
                style = YLog.typography.caption.c12,
                color = if (tab == currentTab) YLog.colors.neutral.n900 else YLog.colors.neutral.n500,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .clickable { onTabClick(tab) },
            )
        }
    }
}
