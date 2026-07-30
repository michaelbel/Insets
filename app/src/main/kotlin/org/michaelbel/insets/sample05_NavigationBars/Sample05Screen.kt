package org.michaelbel.insets.sample05_NavigationBars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import org.michaelbel.insets.SectionLabel
import org.michaelbel.insets.formatInsetValue

@Composable
fun Sample05Screen() {
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current

    val navigationBars = WindowInsets.navigationBars

    val navigationBarsTop = navigationBars.getTop(density)
    val navigationBarsBottom = navigationBars.getBottom(density)
    val navigationBarsLeft = navigationBars.getLeft(density, layoutDirection)
    val navigationBarsRight = navigationBars.getRight(density, layoutDirection)

    val hasNavigationBars = navigationBarsTop > 0 || navigationBarsBottom > 0 || navigationBarsLeft > 0 || navigationBarsRight > 0

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item {
                TopAppBar(
                    title = { Text("WindowInsets.navigationBars") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                )
            }
            item { SectionLabel("Обнаружение") }
            item {
                ListItem(
                    headlineContent = { Text("navigationBars присутствует") },
                    trailingContent = { Text(if (hasNavigationBars) "TRUE" else "FALSE") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("Отступы") }
            item {
                val topDp = with(density) { navigationBarsTop.toDp() }
                ListItem(
                    headlineContent = { Text("Top") },
                    trailingContent = { Text(navigationBarsTop.formatInsetValue(topDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val bottomDp = with(density) { navigationBarsBottom.toDp() }
                ListItem(
                    headlineContent = { Text("Bottom") },
                    trailingContent = { Text(navigationBarsBottom.formatInsetValue(bottomDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val leftDp = with(density) { navigationBarsLeft.toDp() }
                ListItem(
                    headlineContent = { Text("Left") },
                    trailingContent = { Text(navigationBarsLeft.formatInsetValue(leftDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val rightDp = with(density) { navigationBarsRight.toDp() }
                ListItem(
                    headlineContent = { Text("Right") },
                    trailingContent = { Text(navigationBarsRight.formatInsetValue(rightDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
    }
}
