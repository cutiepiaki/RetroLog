package com.cutiepiaki.retrolog.data

import androidx.compose.ui.graphics.vector.ImageVector
import com.cutiepiaki.retrolog.R

enum class PlatformLabel(val label: String, val icon: Int, val fullLabel: String) {
    GB("GB", R.drawable.gb, "Game Boy"),
    GBC("GBC", R.drawable.gbc, "Game Boy Color"),
    GBA("GBA", R.drawable.gba, "Game Boy Advance"),
    NES("NES", R.drawable.nes, "NES"),
    SNES("SNES", R.drawable.snes, "SNES"),
    SEGAMD("Sega MD", R.drawable.segamd, "Sega Mega Drive"),
    PS1("Sony PS1", R.drawable.ps1, "Playstation 1")
}

data class NavItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
)
