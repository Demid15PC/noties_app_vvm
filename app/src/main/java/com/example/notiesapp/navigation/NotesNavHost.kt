package com.example.notiesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notiesapp.screens.AddScreen
import com.example.notiesapp.screens.MainScreen
import com.example.notiesapp.screens.NoteScreen
import com.example.notiesapp.screens.StartScreen

sealed class NavRoute(val route: String) {
    object Start : NavRoute("start_screen")
    object Main : NavRoute("main_screen")
    object Add : NavRoute("add_screen")
    object Note : NavRoute("note_screen")
}

@Composable
fun NotesNavHost() {
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = NavRoute.Start.route
    ) {
        composable(NavRoute.Start.route) { StartScreen(navController = navigationController) }
        composable(NavRoute.Main.route) { MainScreen(navController = navigationController) }
        composable(NavRoute.Add.route) { AddScreen(navController = navigationController) }
        composable(NavRoute.Note.route) { NoteScreen(navController = navigationController) }
    }
}