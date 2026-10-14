package com.example.guiadoestudo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.guiadoestudo.data.local.Subject

@Composable
fun EditSubjectScreen(
    subject: Subject,
    onSaveClick: (String, String) -> Unit,
    onBackClick: () -> Unit
){
    var name by remember(subject.id) {
        mutableStateOf(subject.name)
    }

    var description by remember(subject.id) {
        mutableStateOf(subject.description)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Editar disciplina")

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { "Nome da disciplina"},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth(),
        )

        Button(
            onClick = {
                if (name.isNotBlank()){
                    onSaveClick(name.trim(), description.trim())
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar alterações")
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}