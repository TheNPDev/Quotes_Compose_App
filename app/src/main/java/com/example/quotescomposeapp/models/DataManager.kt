package com.example.quotescomposeapp.models

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotescomposeapp.Pages
import com.google.gson.Gson

object DataManager {


 var currentQuote : Quotes? = null
 var currentPage = mutableStateOf(Pages.LISTING)
 var data = emptyArray<Quotes>()
 var isDataLoaded = mutableStateOf(false)

 fun loadAssetsFromFile(context: Context){
  val inputStream = context.assets.open("quotes.json")
  val size = inputStream.available()
  val buffer = ByteArray(size)
  inputStream.read(buffer)
  inputStream.close()
  val json = String(buffer,Charsets.UTF_8)
  val gson = Gson()
  data = gson.fromJson(json,Array<Quotes>::class.java)
  isDataLoaded.value = true
 }

 fun switchPages(quote: Quotes?){
  if(currentPage.value == Pages.LISTING){
   currentQuote = quote
   currentPage.value = Pages.DETAIL
  }
  else{
   currentPage.value = Pages.LISTING
  }
 }
}

