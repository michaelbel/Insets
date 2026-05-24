@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample11_SafeDrawing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
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
fun Sample11Screen() {
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current

    val safeDrawing = WindowInsets.safeDrawing

    val safeDrawingTop = safeDrawing.getTop(density)
    val safeDrawingBottom = safeDrawing.getBottom(density)
    val safeDrawingLeft = safeDrawing.getLeft(density, layoutDirection)
    val safeDrawingRight = safeDrawing.getRight(density, layoutDirection)

    val hasSafeDrawing = safeDrawingTop > 0 || safeDrawingBottom > 0 || safeDrawingLeft > 0 || safeDrawingRight > 0

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item {
                TopAppBar(
                    title = { Text("WindowInsets.safeDrawing") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                )
            }
            item { SectionLabel("Обнаружение") }
            item {
                ListItem(
                    headlineContent = { Text("safeDrawing присутствует") },
                    trailingContent = { Text(if (hasSafeDrawing) "TRUE" else "FALSE") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("Отступы") }
            item {
                val topDp = with(density) { safeDrawingTop.toDp() }
                ListItem(
                    headlineContent = { Text("Top") },
                    trailingContent = { Text(safeDrawingTop.formatInsetValue(topDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val bottomDp = with(density) { safeDrawingBottom.toDp() }
                ListItem(
                    headlineContent = { Text("Bottom") },
                    trailingContent = { Text(safeDrawingBottom.formatInsetValue(bottomDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val leftDp = with(density) { safeDrawingLeft.toDp() }
                ListItem(
                    headlineContent = { Text("Left") },
                    trailingContent = { Text(safeDrawingLeft.formatInsetValue(leftDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val rightDp = with(density) { safeDrawingRight.toDp() }
                ListItem(
                    headlineContent = { Text("Right") },
                    trailingContent = { Text(safeDrawingRight.formatInsetValue(rightDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
    }
}
