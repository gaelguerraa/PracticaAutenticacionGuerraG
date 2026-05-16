package gael.guerra.practicaautenticacion2guerrag

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import gael.guerra.practicaautenticacion2guerrag.presentacion.home.HomeScreen
import gael.guerra.practicaautenticacion2guerrag.presentacion.initial.InitialScreen
import gael.guerra.practicaautenticacion2guerrag.presentacion.login.LoginScreen
import gael.guerra.practicaautenticacion2guerrag.presentacion.signup.SignUpScreen


@Composable
fun NavigationWrapper(
    navHostController: NavHostController,
    auth: FirebaseAuth
) {
    // Cambiamos el startDestination a "initial" para ver el flujo de login
    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHostController.navigate("logIn") },
                navigateToSignUp = { navHostController.navigate("signUp") }
            )
        }
        composable("logIn") {
            LoginScreen(auth) { navHostController.navigate("home") }
        }
        composable("signUp") {
            // Pasamos un callback para navegar al home tras el registro
            SignUpScreen(auth) { navHostController.navigate("home") }
        }
        composable("home") {
            HomeScreen()
        }
    }
}
