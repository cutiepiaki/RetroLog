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
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route
                            navItemList.forEach { item ->
                                NavigationBarItem(
                                    selected = currentRoute == item.route,
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
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Text(
                                    text = "Платформы",
                                    modifier = Modifier.padding(innerPadding.calculateTopPadding())
                                )

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
                        composable(
                            route = "games/{label}",
                            arguments = listOf(
                                navArgument("label") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val label = backStackEntry.arguments?.getString("label")
                            GamesListScreen(label = label ?: "")
                        }
                        composable("explore") {
                            ExploreScreen()
                        }
                        composable("favorite") {
                            FavoriteScreen()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun PlatformButton(
        label: String,
        icon: Int,
        onClick: () -> Unit,
        modifier: Modifier
    ) {
        Column(
            modifier
                .width(IntrinsicSize.Max)
                .clickable { onClick() }
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                contentScale = ContentScale.Fit
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

    enum class PlatformLabel(val label: String, val icon: Int) {
        GB("GB", R.drawable.gb),
        GBC("GBC", R.drawable.gbc),
        GBA("GBA", R.drawable.gba),
        NES("NES", R.drawable.nes),
        SNES("SNES", R.drawable.snes),
        SEGAMD("Sega MD", R.drawable.segamd),
        PS1("Sony PS1", R.drawable.ps1)
    }


    data class NavItem(
        val title: String,
        val icon: ImageVector,
        val route: String,
    )

    @Preview
    @Composable
    fun PlatformButtonPreview() {
        PlatformButton(
            modifier = Modifier,
            label = "GBA",
            icon = PlatformLabel.GBA.icon,
            onClick = {},
        )
    }
}


