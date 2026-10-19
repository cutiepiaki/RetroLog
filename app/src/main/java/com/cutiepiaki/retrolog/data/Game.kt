package com.cutiepiaki.retrolog.data

data class Game(
    val id: Int,
    val title: String,
    val genre: String,
    val platform: PlatformLabel,
    val isCompleted: Boolean = false
)