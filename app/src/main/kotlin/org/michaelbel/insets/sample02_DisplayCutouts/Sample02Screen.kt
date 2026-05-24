@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample02_DisplayCutouts

import androidx.compose.foundation.background
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.cutoutPath
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import org.michaelbel.insets.SectionLabel
import org.michaelbel.insets.formatInsetValue

@Composable
fun Sample02Screen() {
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current
    var showCutoutHighlight by remember { mutableStateOf(true) }

    val displayCutout = WindowInsets.displayCutout

    val cutoutTop = displayCutout.getTop(density)
    val cutoutBottom = displayCutout.getBottom(density)
    val cutoutLeft = displayCutout.getLeft(density, layoutDirection)
    val cutoutRight = displayCutout.getRight(density, layoutDirection)

    val hasDisplayCutout = cutoutTop > 0 || cutoutBottom > 0 || cutoutLeft > 0 || cutoutRight > 0

    val cutoutPath = WindowInsets.cutoutPath
    val pathBounds = cutoutPath?.getBounds()
    val hasCutoutHighlight = hasDisplayCutout || cutoutPath?.isEmpty == false

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .displayCutoutPadding()
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item {
                TopAppBar(
                    title = { Text("WindowInsets.displayCutout") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                )
            }
            item { SectionLabel("Обнаружение") }
            item {
                ListItem(
                    headlineContent = { Text("displayCutout присутствует") },
                    trailingContent = { Text(if (hasDisplayCutout) "TRUE" else "FALSE") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val position = when {
                    cutoutTop > 0 -> "TOP"
                    cutoutBottom > 0 -> "BOTTOM"
                    cutoutLeft > 0 -> "LEFT"
                    cutoutRight > 0 -> "RIGHT"
                    else -> "—"
                }
                ListItem(
                    headlineContent = { Text("Расположение выреза") },
                    trailingContent = { Text(position) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("Отступы") }
            item {
                val cutoutTopDp = with(density) { cutoutTop.toDp() }
                ListItem(
                    headlineContent = { Text("Top") },
                    trailingContent = { Text(cutoutTop.formatInsetValue(cutoutTopDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val cutoutBottomDp = with(density) { cutoutBottom.toDp() }
                ListItem(
                    headlineContent = { Text("Bottom") },
                    trailingContent = { Text(cutoutBottom.formatInsetValue(cutoutBottomDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val cutoutLeftDp = with(density) { cutoutLeft.toDp() }
                ListItem(
                    headlineContent = { Text("Left") },
                    trailingContent = { Text(cutoutLeft.formatInsetValue(cutoutLeftDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val cutoutRightDp = with(density) { cutoutRight.toDp() }
                ListItem(
                    headlineContent = { Text("Right") },
                    trailingContent = { Text(cutoutRight.formatInsetValue(cutoutRightDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("Форма выреза") }
            item {
                ListItem(
                    headlineContent = { Text("Подсветка выреза") },
                    trailingContent = {
                        Switch(
                            checked = hasCutoutHighlight && showCutoutHighlight,
                            enabled = hasCutoutHighlight,
                            onCheckedChange = { showCutoutHighlight = it }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                ListItem(
                    headlineContent = { Text("Форма выреза") },
                    trailingContent = {
                        Text(
                            when {
                                cutoutPath == null -> "НЕТ"
                                cutoutPath.isEmpty -> "ПУСТАЯ"
                                else -> "ЕСТЬ"
                            }
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            if (pathBounds != null) {
                item {
                    ListItem(
                        headlineContent = { Text("Границы формы") },
                        trailingContent = {
                            Text(
                                "${pathBounds.left.toInt()}.${pathBounds.top.toInt()} – " +
                                    "${pathBounds.right.toInt()}.${pathBounds.bottom.toInt()}"
                            )
                        },
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                        )
                    )
                }
            }
        }
        if (hasCutoutHighlight && showCutoutHighlight) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val highlightColor = Color.Cyan.copy(alpha = 0.75F)
                val strokeColor = Color.White

                if (cutoutPath != null && !cutoutPath.isEmpty) {
                    drawPath(
                        path = cutoutPath,
                        color = highlightColor
                    )
                    drawPath(
                        path = cutoutPath,
                        color = strokeColor,
                        style = Stroke(width = 8F)
                    )
                }

                if (cutoutPath == null || cutoutPath.isEmpty) {
                    if (cutoutTop > 0) {
                        drawRect(
                            color = highlightColor,
                            size = size.copy(height = (cutoutTop * 2).toFloat().coerceAtMost(size.height))
                        )
                    }
                    if (cutoutBottom > 0) {
                        val height = (cutoutBottom * 2).toFloat().coerceAtMost(size.height)
                        drawRect(
                            color = highlightColor,
                            topLeft = Offset(
                                x = 0F,
                                y = size.height - height
                            ),
                            size = size.copy(height = height)
                        )
                    }
                    if (cutoutLeft > 0) {
                        drawRect(
                            color = highlightColor,
                            size = size.copy(width = (cutoutLeft * 2).toFloat().coerceAtMost(size.width))
                        )
                    }
                    if (cutoutRight > 0) {
                        val width = (cutoutRight * 2).toFloat().coerceAtMost(size.width)
                        drawRect(
                            color = highlightColor,
                            topLeft = Offset(
                                x = size.width - width,
                                y = 0F
                            ),
                            size = size.copy(width = width)
                        )
                    }
                }
            }
        }
    }
}
