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

@Composable
fun AddSubjectScreen(
    onSaveClick: (String, String) -> Unit,
    onBackClick: () -> Unit
){
    var name by remember { mutableStateOf("") }
    var description by remember {mutableStateOf("") }
    var showNameError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Text("Nova disciplina")

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                showNameError = false
                            },
            label = { Text("Nome da disciplina") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = showNameError
        )

        if (showNameError){
            Text("O nome da disciplina é obrigatório.")
        }

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if(name.isNotBlank()){
                    onSaveClick(name.trim(), description.trim())
                }else {
                    showNameError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Salvar disciplina")
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}