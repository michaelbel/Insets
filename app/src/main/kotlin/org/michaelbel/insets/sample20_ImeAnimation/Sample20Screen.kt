@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class,
    ExperimentalLayoutApi::class
)

package org.michaelbel.insets.sample20_ImeAnimation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imeAnimationSource
import androidx.compose.foundation.layout.imeAnimationTarget
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import org.michaelbel.insets.SectionLabel

@Composable
fun Sample20Screen() {
    val density = LocalDensity.current

    val imeSource = WindowInsets.imeAnimationSource.getBottom(density)
    val imeCurrent = WindowInsets.ime.getBottom(density)
    val imeTarget = WindowInsets.imeAnimationTarget.getBottom(density)

    val imeSourceDp = with(density) { imeSource.toDp() }
    val imeCurrentDp = with(density) { imeCurrent.toDp() }
    val imeTargetDp = with(density) { imeTarget.toDp() }

    var textFieldValue by remember { mutableStateOf("") }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text("IME анимация") },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .imeNestedScroll(),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item { SectionLabel("imeAnimationSource") }
            item {
                ListItem(
                    headlineContent = { Text("imeAnimationSource (bottom)") },
                    supportingContent = { Text("значение ime в начале анимации") },
                    trailingContent = { Text("$imeSource px  ($imeSourceDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("ime — текущее значение") }
            item {
                ListItem(
                    headlineContent = { Text("WindowInsets.ime (bottom)") },
                    supportingContent = { Text("промежуточное значение во время анимации") },
                    trailingContent = { Text("$imeCurrent px  ($imeCurrentDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = if (imeCurrent > 0)
                            MaterialTheme.colorScheme.primaryContainer
                        else
                            MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("imeAnimationTarget") }
            item {
                ListItem(
                    headlineContent = { Text("imeAnimationTarget (bottom)") },
                    supportingContent = { Text("целевое значение после завершения анимации") },
                    trailingContent = { Text("$imeTarget px  ($imeTargetDp)") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("imeNestedScroll") }
            item {
                ListItem(
                    headlineContent = { Text("Modifier.imeNestedScroll()") },
                    supportingContent = {
                        Text(
                            "Применён к LazyColumn. Потяните список вниз, чтобы закрыть " +
                                "клавиатуру жестом. Работает только на API 30+."
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }

            item { SectionLabel("Откройте клавиатуру") }
            item {
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { textFieldValue = it },
                    label = { Text("Нажмите и наблюдайте за значениями выше") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .imePadding()
                )
            }
        }
    }
}
