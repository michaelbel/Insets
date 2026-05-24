@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.plus
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var selectedSample by rememberSaveable { mutableStateOf<Int?>(null) }
                when {
                    selectedSample == null -> SamplesListScreen { selectedSample = it }
                    else -> {
                        BackHandler { selectedSample = null }
                        when (selectedSample) {
                            1 -> Sample01Screen()
                            2 -> Sample02Screen()
                            3 -> Sample03Screen()
                            4 -> Sample04Screen()
                            5 -> Sample05Screen()
                            6 -> Sample06Screen()
                            7 -> Sample07Screen()
                            8 -> Sample08Screen()
                            9 -> Sample09Screen()
                            10 -> Sample10Screen()
                            11 -> Sample11Screen()
                            12 -> Sample12Screen()
                            13 -> Sample13Screen()
                            14 -> Sample14Screen()
                            15 -> Sample15Screen()
                            16 -> Sample16Screen()
                            17 -> Sample17Screen()
                            18 -> Sample18Screen()
                            19 -> Sample19Screen()
                            20 -> Sample20Screen()
                            21 -> Sample21Screen()
                            22 -> Sample22Screen()
                        }
                    }
                }
            }
        }
    }
}

private data class SampleItem(
    val number: Int,
    val title: String
)

private val windowInsetsSamples = listOf(
    SampleItem(1, "WindowInsets.captionBar"),
    SampleItem(2, "WindowInsets.displayCutout"),
    SampleItem(3, "WindowInsets.ime"),
    SampleItem(4, "WindowInsets.mandatorySystemGestures"),
    SampleItem(5, "WindowInsets.navigationBars"),
    SampleItem(6, "WindowInsets.statusBars"),
    SampleItem(7, "WindowInsets.waterfall")
)

private val combinedInsetsSamples = listOf(
    SampleItem(8, "WindowInsets.systemBars"),
    SampleItem(9, "WindowInsets.systemGestures"),
    SampleItem(10, "WindowInsets.tappableElement"),
    SampleItem(11, "WindowInsets.safeDrawing"),
    SampleItem(12, "WindowInsets.safeGestures"),
    SampleItem(13, "WindowInsets.safeContent")
)

private val otherSamples = listOf(
    SampleItem(14, "Padding Modifiers"),
    SampleItem(15, "consumeWindowInsets"),
    SampleItem(16, "Операции: union / exclude / add"),
    SampleItem(17, "WindowInsetsSides.only(...)"),
    SampleItem(18, "IgnoringVisibility"),
    SampleItem(19, "Состояние видимости (isVisible)"),
    SampleItem(20, "IME анимация + imeNestedScroll"),
    SampleItem(21, "Size Modifiers (TopHeight / BottomHeight)"),
    SampleItem(22, "Компоненты M3 с windowInsets")
)

@Composable
private fun SamplesListScreen(onSampleClick: (Int) -> Unit) {
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
            itemsIndexed(windowInsetsSamples) { index, sample ->
                SampleSegmentedListItem(
                    sample = sample,
                    index = index,
                    count = windowInsetsSamples.size,
                    onSampleClick = onSampleClick
                )
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            itemsIndexed(combinedInsetsSamples) { index, sample ->
                SampleSegmentedListItem(
                    sample = sample,
                    index = index,
                    count = combinedInsetsSamples.size,
                    onSampleClick = onSampleClick
                )
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            itemsIndexed(otherSamples) { index, sample ->
                SampleSegmentedListItem(
                    sample = sample,
                    index = index,
                    count = otherSamples.size,
                    onSampleClick = onSampleClick
                )
            }
        }
    }
}

@Composable
private fun SampleSegmentedListItem(
    sample: SampleItem,
    index: Int,
    count: Int,
    onSampleClick: (Int) -> Unit
) {
    SegmentedListItem(
        onClick = { onSampleClick(sample.number) },
        overlineContent = { Text("Sample ${sample.number.toString().padStart(2, '0')}") },
        shapes = ListItemDefaults.segmentedShapes(index = index, count = count),
        colors = ListItemDefaults.segmentedColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
        )
    ) {
        Text(sample.title)
    }
}
