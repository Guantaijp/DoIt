package com.example.doit

sealed class NavigationItem(
    var route: String,
    var icon: Int,
    var title: String

){
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Search : NavigationItem("Search", R.drawable.ic_search, "Music")
    object Favourite : NavigationItem("Favourite", R.drawable.ic_favorite, "Movies")
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
}