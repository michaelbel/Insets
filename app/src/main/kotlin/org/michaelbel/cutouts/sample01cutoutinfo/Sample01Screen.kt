@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.cutouts.sample01cutoutinfo

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.waterfall
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import org.michaelbel.cutouts.SectionLabel

@Composable
fun Sample01Screen(
    onBack: () -> Unit
) {
    BackHandler(
        onBack = onBack
    )

    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current

    val displayCutout = WindowInsets.displayCutout

    val cutoutTop = displayCutout.getTop(density)
    val cutoutBottom = displayCutout.getBottom(density)
    val cutoutLeft = displayCutout.getLeft(density, layoutDirection)
    val cutoutRight = displayCutout.getRight(density, layoutDirection)

    val hasDisplayCutout = cutoutTop > 0 || cutoutBottom > 0 || cutoutLeft > 0 || cutoutRight > 0

    val waterfall = WindowInsets.waterfall

    val waterfallTop = waterfall.getTop(density)
    val waterfallBottom = waterfall.getBottom(density)
    val waterfallLeft = waterfall.getLeft(density, layoutDirection)
    val waterfallRight = waterfall.getRight(density, layoutDirection)

    val hasWaterfall = waterfallTop > 0 || waterfallBottom > 0 || waterfallLeft > 0 || waterfallRight > 0



    val view = LocalView.current
    val windowInsets = remember(view) { ViewCompat.getRootWindowInsets(view) }
    val displayCutout2 = windowInsets?.displayCutout
    val waterfallInsets = displayCutout2?.waterfallInsets

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("Информация о вырезе") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
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
            item { SectionLabel("Обнаружение") }
            item {
                ListItem(
                    headlineContent = { Text("Вырез присутствует") },
                    trailingContent = { Text(if (hasDisplayCutout) "ДА" else "НЕТ") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val position = when {
                    cutoutTop > 0 -> "СВЕРХУ"
                    cutoutBottom > 0 -> "СНИЗУ"
                    cutoutLeft > 0 -> "СЛЕВА"
                    cutoutRight > 0 -> "СПРАВА"
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
            item { SectionLabel("Безопасные отступы выреза") }
            item {
                val cutoutTopDp = with(density) { cutoutTop.toDp() }

                ListItem(
                    headlineContent = { Text("Сверху") },
                    trailingContent = { Text("$cutoutTop.px  ($cutoutTopDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val cutoutBottomDp = with(density) { cutoutBottom.toDp() }

                ListItem(
                    headlineContent = { Text("Снизу") },
                    trailingContent = { Text("$cutoutBottom.px  ($cutoutBottomDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val cutoutLeftDp = with(density) { cutoutLeft.toDp() }

                ListItem(
                    headlineContent = { Text("Слева") },
                    trailingContent = { Text("$cutoutLeft.px  ($cutoutLeftDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val cutoutRightDp = with(density) { cutoutRight.toDp() }

                ListItem(
                    headlineContent = { Text("Справа") },
                    trailingContent = { Text("$cutoutRight.px  ($cutoutRightDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }








            item { SectionLabel("Отступы водопада") }
            item {
                val leftDp = with(density) { (waterfallInsets?.left ?: 0).toDp() }

                ListItem(
                    headlineContent = { Text("Слева") },
                    trailingContent = { Text("${waterfallInsets?.left ?: 0} px  ($leftDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val topDp = with(density) { (waterfallInsets?.top ?: 0).toDp() }

                ListItem(
                    headlineContent = { Text("Сверху") },
                    trailingContent = { Text("${waterfallInsets?.top ?: 0} px  ($topDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val rightDp = with(density) { (waterfallInsets?.right ?: 0).toDp() }

                ListItem(
                    headlineContent = { Text("Справа") },
                    trailingContent = { Text("${waterfallInsets?.right ?: 0} px  ($rightDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val bottomDp = with(density) { (waterfallInsets?.bottom ?: 0).toDp() }

                ListItem(
                    headlineContent = { Text("Снизу") },
                    trailingContent = { Text("${waterfallInsets?.bottom ?: 0} px  ($bottomDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
    }
}
