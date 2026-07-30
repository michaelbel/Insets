package org.michaelbel.insets

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.plus
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.michaelbel.insets.sample01_CaptionBar.Sample01Screen
import org.michaelbel.insets.sample02_DisplayCutouts.Sample02Screen
import org.michaelbel.insets.sample03_Ime.Sample03Screen
import org.michaelbel.insets.sample04_MandatorySystemGestures.Sample04Screen
import org.michaelbel.insets.sample05_NavigationBars.Sample05Screen
import org.michaelbel.insets.sample06_StatusBars.Sample06Screen
import org.michaelbel.insets.sample07_Waterfall.Sample07Screen
import org.michaelbel.insets.sample08_SystemBars.Sample08Screen
import org.michaelbel.insets.sample09_SystemGestures.Sample09Screen
import org.michaelbel.insets.sample10_TappableElement.Sample10Screen
import org.michaelbel.insets.sample11_SafeDrawing.Sample11Screen
import org.michaelbel.insets.sample12_SafeGestures.Sample12Screen
import org.michaelbel.insets.sample13_SafeContent.Sample13Screen
import org.michaelbel.insets.sample14_PaddingModifiers.Sample14Screen
import org.michaelbel.insets.sample15_ConsumeInsets.Sample15Screen
import org.michaelbel.insets.sample16_InsetOperations.Sample16Screen
import org.michaelbel.insets.sample17_InsetsSides.Sample17Screen
import org.michaelbel.insets.sample18_IgnoringVisibility.Sample18Screen
import org.michaelbel.insets.sample19_InsetsVisibility.Sample19Screen
import org.michaelbel.insets.sample20_ImeAnimation.Sample20Screen
import org.michaelbel.insets.sample21_SizeModifiers.Sample21Screen
import org.michaelbel.insets.sample22_ComponentInsets.Sample22Screen

private data object Home
private data object Sample01
private data object Sample02
private data object Sample03
private data object Sample04
private data object Sample05
private data object Sample06
private data object Sample07
private data object Sample08
private data object Sample09
private data object Sample10
private data object Sample11
private data object Sample12
private data object Sample13
private data object Sample14
private data object Sample15
private data object Sample16
private data object Sample17
private data object Sample18
private data object Sample19
private data object Sample20
private data object Sample21
private data object Sample22

@Composable
fun MainActivityContent() {
    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        popTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        predictivePopTransitionSpec = { fadeIn() togetherWith fadeOut() using SizeTransform(clip = false) },
        entryProvider = entryProvider {
            entry<Home> {
                val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Insets") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                            ),
                            scrollBehavior = scrollBehavior
                        )
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = innerPadding + PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
                    ) {
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample01) },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 7),
                                overlineContent = { Text(text = "Sample 01") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.captionBar") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample02) },
                                shapes = ListItemDefaults.segmentedShapes(index = 1, count = 7),
                                overlineContent = { Text(text = "Sample 02") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.displayCutout") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample03) },
                                shapes = ListItemDefaults.segmentedShapes(index = 2, count = 7),
                                overlineContent = { Text(text = "Sample 03") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.ime") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample04) },
                                shapes = ListItemDefaults.segmentedShapes(index = 3, count = 7),
                                overlineContent = { Text(text = "Sample 04") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.mandatorySystemGestures") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample05) },
                                shapes = ListItemDefaults.segmentedShapes(index = 4, count = 7),
                                overlineContent = { Text(text = "Sample 05") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.navigationBars") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample06) },
                                shapes = ListItemDefaults.segmentedShapes(index = 5, count = 7),
                                overlineContent = { Text(text = "Sample 06") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.statusBars") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample07) },
                                shapes = ListItemDefaults.segmentedShapes(index = 6, count = 7),
                                overlineContent = { Text(text = "Sample 07") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.waterfall") }
                            )
                        }
                        item { Spacer(modifier = Modifier.height(12.dp)) }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample08) },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 6),
                                overlineContent = { Text(text = "Sample 08") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.systemBars") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample09) },
                                shapes = ListItemDefaults.segmentedShapes(index = 1, count = 6),
                                overlineContent = { Text(text = "Sample 09") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.systemGestures") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample10) },
                                shapes = ListItemDefaults.segmentedShapes(index = 2, count = 6),
                                overlineContent = { Text(text = "Sample 10") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.tappableElement") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample11) },
                                shapes = ListItemDefaults.segmentedShapes(index = 3, count = 6),
                                overlineContent = { Text(text = "Sample 11") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.safeDrawing") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample12) },
                                shapes = ListItemDefaults.segmentedShapes(index = 4, count = 6),
                                overlineContent = { Text(text = "Sample 12") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.safeGestures") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample13) },
                                shapes = ListItemDefaults.segmentedShapes(index = 5, count = 6),
                                overlineContent = { Text(text = "Sample 13") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsets.safeContent") }
                            )
                        }
                        item { Spacer(modifier = Modifier.height(12.dp)) }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample14) },
                                shapes = ListItemDefaults.segmentedShapes(index = 0, count = 9),
                                overlineContent = { Text(text = "Sample 14") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "Padding Modifiers") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample15) },
                                shapes = ListItemDefaults.segmentedShapes(index = 1, count = 9),
                                overlineContent = { Text(text = "Sample 15") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "consumeWindowInsets") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample16) },
                                shapes = ListItemDefaults.segmentedShapes(index = 2, count = 9),
                                overlineContent = { Text(text = "Sample 16") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "Операции: union / exclude / add") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample17) },
                                shapes = ListItemDefaults.segmentedShapes(index = 3, count = 9),
                                overlineContent = { Text(text = "Sample 17") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "WindowInsetsSides.only(...)") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample18) },
                                shapes = ListItemDefaults.segmentedShapes(index = 4, count = 9),
                                overlineContent = { Text(text = "Sample 18") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "IgnoringVisibility") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample19) },
                                shapes = ListItemDefaults.segmentedShapes(index = 5, count = 9),
                                overlineContent = { Text(text = "Sample 19") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "Состояние видимости (isVisible)") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample20) },
                                shapes = ListItemDefaults.segmentedShapes(index = 6, count = 9),
                                overlineContent = { Text(text = "Sample 20") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "IME анимация + imeNestedScroll") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample21) },
                                shapes = ListItemDefaults.segmentedShapes(index = 7, count = 9),
                                overlineContent = { Text(text = "Sample 21") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "Size Modifiers (TopHeight / BottomHeight)") }
                            )
                        }
                        item {
                            SegmentedListItem(
                                onClick = { backStack.add(Sample22) },
                                shapes = ListItemDefaults.segmentedShapes(index = 8, count = 9),
                                overlineContent = { Text(text = "Sample 22") },
                                colors = ListItemDefaults.segmentedColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                                ),
                                content = { Text(text = "Компоненты M3 с windowInsets") }
                            )
                        }
                    }
                }
            }
            entry<Sample01> { Sample01Screen() }
            entry<Sample02> { Sample02Screen() }
            entry<Sample03> { Sample03Screen() }
            entry<Sample04> { Sample04Screen() }
            entry<Sample05> { Sample05Screen() }
            entry<Sample06> { Sample06Screen() }
            entry<Sample07> { Sample07Screen() }
            entry<Sample08> { Sample08Screen() }
            entry<Sample09> { Sample09Screen() }
            entry<Sample10> { Sample10Screen() }
            entry<Sample11> { Sample11Screen() }
            entry<Sample12> { Sample12Screen() }
            entry<Sample13> { Sample13Screen() }
            entry<Sample14> { Sample14Screen() }
            entry<Sample15> { Sample15Screen() }
            entry<Sample16> { Sample16Screen() }
            entry<Sample17> { Sample17Screen() }
            entry<Sample18> { Sample18Screen() }
            entry<Sample19> { Sample19Screen() }
            entry<Sample20> { Sample20Screen() }
            entry<Sample21> { Sample21Screen() }
            entry<Sample22> { Sample22Screen() }
        }
    )
}
