package com.example.guiadoestudo.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.guiadoestudo.ui.screen.AddSubjectScreen
import com.example.guiadoestudo.ui.screen.HomeScreen
import com.example.guiadoestudo.ui.screen.SubjectDetailScreen
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
                viewModel = viewModel,
                onAddSubjectClick = {
                    navController.navigate("add_subject")
                },
                onSubjectClick = { subjectId ->
                    navController.navigate("subject_detail/$subjectId")
                }
            )
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

        composable("subject_detail/{subjectId}") { backStackEntry ->
            val subjectId = backStackEntry.arguments
                ?.getString("subjectId")
                ?.toIntOrNull()

            val subjects by viewModel.subjects.collectAsState()
            val subject = subjects.firstOrNull{
                it.id == subjectId
            }

            if (subject != null){
                SubjectDetailScreen(
                    subject = subject,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onDeleteClick = {
                        viewModel.deleteSubject(subject)
                        navController.popBackStack()
                    }
                )
            } else {
                Text("Disciplina não encontrada.")
            }
        }
    }

}