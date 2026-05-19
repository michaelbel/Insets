@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class,
    ExperimentalLayoutApi::class
)

package org.michaelbel.insets.sample19_InsetsVisibility

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.areNavigationBarsVisible
import androidx.compose.foundation.layout.areStatusBarsVisible
import androidx.compose.foundation.layout.areSystemBarsVisible
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.isCaptionBarVisible
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.isTappableElementVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample19Screen() {
    val isCaptionBarVisible = WindowInsets.isCaptionBarVisible
    val isImeVisible = WindowInsets.isImeVisible
    val areStatusBarsVisible = WindowInsets.areStatusBarsVisible
    val areNavigationBarsVisible = WindowInsets.areNavigationBarsVisible
    val areSystemBarsVisible = WindowInsets.areSystemBarsVisible
    val isTappableElementVisible = WindowInsets.isTappableElementVisible

    var textFieldValue by remember { mutableStateOf("") }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Состояние видимости") },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item { SectionLabel("Флаги видимости") }
            item {
                ListItem(
                    headlineContent = { Text("isCaptionBarVisible") },
                    trailingContent = { Text(if (isCaptionBarVisible) "true" else "false") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("isImeVisible") },
                    supportingContent = { Text("откройте клавиатуру ниже") },
                    trailingContent = { Text(if (isImeVisible) "true ✓" else "false") },
                    colors = ListItemDefaults.colors(
                        containerColor = if (isImeVisible)
                            MaterialTheme.colorScheme.primaryContainer
                        else
                            MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("areStatusBarsVisible") },
                    trailingContent = { Text(if (areStatusBarsVisible) "true" else "false") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("areNavigationBarsVisible") },
                    trailingContent = { Text(if (areNavigationBarsVisible) "true" else "false") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("areSystemBarsVisible") },
                    trailingContent = { Text(if (areSystemBarsVisible) "true" else "false") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("isTappableElementVisible") },
                    supportingContent = { Text("false при жестовой навигации") },
                    trailingContent = { Text(if (isTappableElementVisible) "true" else "false") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("Откройте клавиатуру") }
            item {
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { textFieldValue = it },
                    label = { Text("Нажмите, чтобы открыть IME") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}
