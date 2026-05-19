@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample15_ConsumeInsets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.onConsumedWindowInsetsChanged
import androidx.compose.foundation.layout.systemBars
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample15Screen() {
    val density = LocalDensity.current
    val systemBarsInsets = WindowInsets.systemBars
    val systemBarsPadding = systemBarsInsets.asPaddingValues(density)

    var noConsumeTop by remember { mutableIntStateOf(0) }
    var noConsumeBottom by remember { mutableIntStateOf(0) }
    var withConsumeTop by remember { mutableIntStateOf(0) }
    var withConsumeBottom by remember { mutableIntStateOf(0) }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("consumeWindowInsets") },
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
            item { SectionLabel("Входные данные") }
            item {
                val top = systemBarsInsets.getTop(density)
                val bottom = systemBarsInsets.getBottom(density)
                ListItem(
                    headlineContent = { Text("WindowInsets.systemBars") },
                    supportingContent = { Text("top=$top px, bottom=$bottom px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item {
                SectionLabel("БЕЗ consumeWindowInsets")
            }
            item {
                ListItem(
                    headlineContent = { Text("Потреблено выше по иерархии") },
                    supportingContent = { Text("top=$noConsumeTop px, bottom=$noConsumeBottom px") },
                    trailingContent = { Text("—") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Поведение") },
                    supportingContent = {
                        Text(
                            "LazyColumn использует asPaddingValues(), но не вызывает " +
                                "consumeWindowInsets. Дочерние элементы видят systemBars " +
                                "как непотреблённые и могут добавить отступ повторно."
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                Box(
                    modifier = Modifier.onConsumedWindowInsetsChanged { consumed ->
                        noConsumeTop = consumed.getTop(density)
                        noConsumeBottom = consumed.getBottom(density)
                    }
                )
            }

            item { SectionLabel("С consumeWindowInsets") }
            item {
                ListItem(
                    headlineContent = { Text("Потреблено выше по иерархии") },
                    supportingContent = { Text("top=$withConsumeTop px, bottom=$withConsumeBottom px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Поведение") },
                    supportingContent = {
                        Text(
                            "Modifier.consumeWindowInsets(WindowInsets.systemBars) помечает " +
                                "systemBars как потреблённые. Дочерние padding-модификаторы " +
                                "не добавят эти отступы повторно."
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                Box(
                    modifier = Modifier
                        .consumeWindowInsets(systemBarsPadding)
                        .onConsumedWindowInsetsChanged { consumed ->
                            withConsumeTop = consumed.getTop(density)
                            withConsumeBottom = consumed.getBottom(density)
                        }
                )
            }
        }
    }
}
