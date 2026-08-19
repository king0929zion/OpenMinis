package com.openminis.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Shared settings layout for the monochrome redesign.
 *
 * Cards are intentionally borderless and flat. The extra-large radius and
 * neutral surface steps provide grouping without separators or strokes.
 */
object SectionDesign {
    val ScreenHorizontalPadding = 16.dp
    val CardShape = RoundedCornerShape(28.dp)
    val FirstSectionTopGap = 18.dp
    val SectionTopGap = 26.dp
    val HeaderToCardGap = 10.dp
    val CardToFooterGap = 10.dp
    val InterRowGap = 6.dp
    val RowMinHeight = 52.dp
    val TextFieldMinHeight = 56.dp
    val RowHorizontalPadding = 18.dp
    val RowVerticalPadding = 12.dp
    val CardInnerVerticalPadding = 8.dp

    // Kept for source compatibility. The redesigned UI does not draw dividers.
    val DividerThickness = 0.dp
    val DividerStartInset = 0.dp

    @Composable
    @ReadOnlyComposable
    fun cardColor(): Color = MaterialTheme.colorScheme.surfaceContainerLow

    @Composable
    @ReadOnlyComposable
    fun screenBackgroundColor(): Color = MaterialTheme.colorScheme.background

    @Composable
    @ReadOnlyComposable
    fun dividerColor(): Color = Color.Transparent

    @Composable
    @ReadOnlyComposable
    fun footerColor(): Color = MaterialTheme.colorScheme.onSurfaceVariant
}

@Composable
fun SectionHeader(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier.padding(
            start = SectionDesign.ScreenHorizontalPadding + 4.dp,
            end = SectionDesign.ScreenHorizontalPadding + 4.dp,
            bottom = SectionDesign.HeaderToCardGap,
        ),
    )
}

@Composable
fun SectionFooter(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = SectionDesign.footerColor(),
        modifier = modifier.padding(
            start = SectionDesign.ScreenHorizontalPadding + 4.dp,
            end = SectionDesign.ScreenHorizontalPadding + 4.dp,
            top = SectionDesign.CardToFooterGap,
        ),
    )
}

@Composable
fun SectionCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        color = SectionDesign.cardColor(),
        shape = SectionDesign.CardShape,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = SectionDesign.ScreenHorizontalPadding),
    ) {
        Column(
            modifier = Modifier.padding(vertical = SectionDesign.CardInnerVerticalPadding),
            content = content,
        )
    }
}

/**
 * Compatibility replacement for legacy row dividers. A tiny breathing gap is
 * used instead of a visible line so call sites retain their rhythm without a
 * stroke.
 */
@Composable
fun SectionDivider() {
    Spacer(Modifier.height(2.dp))
}

@Composable
fun RowLabel(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier.padding(bottom = 7.dp),
    )
}
