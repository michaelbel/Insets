@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample16_InsetOperations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.union
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
import androidx.compose.ui.unit.dp
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample16Screen() {
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
    val displayCutout = WindowInsets.displayCutout
    val statusBars = WindowInsets.statusBars
    val navigationBars = WindowInsets.navigationBars
    val ime = WindowInsets.ime

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Операции над инсетами") },
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
                ListItem(
                    headlineContent = { Text("systemBars") },
                    trailingContent = { Text(systemBars.fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("displayCutout") },
                    trailingContent = { Text(displayCutout.fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("ime") },
                    trailingContent = { Text(ime.fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("union — максимум из двух") }
            item {
                ListItem(
                    headlineContent = { Text("systemBars.union(displayCutout)") },
                    supportingContent = { Text("max(systemBars, displayCutout) по каждой стороне") },
                    trailingContent = { Text(systemBars.union(displayCutout).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("systemBars.union(ime)") },
                    trailingContent = { Text(systemBars.union(ime).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("exclude — вычитание (не < 0)") }
            item {
                ListItem(
                    headlineContent = { Text("systemBars.exclude(statusBars)") },
                    supportingContent = { Text("остаётся только navigationBars-часть") },
                    trailingContent = { Text(systemBars.exclude(statusBars).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("systemBars.exclude(navigationBars)") },
                    supportingContent = { Text("остаётся только statusBars-часть") },
                    trailingContent = { Text(systemBars.exclude(navigationBars).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("add — суммирование значений") }
            item {
                ListItem(
                    headlineContent = { Text("navigationBars.add(WindowInsets(bottom = 56.dp))") },
                    supportingContent = { Text("navigationBars bottom + 56 dp") },
                    trailingContent = { Text(navigationBars.add(WindowInsets(bottom = 56.dp)).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("systemBars.add(ime)") },
                    supportingContent = { Text("сумма, не максимум") },
                    trailingContent = { Text(systemBars.add(ime).fmt()) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
    }
}
