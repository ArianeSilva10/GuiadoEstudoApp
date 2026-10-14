package com.example.guiadoestudo.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.guiadoestudo.ui.viewmodel.SubjectViewModel

@Composable
fun HomeScreen(
    viewModel: SubjectViewModel,
    onAddSubjectClick: () -> Unit,
    onSubjectClick: (Int) -> Unit
){
    val subjects by viewModel.subjects.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Guia do Estudo",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Disciplinas cadastradas: ${subjects.size}",
            style = MaterialTheme.typography.bodyLarge
        )

        Button(
            onClick = onAddSubjectClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            Text("+ Adicionar disciplina")
        }

        if (subjects.isEmpty()){
            Text("Nenhuma disciplina cadastrada ainda.")
        }else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(subjects, key = { it.id }) { subject ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable{
                                onSubjectClick(subject.id)
                            },
                        elevation = androidx.compose.material3.CardDefaults
                            .cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = subject.name,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(text = subject.description)
                        }
                    }
                }
            }
        }
    }
}