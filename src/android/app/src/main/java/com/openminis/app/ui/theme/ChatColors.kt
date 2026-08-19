package com.openminis.app.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Semantic chat palette used by the Android agent UI.
 *
 * This fork deliberately keeps the interaction language monochrome. All
 * borders are transparent; depth is expressed through neutral surface steps
 * instead of strokes or strong shadows.
 */
@Immutable
data class ChatPalette(
    val isDark: Boolean,
    val background: Color,
    val secondaryBg: Color,
    val inputBg: Color,
    val inputIconBg: Color,
    val inputIconBorder: Color,
    val inputBorder: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val tertiaryText: Color,
    val disabledText: Color,
    val userBubble: Color,
    val toolBg: Color,
    val toolBorder: Color,
    val toolCapsuleBg: Color,
    val separator: Color,
    val sendButton: Color,
    val sendButtonDisabled: Color,
    val codeBlockBg: Color,
    val codeBlockText: Color,
    val inlineCodeBg: Color,
    val inlineCodeText: Color,
    val link: Color,
    val blockquoteBar: Color,
    val thinking: Color,
    val warningBg: Color,
    val warningText: Color,
    val tableBorder: Color,
    val inputShadow: Color,
    val toastBg: Color,
    val thumbnailBorder: Color,
    val sheetHeaderBg: Color,
    val sheetHeaderBorder: Color,
    val fabAccent: Color,
)

val LightChatPalette = ChatPalette(
    isDark = false,
    background = Color(0xFFF7F7F8),
    secondaryBg = Color(0xFFEDEDEF),
    inputBg = Color(0xFFFFFFFF),
    inputIconBg = Color(0xFFE4E4E7),
    inputIconBorder = Color.Transparent,
    inputBorder = Color.Transparent,
    primaryText = Color(0xFF111113),
    secondaryText = Color(0xFF52525B),
    tertiaryText = Color(0xFF71717A),
    disabledText = Color(0xFFB4B4BB),
    userBubble = Color(0xFFE4E4E7),
    toolBg = Color(0xFFFFFFFF),
    toolBorder = Color.Transparent,
    toolCapsuleBg = Color(0xFFEDEDEF),
    separator = Color.Transparent,
    sendButton = Color(0xFF111113),
    sendButtonDisabled = Color(0xFFD4D4D8),
    codeBlockBg = Color(0xFF111113),
    codeBlockText = Color(0xFFF4F4F5),
    inlineCodeBg = Color(0xFFE4E4E7),
    inlineCodeText = Color(0xFF27272A),
    link = Color(0xFF27272A),
    blockquoteBar = Color(0xFF71717A),
    thinking = Color(0xFF52525B),
    warningBg = Color(0xFFE4E4E7),
    warningText = Color(0xFF3F3F46),
    tableBorder = Color.Transparent,
    inputShadow = Color.Transparent,
    toastBg = Color(0xEE18181B),
    thumbnailBorder = Color.Transparent,
    sheetHeaderBg = Color(0xFFFFFFFF),
    sheetHeaderBorder = Color.Transparent,
    fabAccent = Color(0xFF111113),
)

val DarkChatPalette = ChatPalette(
    isDark = true,
    background = Color(0xFF09090B),
    secondaryBg = Color(0xFF18181B),
    inputBg = Color(0xFF18181B),
    inputIconBg = Color(0xFF27272A),
    inputIconBorder = Color.Transparent,
    inputBorder = Color.Transparent,
    primaryText = Color(0xFFFAFAFA),
    secondaryText = Color(0xFFA1A1AA),
    tertiaryText = Color(0xFF71717A),
    disabledText = Color(0xFF52525B),
    userBubble = Color(0xFF27272A),
    toolBg = Color(0xFF18181B),
    toolBorder = Color.Transparent,
    toolCapsuleBg = Color(0xFF27272A),
    separator = Color.Transparent,
    sendButton = Color(0xFFFAFAFA),
    sendButtonDisabled = Color(0xFF3F3F46),
    codeBlockBg = Color(0xFF111113),
    codeBlockText = Color(0xFFE4E4E7),
    inlineCodeBg = Color(0xFF27272A),
    inlineCodeText = Color(0xFFE4E4E7),
    link = Color(0xFFD4D4D8),
    blockquoteBar = Color(0xFF71717A),
    thinking = Color(0xFFA1A1AA),
    warningBg = Color(0xFF27272A),
    warningText = Color(0xFFD4D4D8),
    tableBorder = Color.Transparent,
    inputShadow = Color.Transparent,
    toastBg = Color(0xEEFAFAFA),
    thumbnailBorder = Color.Transparent,
    sheetHeaderBg = Color(0xFF18181B),
    sheetHeaderBorder = Color.Transparent,
    fabAccent = Color(0xFFFAFAFA),
)

val LocalChatPalette = compositionLocalOf { LightChatPalette }

val ChatColors: ChatPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalChatPalette.current
