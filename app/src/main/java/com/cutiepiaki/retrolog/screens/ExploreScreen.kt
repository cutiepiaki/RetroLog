package com.cutiepiaki.retrolog.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cutiepiaki.retrolog.data.GameRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(innerPadding: PaddingValues) {
    val allGames = GameRepository.games
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        items(allGames) { game ->
            ListItem(
                headlineContent = { Text(game.title) },
                modifier = Modifier
                    .clickable {

                    }
            )
            HorizontalDivider()
        }
    }
}
