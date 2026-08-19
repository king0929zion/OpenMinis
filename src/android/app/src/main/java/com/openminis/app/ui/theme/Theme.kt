package com.openminis.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

/**
 * OpenMinis monochrome design system.
 *
 * The UI intentionally avoids chromatic accent colors, visible outlines and
 * pronounced elevation. Hierarchy comes from neutral surface contrast,
 * typography and generous rounded geometry instead of borders/shadows.
 */
private val Ink = Color(0xFF111113)
private val InkMuted = Color(0xFF52525B)
private val InkSoft = Color(0xFF71717A)
private val Paper = Color(0xFFFAFAFA)
private val Canvas = Color(0xFFF2F2F3)
private val Card = Color(0xFFFFFFFF)
private val CardRaised = Color(0xFFF7F7F8)
private val Tonal = Color(0xFFE4E4E7)
private val TonalStrong = Color(0xFFD4D4D8)

private val Night = Color(0xFF09090B)
private val NightCard = Color(0xFF18181B)
private val NightRaised = Color(0xFF222225)
private val NightTonal = Color(0xFF27272A)
private val NightTonalStrong = Color(0xFF3F3F46)
private val Snow = Color(0xFFFAFAFA)
private val SnowMuted = Color(0xFFA1A1AA)
private val SnowSoft = Color(0xFF71717A)

private val LightColorScheme = lightColorScheme(
    primary = Ink,
    onPrimary = Color.White,
    primaryContainer = Tonal,
    onPrimaryContainer = Ink,
    inversePrimary = Snow,
    secondary = InkMuted,
    onSecondary = Color.White,
    secondaryContainer = Tonal,
    onSecondaryContainer = Ink,
    tertiary = InkSoft,
    onTertiary = Color.White,
    tertiaryContainer = TonalStrong,
    onTertiaryContainer = Ink,
    background = Canvas,
    onBackground = Ink,
    surface = Canvas,
    onSurface = Ink,
    surfaceVariant = Card,
    onSurfaceVariant = InkMuted,
    surfaceContainerLowest = Canvas,
    surfaceContainerLow = Card,
    surfaceContainer = Card,
    surfaceContainerHigh = CardRaised,
    surfaceContainerHighest = Tonal,
    inverseSurface = Ink,
    inverseOnSurface = Snow,
    outline = Color.Transparent,
    outlineVariant = Color.Transparent,
    scrim = Color.Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = Snow,
    onPrimary = Night,
    primaryContainer = NightTonalStrong,
    onPrimaryContainer = Snow,
    inversePrimary = Ink,
    secondary = SnowMuted,
    onSecondary = Night,
    secondaryContainer = NightTonal,
    onSecondaryContainer = Snow,
    tertiary = SnowSoft,
    onTertiary = Night,
    tertiaryContainer = NightTonalStrong,
    onTertiaryContainer = Snow,
    background = Night,
    onBackground = Snow,
    surface = Night,
    onSurface = Snow,
    surfaceVariant = NightCard,
    onSurfaceVariant = SnowMuted,
    surfaceContainerLowest = Night,
    surfaceContainerLow = NightCard,
    surfaceContainer = NightCard,
    surfaceContainerHigh = NightRaised,
    surfaceContainerHighest = NightTonal,
    inverseSurface = Snow,
    inverseOnSurface = Night,
    outline = Color.Transparent,
    outlineVariant = Color.Transparent,
    scrim = Color.Black,
)

/** Primary floating action color follows the monochrome theme. */
@Composable
fun minisFabColor(): Color = LocalChatPalette.current.fabAccent

/**
 * Oversized corner system. Even compact controls stay soft and rounded while
 * sheets/dialogs use a near-squircle 36dp radius. Pill controls can still opt
 * into RoundedCornerShape(50) / 999.dp explicitly.
 */
private val MinisShapes = Shapes(
    extraSmall = RoundedCornerShape(18.dp),
    small = RoundedCornerShape(22.dp),
    medium = RoundedCornerShape(28.dp),
    large = RoundedCornerShape(32.dp),
    extraLarge = RoundedCornerShape(36.dp),
)

@Composable
fun MinisTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    fontScale: Float = 1f,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val typography = scaledTypography(fontScale)
    val chatPalette = if (darkTheme) DarkChatPalette else LightChatPalette

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = MinisShapes,
        typography = typography,
    ) {
        CompositionLocalProvider(LocalChatPalette provides chatPalette, content = content)
    }
}

private fun TextStyle.scale(factor: Float): TextStyle =
    if (factor == 1f) this else copy(fontSize = fontSize * factor)

private fun scaledTypography(factor: Float): Typography {
    val base = Typography()
    return Typography(
        displayLarge = base.displayLarge.scale(factor),
        displayMedium = base.displayMedium.scale(factor),
        displaySmall = base.displaySmall.scale(factor),
        headlineLarge = base.headlineLarge.scale(factor),
        headlineMedium = base.headlineMedium.scale(factor),
        headlineSmall = base.headlineSmall.scale(factor),
        titleLarge = base.titleLarge.scale(factor),
        titleMedium = base.titleMedium.scale(factor),
        titleSmall = base.titleSmall.scale(factor),
        bodyLarge = base.bodyLarge.scale(factor),
        bodyMedium = base.bodyMedium.scale(factor),
        bodySmall = base.bodySmall.scale(factor),
        labelLarge = base.labelLarge.scale(factor),
        labelMedium = base.labelMedium.scale(factor),
        labelSmall = base.labelSmall.scale(factor),
    )
}
