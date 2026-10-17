package com.cutiepiaki.retrolog

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExploreScreen() {
    val allGames = GameRepository.games

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            item {
                Text("Список игр")
            }
            items(allGames) { game -> Text(game.title)}
        }
    }


}
@Preview
@Composable
fun ExplorePreview() {
    ExploreScreen()
}