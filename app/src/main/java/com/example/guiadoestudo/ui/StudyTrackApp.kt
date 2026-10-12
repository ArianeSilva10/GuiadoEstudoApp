package com.example.guiadoestudo.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.guiadoestudo.ui.screen.AddSubjectScreen
import com.example.guiadoestudo.ui.screen.HomeScreen
import com.example.guiadoestudo.ui.viewmodel.SubjectViewModel

@Composable
fun StudyTrackApp(
    viewModel: SubjectViewModel
){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home") {
            HomeScreen(
                onAddSubjectClick = {
                    navController.navigate("add_subject")
                })
        }

        composable("add_subject") {
            AddSubjectScreen(
                onSaveClick = { name, description ->
                    viewModel.addSubject(name,description)
                    navController.popBackStack()
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }

}