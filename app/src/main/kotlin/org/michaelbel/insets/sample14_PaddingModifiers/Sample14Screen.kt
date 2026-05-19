@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample14_PaddingModifiers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.captionBar
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.mandatorySystemGestures
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.foundation.layout.tappableElement
import androidx.compose.foundation.layout.waterfall
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontFamily
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample14Screen() {
    val density = LocalDensity.current
    val dir = LocalLayoutDirection.current

    data class ModifierEntry(
        val name: String,
        val insets: WindowInsets,
    )

    val entries = listOf(
        ModifierEntry("systemBarsPadding()", WindowInsets.systemBars),
        ModifierEntry("statusBarsPadding()", WindowInsets.statusBars),
        ModifierEntry("navigationBarsPadding()", WindowInsets.navigationBars),
        ModifierEntry("captionBarPadding()", WindowInsets.captionBar),
        ModifierEntry("imePadding()", WindowInsets.ime),
        ModifierEntry("displayCutoutPadding()", WindowInsets.displayCutout),
        ModifierEntry("waterfallPadding()", WindowInsets.waterfall),
        ModifierEntry("systemGesturesPadding()", WindowInsets.systemGestures),
        ModifierEntry("mandatorySystemGesturesPadding()", WindowInsets.mandatorySystemGestures),
        ModifierEntry("tappableElement (нет shortcut)", WindowInsets.tappableElement),
        ModifierEntry("safeDrawingPadding()", WindowInsets.safeDrawing),
        ModifierEntry("safeGesturesPadding()", WindowInsets.safeGestures),
        ModifierEntry("safeContentPadding()", WindowInsets.safeContent),
    )

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Padding Modifiers") },
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
            for (entry in entries) {
                item {
                    SectionLabel(entry.name)
                }
                val top = entry.insets.getTop(density)
                val bottom = entry.insets.getBottom(density)
                val left = entry.insets.getLeft(density, dir)
                val right = entry.insets.getRight(density, dir)
                val topDp = with(density) { top.toDp() }
                val bottomDp = with(density) { bottom.toDp() }
                val leftDp = with(density) { left.toDp() }
                val rightDp = with(density) { right.toDp() }
                item {
                    ListItem(
                        headlineContent = { Text("Сверху", fontFamily = FontFamily.Monospace) },
                        trailingContent = { Text("$top px  ($topDp)") },
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    )
                }
                item {
                    ListItem(
                        headlineContent = { Text("Снизу", fontFamily = FontFamily.Monospace) },
                        trailingContent = { Text("$bottom px  ($bottomDp)") },
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    )
                }
                item {
                    ListItem(
                        headlineContent = { Text("Слева", fontFamily = FontFamily.Monospace) },
                        trailingContent = { Text("$left px  ($leftDp)") },
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    )
                }
                item {
                    ListItem(
                        headlineContent = { Text("Справа", fontFamily = FontFamily.Monospace) },
                        trailingContent = { Text("$right px  ($rightDp)") },
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    )
                }
            }
        }
    }
}
