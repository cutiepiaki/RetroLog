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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                val navItemList = listOf(
                    NavItem("Home", Icons.Default.Home, "home"),
                    NavItem("Explore", Icons.Default.Search, "explore"),
                    NavItem("Favorite", Icons.Default.Star, "favorite"),
                )
                var selectedIndex by remember {
                    mutableIntStateOf(0)
                }
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        Scaffold(
                            modifier = Modifier.fillMaxSize(),
                            bottomBar = {
                                NavigationBar {
                                    navItemList.forEachIndexed { index, item ->
                                        NavigationBarItem(
                                            selected = selectedIndex == index,
                                            onClick = {
                                                navController.navigate(item.route)
                                            },
                                            icon = {
                                                Icon(imageVector = item.icon, contentDescription = null)
                                            },
                                            label = {
                                                Text(text = item.title)
                                            },
                                        )
                                    }
                                }
                            }
                        ) { innerPadding ->
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Платформы",
                                    modifier = Modifier.padding(innerPadding.calculateTopPadding())
                                )

                                Row (
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
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
                                    modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
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
                                    modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
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
                    composable("explore") {
                        ExploreScreen()
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


    data class NavItem(
        val title: String,
        val icon: ImageVector,
        val route: String,
    )

//    @Composable
//    fun NavigationBar(
//        navController: NavController,
//        color: Color = MaterialTheme.colorScheme.primary
//    ) {}

    @Preview
    @Composable
    fun PlatformButtonPreview() {
        PlatformButton(
            label = "GBA",
            onClick = {}
        )
    }

}



