@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3ExpressiveApi::class
)

package org.michaelbel.insets.sample03_Ime

import androidx.compose.foundation.background
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import org.michaelbel.insets.Keyboard
import org.michaelbel.insets.KeyboardHide
import org.michaelbel.insets.SectionLabel
import org.michaelbel.insets.formatInsetValue

@Composable
fun Sample03Screen() {
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    var keyboardAnchor by remember { mutableStateOf("") }

    val ime = WindowInsets.ime

    val imeTop = ime.getTop(density)
    val imeBottom = ime.getBottom(density)
    val imeLeft = ime.getLeft(density, layoutDirection)
    val imeRight = ime.getRight(density, layoutDirection)

    val hasIme = imeTop > 0 || imeBottom > 0 || imeLeft > 0 || imeRight > 0

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(ListItemDefaults.SegmentedGap)
        ) {
            item {
                TopAppBar(
                    title = { Text("WindowInsets.ime") },
                    actions = {
                        IconButton(
                            onClick = {
                                if (hasIme) {
                                    keyboardController?.hide()
                                    focusManager.clearFocus()
                                } else {
                                    focusRequester.requestFocus()
                                    keyboardController?.show()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = if (hasIme) KeyboardHide else Keyboard,
                                contentDescription = if (hasIme) "Скрыть клавиатуру" else "Показать клавиатуру"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                )
            }
            item { SectionLabel("Обнаружение") }
            item {
                ListItem(
                    headlineContent = { Text("ime присутствует") },
                    trailingContent = { Text(if (hasIme) "TRUE" else "FALSE") },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item { SectionLabel("Отступы") }
            item {
                val topDp = with(density) { imeTop.toDp() }
                ListItem(
                    headlineContent = { Text("Top") },
                    trailingContent = { Text(imeTop.formatInsetValue(topDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val bottomDp = with(density) { imeBottom.toDp() }
                ListItem(
                    headlineContent = { Text("Bottom") },
                    trailingContent = { Text(imeBottom.formatInsetValue(bottomDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val leftDp = with(density) { imeLeft.toDp() }
                ListItem(
                    headlineContent = { Text("Left") },
                    trailingContent = { Text(imeLeft.formatInsetValue(leftDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
            item {
                val rightDp = with(density) { imeRight.toDp() }
                ListItem(
                    headlineContent = { Text("Right") },
                    trailingContent = { Text(imeRight.formatInsetValue(rightDp)) },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
                    )
                )
            }
        }
        BasicTextField(
            value = keyboardAnchor,
            onValueChange = { keyboardAnchor = it },
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(1.dp)
                .alpha(0F)
                .focusRequester(focusRequester)
        )
    }
}
