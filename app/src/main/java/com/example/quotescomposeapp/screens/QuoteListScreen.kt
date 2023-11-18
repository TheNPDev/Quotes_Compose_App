package com.example.quotescomposeapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotescomposeapp.models.Quotes


@Composable
fun QuoteListScreen(data: Array<Quotes>, onClick: (quote:Quotes)->Unit){
    Column {
        Text(text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.titleMedium,
            fontSize = 20.sp
            )
        QuoteList(data = data, onClick)
    }
}