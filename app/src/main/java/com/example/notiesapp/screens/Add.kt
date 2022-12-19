package com.example.notiesapp.screens

import android.icu.text.AlphabeticIndex.Bucket.LabelType
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

              var title by remember { mutableStateOf("") }
              var subtitle by remember { mutableStateOf("") }

              Column(
                     modifier = Modifier.fillMaxSize(),
                     verticalArrangement = Arrangement.Center,
                     horizontalAlignment = Alignment.CenterHorizontally
              ) {

                     Text(
                            text = "Создать новую заметку",
                            modifier = Modifier.padding(bottom = 16.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                     )

                     OutlinedTextField(
                            modifier = Modifier
                                   .padding(bottom = 16.dp)
                                   .width(300.dp),
                            value = title,
                            label = { Text(text = "Note title") },
                            onValueChange = { title = it },
                            singleLine = true,
                     )

                     OutlinedTextField(
                            modifier = Modifier
                                   .padding(bottom = 25.dp)
                                   .width(300.dp),
                            value = subtitle,
                            label = { Text(text = "Note subtitle") },
                            onValueChange = { subtitle = it },
                            singleLine = true
                     )

                     Button(
                            modifier = Modifier.width(160.dp),
                            onClick = { navController.navigate(NavRoute.Main.route) }
                     ) {
                            Text(text = "Create new")
                            Spacer(modifier = Modifier.weight(2f))
                            Icon(
                                   painter = painterResource(id = R.drawable.ic_bookmark),
                                   contentDescription = "icon bookmark",
                                   tint = Color.White
                            )
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