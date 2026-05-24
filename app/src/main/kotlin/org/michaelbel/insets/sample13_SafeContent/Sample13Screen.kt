@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample13_SafeContent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
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
fun Sample13Screen() {
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current

    val safeContent = WindowInsets.safeContent

    val safeContentTop = safeContent.getTop(density)
    val safeContentBottom = safeContent.getBottom(density)
    val safeContentLeft = safeContent.getLeft(density, layoutDirection)
    val safeContentRight = safeContent.getRight(density, layoutDirection)

    val hasSafeContent = safeContentTop > 0 || safeContentBottom > 0 || safeContentLeft > 0 || safeContentRight > 0

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding()
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item {
                TopAppBar(
                    title = { Text("WindowInsets.safeContent") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                )
            }
            item { SectionLabel("Обнаружение") }
            item {
                ListItem(
                    headlineContent = { Text("safeContent присутствует") },
                    trailingContent = { Text(if (hasSafeContent) "TRUE" else "FALSE") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("Отступы") }
            item {
                val topDp = with(density) { safeContentTop.toDp() }
                ListItem(
                    headlineContent = { Text("Top") },
                    trailingContent = { Text(safeContentTop.formatInsetValue(topDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val bottomDp = with(density) { safeContentBottom.toDp() }
                ListItem(
                    headlineContent = { Text("Bottom") },
                    trailingContent = { Text(safeContentBottom.formatInsetValue(bottomDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val leftDp = with(density) { safeContentLeft.toDp() }
                ListItem(
                    headlineContent = { Text("Left") },
                    trailingContent = { Text(safeContentLeft.formatInsetValue(leftDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val rightDp = with(density) { safeContentRight.toDp() }
                ListItem(
                    headlineContent = { Text("Right") },
                    trailingContent = { Text(safeContentRight.formatInsetValue(rightDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
    }
}
