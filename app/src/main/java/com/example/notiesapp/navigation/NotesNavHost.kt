package com.example.notiesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notiesapp.screens.Add
import com.example.notiesapp.screens.Main
import com.example.notiesapp.screens.Note
import com.example.notiesapp.screens.Start

sealed class NavRoute(val route: String){
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")
}

@Composable
fun NotesNavHost() {
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = NavRoute.Start.route
    ){
        composable(NavRoute.Start.route){Start(navController = navigationController)}
        composable(NavRoute.Main.route){ Main(navController = navigationController) }
        composable(NavRoute.Add.route){ Add(navController = navigationController) }
        composable(NavRoute.Note.route){ Note(navController = navigationController) }
    }
}