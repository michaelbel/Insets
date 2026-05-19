@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample21_SizeModifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample21Screen() {
    val density = LocalDensity.current

    val statusBarsTop = WindowInsets.statusBars.getTop(density)
    val navBarsBottom = WindowInsets.navigationBars.getBottom(density)
    val systemBarsTop = WindowInsets.systemBars.getTop(density)
    val systemBarsBottom = WindowInsets.systemBars.getBottom(density)

    val statusBarTopDp = with(density) { statusBarsTop.toDp() }
    val navBarBottomDp = with(density) { navBarsBottom.toDp() }
    val systemBarsTopDp = with(density) { systemBarsTop.toDp() }
    val systemBarsBottomDp = with(density) { systemBarsBottom.toDp() }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Size Modifiers") },
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
            item { SectionLabel("windowInsetsTopHeight") }
            item {
                ListItem(
                    headlineContent = { Text("windowInsetsTopHeight(statusBars)") },
                    supportingContent = { Text("высота элемента = top инсета statusBars") },
                    trailingContent = { Text("$statusBarsTop px  ($statusBarTopDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.shapes.medium
                        )
                ) {
                    Column {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .windowInsetsTopHeight(WindowInsets.statusBars)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "контент",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }
                }
            }

            item { SectionLabel("windowInsetsBottomHeight") }
            item {
                ListItem(
                    headlineContent = { Text("windowInsetsBottomHeight(navigationBars)") },
                    supportingContent = { Text("высота элемента = bottom инсета navigationBars") },
                    trailingContent = { Text("$navBarsBottom px  ($navBarBottomDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .background(
                            MaterialTheme.colorScheme.secondaryContainer,
                            MaterialTheme.shapes.medium
                        )
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "контент",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .windowInsetsBottomHeight(WindowInsets.navigationBars)
                                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f))
                        )
                    }
                }
            }

            item { SectionLabel("Паттерн: Column с явными спейсерами") }
            item {
                ListItem(
                    headlineContent = { Text("systemBars top spacer") },
                    trailingContent = { Text("$systemBarsTop px  ($systemBarsTopDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("systemBars bottom spacer") },
                    trailingContent = { Text("$systemBarsBottom px  ($systemBarsBottomDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Использование") },
                    supportingContent = {
                        Text(
                            "Size-модификаторы не потребляют инсеты и не добавляют padding. " +
                                "Они задают точный размер самого элемента — удобно для " +
                                "кастомных спейсеров и фоновых областей."
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
