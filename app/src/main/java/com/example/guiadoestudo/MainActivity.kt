package com.example.guiadoestudo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.guiadoestudo.data.local.DatabaseProvider
import com.example.guiadoestudo.data.repository.SubjectRepository
import com.example.guiadoestudo.ui.theme.GuiaDoEstudoTheme
import com.example.guiadoestudo.ui.viewmodel.SubjectViewModel
import com.example.guiadoestudo.ui.viewmodel.SubjectViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = DatabaseProvider.getDatabase(applicationContext)
        val repository = SubjectRepository(database.subjectDao())
        val factory = SubjectViewModelFactory(repository)

        setContent {
            val viewModel: SubjectViewModel = viewModel(factory=factory)

            StudyTrackApp(viewModel)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuiaDoEstudoTheme {
        Greeting("Android")
    }
}