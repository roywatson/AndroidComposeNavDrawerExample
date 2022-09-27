package com.delasystems.androidcomposenavdrawer.navigation

sealed class NavDestinations(val route: String, val label: String) {
    object AlphaScreen : NavDestinations("alphascreen", "Alpha")
    object BravoScreen : NavDestinations("bravoscreen", "Bravo")
    object CharlieScreen : NavDestinations("charliescreen", "Charlie")
    object DeltaScreen : NavDestinations("deltascreen", "Delta")
    object EchoScreen : NavDestinations("echoscreen", "Echo")
    object FoxtrotScreen : NavDestinations("foxtrotscreen", "Foxtrot")
    object GolfScreen : NavDestinations("golfscreen", "Golf")
    object HotelScreen : NavDestinations("hotelscreen", "Hotel")
    object IndiaScreen : NavDestinations("indiascreen", "India")
    object AboutScreen : NavDestinations("aboutscreen", "About")
}

val menuList = listOf<NavDestinations>(
    NavDestinations.AlphaScreen,
    NavDestinations.BravoScreen,
    NavDestinations.CharlieScreen,
    NavDestinations.DeltaScreen,
    NavDestinations.EchoScreen,
    NavDestinations.FoxtrotScreen,
    NavDestinations.GolfScreen,
    NavDestinations.HotelScreen,
    NavDestinations.IndiaScreen,
    NavDestinations.AboutScreen
)