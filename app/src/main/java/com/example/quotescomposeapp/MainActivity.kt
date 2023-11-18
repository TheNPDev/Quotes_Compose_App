package com.example.quotescomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quotescomposeapp.models.DataManager
import com.example.quotescomposeapp.screens.QuoteDetail
import com.example.quotescomposeapp.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    if (DataManager.isDataLoaded.value){

        if (DataManager.currentPage.value == Pages.LISTING){
            QuoteListScreen(data = DataManager.data){
                DataManager.switchPages(it)
            }
        }
        else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }
    else{
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)) {
            Text(text = "Loading...",
                style = MaterialTheme.typography.headlineSmall)
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}
