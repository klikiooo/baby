package com.example.zawadiland.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zawadiland.ui.theme.screens.home.HomeScreen
import com.example.zawadiland.ui.theme.screens.login.LoginScreen
import com.example.zawadiland.ui.theme.screens.signup.SignupScreen
import com.example.zawadiland.ui.theme.screens.splash.splashscreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController:NavHostController = rememberNavController(), startDestination:String = ROUT_SPLASH) {
    NavHost(navController = navController, modifier=modifier, startDestination = startDestination){
        composable(ROUT_SPLASH){
            splashscreen(navController)
        }

        composable(ROUT_LOGIN){
            LoginScreen(navController)
        }

        composable(ROUT_SIGNUP){
            SignupScreen(navController)
        }
        composable(ROUT_HOME){
           HomeScreen(navController)
        }

        }
    }
