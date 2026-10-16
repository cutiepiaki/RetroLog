package com.cutiepiaki.retrolog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cutiepiaki.retrolog.ui.theme.RetroLogTheme

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
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Text(
                                    text = "Платформы",
                                    modifier = Modifier.padding(innerPadding)
                                )

                                Row (
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ){
                                    PlatformButton(
                                        label = PlatformLabel.GB.label,
                                        onClick = { navController.navigate("games/${PlatformLabel.GB.label}") }
                                    )

                                    PlatformButton(
                                        label = PlatformLabel.GBC.label,
                                        onClick = { navController.navigate("games/${PlatformLabel.GBC.label}") }
                                    )

                                    PlatformButton(
                                        label = PlatformLabel.GBA.label,
                                        onClick = { navController.navigate("games/${PlatformLabel.GBA.label}") }
                                    )
                                }

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    PlatformButton(
                                        label = PlatformLabel.NES.label,
                                        onClick = { navController.navigate("games/${PlatformLabel.NES.label}") }
                                    )

                                    PlatformButton(
                                        label = PlatformLabel.SNES.label,
                                        onClick = { navController.navigate("games/${PlatformLabel.SNES.label}") }
                                    )

                                    PlatformButton(
                                        label = PlatformLabel.SEGAMD.label,
                                        onClick = { navController.navigate("games/${PlatformLabel.SEGAMD.label}") }
                                    )
                                }
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                ) {
                                    PlatformButton(
                                        label = PlatformLabel.PS1.label,
                                        onClick = { navController.navigate("games/${PlatformLabel.PS1.label}") }
                                    )
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
        onClick: () -> Unit
    ) {
        Column(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .clickable { onClick() }
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
            )
            Text(
                text = label,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary),
                textAlign = TextAlign.Center
            )
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

    @Preview
    @Composable
    fun PlatformButtonPreview() {
        PlatformButton(
            label = "GBA",
            onClick = {}
        )
    }

}



