package com.example.guiadoestudo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.guiadoestudo.data.local.Subject

@Composable
fun SubjectDetailScreen(
    subject: Subject,
    onBackClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = subject.name,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = subject.description,
            style = MaterialTheme.typography.bodyLarge
        )

        Button(onBackClick) {
            Text("Voltar")
        }
    }
}