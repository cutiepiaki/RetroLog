package com.cutiepiaki.retrolog

data class Game(
    val id: Int,
    val title: String,
    val genre: String,
    val platform: MainActivity.PlatformLabel,
    val isCompleted: Boolean = false
)
