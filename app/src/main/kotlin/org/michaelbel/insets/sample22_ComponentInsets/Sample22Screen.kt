@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample22_ComponentInsets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample22Screen() {
    val density = LocalDensity.current

    val statusBarsTop = WindowInsets.statusBars.getTop(density)
    val navBarsBottom = WindowInsets.navigationBars.getBottom(density)

    val topAppBarDefaultTop = TopAppBarDefaults.windowInsets.getTop(density)
    val bottomAppBarDefaultBottom = BottomAppBarDefaults.windowInsets.getBottom(density)
    val navBarDefaultBottom = NavigationBarDefaults.windowInsets.getBottom(density)
    val scaffoldDefault = ScaffoldDefaults.contentWindowInsets

    val scaffoldTop = scaffoldDefault.getTop(density)
    val scaffoldBottom = scaffoldDefault.getBottom(density)

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Компоненты M3 с windowInsets") },
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
            item { SectionLabel("Системные значения") }
            item {
                ListItem(
                    headlineContent = { Text("statusBars.top") },
                    trailingContent = { Text("$statusBarsTop px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("navigationBars.bottom") },
                    trailingContent = { Text("$navBarsBottom px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("TopAppBar.windowInsets") }
            item {
                ListItem(
                    headlineContent = { Text("TopAppBarDefaults.windowInsets.top") },
                    supportingContent = { Text("добавляет padding под statusBars") },
                    trailingContent = { Text("$topAppBarDefaultTop px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("windowInsets = WindowInsets(0)") },
                    supportingContent = { Text("компонент не добавит никакого отступа") },
                    trailingContent = { Text("0 px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("BottomAppBar.windowInsets") }
            item {
                ListItem(
                    headlineContent = { Text("BottomAppBarDefaults.windowInsets.bottom") },
                    supportingContent = { Text("добавляет padding под navigationBars") },
                    trailingContent = { Text("$bottomAppBarDefaultBottom px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("NavigationBar.windowInsets") }
            item {
                ListItem(
                    headlineContent = { Text("NavigationBarDefaults.windowInsets.bottom") },
                    supportingContent = { Text("добавляет padding под navigationBars") },
                    trailingContent = { Text("$navBarDefaultBottom px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("Scaffold.contentWindowInsets") }
            item {
                ListItem(
                    headlineContent = { Text("ScaffoldDefaults.contentWindowInsets.top") },
                    supportingContent = { Text("инсеты, которые Scaffold передаёт контенту") },
                    trailingContent = { Text("$scaffoldTop px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("ScaffoldDefaults.contentWindowInsets.bottom") },
                    trailingContent = { Text("$scaffoldBottom px") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("Рекомендации") }
            item {
                ListItem(
                    headlineContent = { Text("Внутри Scaffold") },
                    supportingContent = {
                        Text(
                            "Scaffold уже потребляет инсеты и передаёт их через innerPadding. " +
                                "Компонентам внутри Scaffold (NavigationBar, BottomAppBar) " +
                                "передавайте windowInsets = WindowInsets(0), " +
                                "чтобы избежать двойного отступа."
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Без Scaffold") },
                    supportingContent = {
                        Text(
                            "Оставляйте windowInsets по умолчанию — компонент сам обработает " +
                                "нужные инсеты."
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
    }
}
