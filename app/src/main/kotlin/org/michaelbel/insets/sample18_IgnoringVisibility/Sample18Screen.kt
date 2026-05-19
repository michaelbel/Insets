@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class,
    ExperimentalLayoutApi::class
)

package org.michaelbel.insets.sample18_IgnoringVisibility

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.captionBar
import androidx.compose.foundation.layout.captionBarIgnoringVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsIgnoringVisibility
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsIgnoringVisibility
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsIgnoringVisibility
import androidx.compose.foundation.layout.tappableElement
import androidx.compose.foundation.layout.tappableElementIgnoringVisibility
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
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample18Screen() {
    val density = LocalDensity.current

    data class InsetPair(
        val label: String,
        val normal: WindowInsets,
        val ignoringVisibility: WindowInsets,
    )

    val pairs = listOf(
        InsetPair("captionBar", WindowInsets.captionBar, WindowInsets.captionBarIgnoringVisibility),
        InsetPair("statusBars", WindowInsets.statusBars, WindowInsets.statusBarsIgnoringVisibility),
        InsetPair("navigationBars", WindowInsets.navigationBars, WindowInsets.navigationBarsIgnoringVisibility),
        InsetPair("systemBars", WindowInsets.systemBars, WindowInsets.systemBarsIgnoringVisibility),
        InsetPair("tappableElement", WindowInsets.tappableElement, WindowInsets.tappableElementIgnoringVisibility),
    )

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("IgnoringVisibility") },
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
            item {
                ListItem(
                    headlineContent = { Text("Описание") },
                    supportingContent = {
                        Text(
                            "Обычные инсеты возвращают 0, когда элемент скрыт. " +
                                "IgnoringVisibility-варианты возвращают размер независимо " +
                                "от видимости — полезно, чтобы зарезервировать место."
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            for (pair in pairs) {
                item { SectionLabel(pair.label) }

                val normalTop = pair.normal.getTop(density)
                val normalBottom = pair.normal.getBottom(density)
                val ignoringTop = pair.ignoringVisibility.getTop(density)
                val ignoringBottom = pair.ignoringVisibility.getBottom(density)

                item {
                    ListItem(
                        headlineContent = { Text(pair.label) },
                        supportingContent = { Text("Видимость учитывается") },
                        trailingContent = { Text("t=$normalTop b=$normalBottom") },
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    )
                }
                item {
                    ListItem(
                        headlineContent = { Text("${pair.label}IgnoringVisibility") },
                        supportingContent = { Text("Видимость игнорируется") },
                        trailingContent = { Text("t=$ignoringTop b=$ignoringBottom") },
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    )
                }
            }
        }
    }
}
