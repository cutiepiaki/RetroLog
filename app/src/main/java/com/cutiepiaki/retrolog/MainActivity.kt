package com.cutiepiaki.retrolog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cutiepiaki.retrolog.data.NavItem
import com.cutiepiaki.retrolog.data.PlatformLabel
import com.cutiepiaki.retrolog.navigation.PlatformButton
import com.cutiepiaki.retrolog.screens.ExploreScreen
import com.cutiepiaki.retrolog.screens.FavoriteScreen
import com.cutiepiaki.retrolog.screens.GamesListScreen
import com.cutiepiaki.retrolog.screens.HomeScreen
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
                            HomeScreen(navController)
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
}

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