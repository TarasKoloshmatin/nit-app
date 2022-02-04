package com.inquisitor.nit.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator {
    private val navigationEvents = Channel<NavigatorEvent>()

    override val destinations = navigationEvents.receiveAsFlow()

    override fun onCloseApp(): Boolean =
        navigationEvents.trySend(NavigatorEvent.CloseApp).isSuccess

    override fun onError(errorMessage: String): Boolean =
        navigationEvents.trySend(NavigatorEvent.Error(errorMessage = errorMessage)).isSuccess

    override fun navigateUp(): Boolean =
        navigationEvents.trySend(NavigatorEvent.NavigateUp).isSuccess

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean =
        navigationEvents.trySend(NavigatorEvent.Directions(route, builder)).isSuccess
}