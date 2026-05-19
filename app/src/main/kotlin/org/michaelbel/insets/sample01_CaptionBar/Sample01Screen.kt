@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample01_CaptionBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.captionBar
import androidx.compose.foundation.layout.captionBarPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample01Screen() {
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current

    val captionBar = WindowInsets.captionBar

    val captionBarTop = captionBar.getTop(density)
    val captionBarBottom = captionBar.getBottom(density)
    val captionBarLeft = captionBar.getLeft(density, layoutDirection)
    val captionBarRight = captionBar.getRight(density, layoutDirection)

    val hasCaptionBar = captionBarTop > 0 || captionBarBottom > 0 || captionBarLeft > 0 || captionBarRight > 0

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .captionBarPadding()
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item { SectionLabel("Обнаружение") }
            item {
                ListItem(
                    headlineContent = { Text("Has captionBar") },
                    trailingContent = { Text(if (hasCaptionBar) "TRUE" else "FALSE") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("Отступы") }
            item {
                val topDp = with(density) { captionBarTop.toDp() }
                ListItem(
                    headlineContent = { Text("Top") },
                    trailingContent = { Text("$captionBarTop px  ($topDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val bottomDp = with(density) { captionBarBottom.toDp() }
                ListItem(
                    headlineContent = { Text("Bottom") },
                    trailingContent = { Text("$captionBarBottom px  ($bottomDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val leftDp = with(density) { captionBarLeft.toDp() }
                ListItem(
                    headlineContent = { Text("Left") },
                    trailingContent = { Text("$captionBarLeft px  ($leftDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val rightDp = with(density) { captionBarRight.toDp() }
                ListItem(
                    headlineContent = { Text("Right") },
                    trailingContent = { Text("$captionBarRight px  ($rightDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
    }
}
