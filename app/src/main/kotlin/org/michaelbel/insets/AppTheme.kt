package org.michaelbel.insets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.expressiveLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialExpressiveTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else expressiveLightColorScheme(),
        content = content
    )
}

@Composable
fun SectionLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 4.dp)
    )
}

fun Int.formatInsetValue(dp: Dp): String {
    return "${this}.px (${dp.formatDp()})"
}

fun Dp.formatDp(): String {
    val rounded = value.roundToInt()
    return if (value == rounded.toFloat()) "${rounded}.dp" else "${value}.dp"
}

val Keyboard: ImageVector
    get() {
        if (_keyboard != null) {
            return _keyboard!!
        }
        _keyboard = ImageVector.Builder(
            name = "Keyboard",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(20.0f, 5.0f)
                lineTo(4.0f, 5.0f)
                curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f)
                lineTo(2.0f, 17.0f)
                curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
                horizontalLineToRelative(16.0f)
                curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
                lineTo(22.0f, 7.0f)
                curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f)
                close()
                moveTo(11.0f, 8.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(11.0f, 8.0f)
                close()
                moveTo(11.0f, 11.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(-2.0f)
                verticalLineToRelative(-2.0f)
                close()
                moveTo(8.0f, 8.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                lineTo(8.0f, 10.0f)
                lineTo(8.0f, 8.0f)
                close()
                moveTo(8.0f, 11.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                lineTo(8.0f, 13.0f)
                verticalLineToRelative(-2.0f)
                close()
                moveTo(7.0f, 13.0f)
                lineTo(5.0f, 13.0f)
                verticalLineToRelative(-2.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(7.0f, 10.0f)
                lineTo(5.0f, 10.0f)
                lineTo(5.0f, 8.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(16.0f, 17.0f)
                lineTo(8.0f, 17.0f)
                verticalLineToRelative(-2.0f)
                horizontalLineToRelative(8.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(16.0f, 13.0f)
                horizontalLineToRelative(-2.0f)
                verticalLineToRelative(-2.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(16.0f, 10.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(14.0f, 8.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(19.0f, 13.0f)
                horizontalLineToRelative(-2.0f)
                verticalLineToRelative(-2.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(19.0f, 10.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(17.0f, 8.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
            }
        }.build()
        return _keyboard!!
    }

val KeyboardHide: ImageVector
    get() {
        if (_keyboardHide != null) {
            return _keyboardHide!!
        }
        _keyboardHide = ImageVector.Builder(
            name = "KeyboardHide",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24.0f,
            viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(20.0f, 3.0f)
                lineTo(4.0f, 3.0f)
                curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f)
                lineTo(2.0f, 15.0f)
                curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
                horizontalLineToRelative(16.0f)
                curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
                lineTo(22.0f, 5.0f)
                curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f)
                close()
                moveTo(11.0f, 6.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(11.0f, 6.0f)
                close()
                moveTo(11.0f, 9.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(11.0f, 9.0f)
                close()
                moveTo(8.0f, 6.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                lineTo(8.0f, 8.0f)
                lineTo(8.0f, 6.0f)
                close()
                moveTo(8.0f, 9.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                lineTo(8.0f, 11.0f)
                lineTo(8.0f, 9.0f)
                close()
                moveTo(7.0f, 11.0f)
                lineTo(5.0f, 11.0f)
                lineTo(5.0f, 9.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(7.0f, 8.0f)
                lineTo(5.0f, 8.0f)
                lineTo(5.0f, 6.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(16.0f, 15.0f)
                lineTo(8.0f, 15.0f)
                verticalLineToRelative(-2.0f)
                horizontalLineToRelative(8.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(16.0f, 11.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(14.0f, 9.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(16.0f, 8.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(14.0f, 6.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(19.0f, 11.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(17.0f, 9.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(19.0f, 8.0f)
                horizontalLineToRelative(-2.0f)
                lineTo(17.0f, 6.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(2.0f)
                close()
                moveTo(12.0f, 23.0f)
                lineToRelative(4.0f, -4.0f)
                lineTo(8.0f, 19.0f)
                lineToRelative(4.0f, 4.0f)
                close()
            }
        }.build()
        return _keyboardHide!!
    }

private var _keyboard: ImageVector? = null
private var _keyboardHide: ImageVector? = null
