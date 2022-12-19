package com.example.notiesapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notiesapp.R
import com.example.notiesapp.navigation.NavRoute
import com.example.notiesapp.ui.theme.NotiesAppTheme

@Composable
fun AddScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var title by remember {
                mutableStateOf("")
            }
            var subtitle by remember {
                mutableStateOf("")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Вы находитесь на вкладке " +
                            "создать заметку",
                    modifier = Modifier.padding(bottom = 45.dp)
                )
                TextField(
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                        .width(300.dp),
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    singleLine = true
                )
                TextField(
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                        .width(300.dp),
                    value = subtitle,
                    onValueChange = {
                        subtitle = it
                    },
                    singleLine = true
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        navController.navigate(NavRoute.Main.route)
                    }
                ) {
                    Text(text = "Create new")
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bookmark),
                        contentDescription = "icon bookmark",
                        tint = Color.White
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun prewAddScreen() {
    NotiesAppTheme {
        AddScreen(rememberNavController())
    }
}