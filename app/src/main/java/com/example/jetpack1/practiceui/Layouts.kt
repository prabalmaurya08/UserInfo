package com.example.jetpack1.practiceui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack1.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(){
    TopAppBar(
        title = {
            Text(text = "Top Bar")
        }
    )
}
@Composable
fun layout(){
    Column(modifier = Modifier.padding(all = 15.dp)) {
        Text(text = "This is Sample of Lazy Column")
        LazyColumn {
            items(10) {
                Card (modifier = Modifier.padding(8.dp)){
                    Row (modifier = Modifier.padding(8.dp)){
                        Image(painter = painterResource(id = R.drawable.boy), contentDescription = "boy",
                        modifier = Modifier.height(100.dp).fillMaxSize().border(2.dp, color = androidx.compose.ui.graphics.Color.Black))
                    }
                    Text(text = "This is Row", modifier = Modifier.fillMaxSize())
                }
            }

        }
    }

}
@Preview(showSystemUi = true)
@Composable
fun preview(){
    topBar()
    layout()
}