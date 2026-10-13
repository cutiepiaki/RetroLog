package com.cutiepiaki.retrolog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cutiepiaki.retrolog.ui.theme.RetroLogTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetroLogTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Платформы",
                                    modifier = Modifier.padding(innerPadding)
                                )

                                Row {
                                    PlatformButton(label = PlatformLabel.GB.label) {
                                        navController.navigate("games/${PlatformLabel.GB.label}")
                                    }

                                    PlatformButton(label = PlatformLabel.GBC.label) {
                                        navController.navigate("games/${PlatformLabel.GBC.label}")
                                    }

                                    PlatformButton(label = PlatformLabel.GBA.label) {
                                        navController.navigate("games/{${PlatformLabel.GBA.label}")
                                    }
                                }

                                Row(
                                    modifier = Modifier.padding(vertical = 10.dp)
                                ) {
                                    PlatformButton(label = PlatformLabel.NES.label) {
                                        navController.navigate("games/${PlatformLabel.NES.label}")
                                    }

                                    PlatformButton(label = PlatformLabel.SNES.label) {
                                        navController.navigate("games/${PlatformLabel.SNES.label}")
                                    }

                                    PlatformButton(label = PlatformLabel.SEGAMD.label) {
                                        navController.navigate("games/${PlatformLabel.SEGAMD.label}")
                                    }
                                }
                                Row(
                                    modifier = Modifier.padding(vertical = 10.dp)
                                ) {
                                    PlatformButton(label = PlatformLabel.PS1.label) {
                                        navController.navigate("games/${PlatformLabel.PS1.label}")
                                    }
                                }
                            }
                        }
                    }

                    composable(
                        route = "games/{label}",
                        arguments = listOf(
                            navArgument("label") {type = NavType.StringType}
                        )
                    ) { backStackEntry ->
                        val label = backStackEntry.arguments?.getString("label")
                        GamesListScreen(label = label ?: "")
                    }

                }
            }
        }
    }


    @Composable
    fun PlatformButton(
        label: String,
        modifier: Modifier = Modifier,
        onClick: () -> Unit = {}
    ) {
        Button(
            shape = RectangleShape,
            onClick = onClick,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .width(130.dp)
                .height(130.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = modifier
                        .weight(5f)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text("*IMAGE*")
                }

                Box(
                    modifier = modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondary),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(label)
                }
            }
        }
    }
    enum class PlatformLabel(val label: String){
        GB("GB"),
        GBC("GBC"),
        GBA("GBA"),
        NES("NES"),
        SNES("SNES"),
        SEGAMD("Sega MD"),
        PS1("Sony PS1")
    }
}