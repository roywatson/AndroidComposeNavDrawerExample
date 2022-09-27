package com.delasystems.androidcomposenavdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.delasystems.androidcomposenavdrawer.navigation.NavDestinations
import com.delasystems.androidcomposenavdrawer.navigation.menuList
import com.delasystems.androidcomposenavdrawer.ui.screens.*
import com.delasystems.androidcomposenavdrawer.ui.theme.AndroidComposeNavDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeNavDrawerTheme {
                AndroidComposeNavDrawerApp()
            }
        }
    }
}

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        menuList.forEach {
            Spacer(Modifier.height(24.dp))
            Text(
                text = it.label,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.clickable {
                    onDestinationClicked(it.route)
                }
            )
        }
    }
}

@Composable
fun TopBar(title: String = "", buttonIcon: ImageVector, onButtonClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text( text = title)
        },
        navigationIcon = {
            IconButton(onClick =  {
                onButtonClicked()
            }) {
                Icon(buttonIcon, contentDescription = "" )
            }
        },
    )
}

@Composable
fun AndroidComposeNavDrawerApp() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = true,
            drawerContent = {
                Drawer(
                    onDestinationClicked = { route ->
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(route) {
                            popUpTo(NavDestinations.AlphaScreen.route)
                            launchSingleTop = true
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = NavDestinations.AlphaScreen.route
            ) {
                composable(NavDestinations.AlphaScreen.route) {
                    AlphaScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.BravoScreen.route) {
                    BravoScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.CharlieScreen.route) {
                    CharlieScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.DeltaScreen.route) {
                    DeltaScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.EchoScreen.route) {
                    EchoScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.FoxtrotScreen.route) {
                    FoxtrotScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.GolfScreen.route) {
                    GolfScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.HotelScreen.route) {
                    HotelScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.IndiaScreen.route) {
                    IndiaScreen(openDrawer = { openDrawer() })
                }
                composable(NavDestinations.AboutScreen.route) {
                    AboutScreen(openDrawer = { openDrawer() })
                }
            }
        }
    }
}