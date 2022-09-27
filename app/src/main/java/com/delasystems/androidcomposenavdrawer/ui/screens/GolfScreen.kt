package com.delasystems.androidcomposenavdrawer.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.delasystems.androidcomposenavdrawer.TopBar
import com.delasystems.androidcomposenavdrawer.navigation.NavDestinations
import com.delasystems.androidcomposenavdrawer.ui.misc.Attribution

@Composable
fun GolfScreen(openDrawer: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
    ) {
        TopBar(
            title = NavDestinations.GolfScreen.label,
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Attribution()
                Spacer(Modifier.height(24.dp))
                Text(
                    text = "Golf",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.clickable { },
                )
            }
        }
    }
}