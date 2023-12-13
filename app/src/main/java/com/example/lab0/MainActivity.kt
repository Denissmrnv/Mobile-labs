package com.example.lab0

import MainViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab0.ui.screens.DetailScreen
import com.example.lab0.ui.screens.ListScreen
import com.example.lab0.ui.screens.LoginScreen
import com.example.lab0.ui.screens.SplashScreen
import com.example.lab0.ui.theme.NavRoutes
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(Modifier.fillMaxSize())
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Greeting(fillMaxSize: Modifier) {
    val viewModel: MainViewModel = viewModel()
    val navController = rememberAnimatedNavController()
    val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioMediumBouncy)
    AnimatedNavHost(
        navController = navController,
        startDestination = NavRoutes.Splash.route,
    ) {
        composable(NavRoutes.Splash.route)
        {
            SplashScreen(navController = navController)
        }
        composable(NavRoutes.Login.route,
            enterTransition = { ->
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = springSpec)
            },
            exitTransition = { ->
                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = springSpec)
            },
            popEnterTransition = { ->
                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = springSpec)
            },
            popExitTransition = { ->
                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = springSpec)
            }
            ) {
            LoginScreen(navController = navController)
        }
        composable(NavRoutes.List.route,
            enterTransition = { ->
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = springSpec)
            },
            exitTransition = { ->
                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = springSpec)
            },
            popEnterTransition = { ->
                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = springSpec)
            },
            popExitTransition = { ->
                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = springSpec)
            }) {
            ListScreen(navController = navController, viewModel)
        }
        composable(NavRoutes.Detail.route + "/{id}",
            enterTransition = { ->
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = springSpec)
            },
            exitTransition = { ->
                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = springSpec)
            },
            popEnterTransition = { ->
                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = springSpec)
            },
            popExitTransition = { ->
                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = springSpec)
            }) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
//            DetailScreen(navController = navController, id, viewModel)
            DetailScreen(navController = navController, id)
        }
    }
}
