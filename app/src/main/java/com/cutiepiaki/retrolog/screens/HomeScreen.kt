package com.cutiepiaki.retrolog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cutiepiaki.retrolog.data.PlatformLabel
import com.cutiepiaki.retrolog.navigation.PlatformButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(innerPadding: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            PlatformButton(
                modifier = Modifier.weight(1f),
                label = PlatformLabel.GB.label,
                icon = PlatformLabel.GB.icon,
                onClick = { navController.navigate("games/${PlatformLabel.GB.label}") },
            )

            PlatformButton(
                modifier = Modifier.weight(1f),
                label = PlatformLabel.GBC.label,
                icon = PlatformLabel.GBC.icon,
                onClick = { navController.navigate("games/${PlatformLabel.GBC.label}") },
            )

            PlatformButton(
                modifier = Modifier.weight(1f),
                label = PlatformLabel.GBA.label,
                icon = PlatformLabel.GBA.icon,
                onClick = { navController.navigate("games/${PlatformLabel.GBA.label}") },
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PlatformButton(
                modifier = Modifier.weight(1f),
                label = PlatformLabel.NES.label,
                icon = PlatformLabel.NES.icon,
                onClick = { navController.navigate("games/${PlatformLabel.NES.label}") }
            )

            PlatformButton(
                modifier = Modifier.weight(1f),
                label = PlatformLabel.SNES.label,
                icon = PlatformLabel.SNES.icon,
                onClick = { navController.navigate("games/${PlatformLabel.SNES.label}") },
            )

            PlatformButton(
                modifier = Modifier.weight(1f),
                label = PlatformLabel.SEGAMD.label,
                icon = PlatformLabel.SEGAMD.icon,
                onClick = { navController.navigate("games/${PlatformLabel.SEGAMD.label}") },
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            PlatformButton(
                modifier = Modifier.weight(1f),
                label = PlatformLabel.PS1.label,
                icon = PlatformLabel.PS1.icon,
                onClick = { navController.navigate("games/${PlatformLabel.PS1.label}") },
            )
            Spacer(modifier = Modifier.weight(2f))
        }
    }
}