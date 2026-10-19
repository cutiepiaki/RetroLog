package com.cutiepiaki.retrolog.data

import androidx.compose.ui.graphics.vector.ImageVector
import com.cutiepiaki.retrolog.R

enum class PlatformLabel(val label: String, val icon: Int) {
    GB("GB", R.drawable.gb),
    GBC("GBC", R.drawable.gbc),
    GBA("GBA", R.drawable.gba),
    NES("NES", R.drawable.nes),
    SNES("SNES", R.drawable.snes),
    SEGAMD("Sega MD", R.drawable.segamd),
    PS1("Sony PS1", R.drawable.ps1)
}

data class NavItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
)
