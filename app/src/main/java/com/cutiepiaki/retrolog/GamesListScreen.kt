package com.cutiepiaki.retrolog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items

@Composable
fun GamesListScreen(label: String) {
    val allGames = GameRepository.games
    val sortedGames = allGames.filter { game -> game.platform.label == label }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            item {
                Text("Список игр")
            }
            items(sortedGames) { game -> Text(game.title)}
        }
    }
}
