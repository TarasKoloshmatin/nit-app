package com.inquisitor.nit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.inquisitor.feature_login.navigation.LoginScreen
import com.inquisitor.feature_splash.ui.SplashScreen
import com.inquisitor.navigation.destination.LoginDestination
import com.inquisitor.navigation.destination.NavigationDestination
import com.inquisitor.navigation.destination.SplashDestination

private val composableDestinations: Map<NavigationDestination, @Composable () -> Unit> = mapOf(
    SplashDestination to { SplashScreen() },
    LoginDestination to { LoginScreen() }
)

fun NavGraphBuilder.addComposableDestinations() {
    composableDestinations.forEach { entry ->
        val destination = entry.key

        composable(destination.route(), destination.arguments, destination.deepLinks) {
            entry.value()
        }
    }
}