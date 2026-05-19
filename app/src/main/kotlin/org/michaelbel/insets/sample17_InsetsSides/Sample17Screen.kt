@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample17_InsetsSides

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeDrawing
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample17Screen() {
    val density = LocalDensity.current
    val dir = LocalLayoutDirection.current

    fun WindowInsets.fmt(): String {
        val l = getLeft(density, dir)
        val t = getTop(density)
        val r = getRight(density, dir)
        val b = getBottom(density)
        return "l=$l t=$t r=$r b=$b"
    }

    val systemBars = WindowInsets.systemBars
    val safeDrawing = WindowInsets.safeDrawing

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("WindowInsetsSides") },
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
            item { SectionLabel("systemBars — исходные значения") }
            item {
                ListItem(
                    headlineContent = { Text("systemBars") },
                    trailingContent = { Text(systemBars.fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("systemBars.only(...)") }
            item {
                ListItem(
                    headlineContent = { Text(".only(Top)") },
                    trailingContent = { Text(systemBars.only(WindowInsetsSides.Top).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text(".only(Bottom)") },
                    trailingContent = { Text(systemBars.only(WindowInsetsSides.Bottom).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text(".only(Horizontal)") },
                    trailingContent = { Text(systemBars.only(WindowInsetsSides.Horizontal).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text(".only(Vertical)") },
                    trailingContent = { Text(systemBars.only(WindowInsetsSides.Vertical).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text(".only(Start)") },
                    supportingContent = { Text("левая сторона в LTR, правая в RTL") },
                    trailingContent = { Text(systemBars.only(WindowInsetsSides.Start).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text(".only(End)") },
                    supportingContent = { Text("правая сторона в LTR, левая в RTL") },
                    trailingContent = { Text(systemBars.only(WindowInsetsSides.End).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text(".only(Top + Bottom)") },
                    trailingContent = {
                        Text(systemBars.only(WindowInsetsSides.Top + WindowInsetsSides.Bottom).fmt())
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("safeDrawing — исходные значения") }
            item {
                ListItem(
                    headlineContent = { Text("safeDrawing") },
                    trailingContent = { Text(safeDrawing.fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("safeDrawing.only(...)") }
            item {
                ListItem(
                    headlineContent = { Text(".only(Top)") },
                    trailingContent = { Text(safeDrawing.only(WindowInsetsSides.Top).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text(".only(Bottom)") },
                    trailingContent = { Text(safeDrawing.only(WindowInsetsSides.Bottom).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text(".only(Horizontal)") },
                    trailingContent = { Text(safeDrawing.only(WindowInsetsSides.Horizontal).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
    }
}
