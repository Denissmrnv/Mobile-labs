package com.example.lab0.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.lab0.viewmodels.MainViewModel
import dagger.*

import dagger.hilt.android.lifecycle.*
@Composable
fun DetailScreen(navController: NavHostController, id: String?, viewModel: MainViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(4f)){
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = rememberAsyncImagePainter(viewModel.catsList[id!!.toInt()].url),
                    contentDescription = "cat",
                    contentScale = ContentScale.Crop
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(2f)){
                Column {
                    Row(
                        Modifier.padding(top = 10.dp, bottom = 10.dp)
                    ) {
                        Text("Name ${viewModel.catsList[id!!.toInt()].name}", style = MaterialTheme.typography.labelLarge,
                            fontSize = 20.sp)
                    }
                    Row {
                        Text("Test text",
                            style = MaterialTheme.typography.labelLarge, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}
