package com.example.lab0.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lab0.ui.theme.NavRoutes
import coil.compose.rememberAsyncImagePainter
import com.example.lab0.data.Cat
import com.example.lab0.viewmodels.MainViewModel
import androidx.compose.foundation.Image as Image


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavHostController, viewModel: MainViewModel) {
    val text = remember { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current

        LaunchedEffect(context) {
            viewModel.requestCatList()
        }
        Column {
            OutlinedTextField(
                value = text.value,
                onValueChange = {
                    viewModel.loading = true
                    text.value = it
                    if (text.value == "") {
                        viewModel.requestCatList()
                    } else {
                        viewModel.requestCatListByName(text.value)
                    }
                }
            )
        }
        Column {
            if (viewModel.loading) {
                CircularProgressIndicator()
            } else if (viewModel.errorMessage !== "") {
                Text(
                    modifier = Modifier.padding(all = 8.dp),
                    textAlign = TextAlign.Center,
                    text = viewModel.errorMessage,
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.Red
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CatsList(cats = viewModel.catsList, navController)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CatsList(cats: ArrayList<Cat>, navController: NavHostController) {
    LazyVerticalStaggeredGrid(

        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(cats.size) { index ->

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                    modifier = Modifier
                        .size(width = 240.dp, height = 100.dp)
                        .clickable {
                            navController.navigate(NavRoutes.Detail.route + "/$index")
                        }

                ) {
                    Image(
                        modifier = Modifier.size(50.dp, 50.dp),
                        painter = rememberAsyncImagePainter(cats[index].url),
                        contentDescription = "cat",
                        contentScale = ContentScale.Crop,
                    )
                    Text(
                        text = cats[index].name,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
