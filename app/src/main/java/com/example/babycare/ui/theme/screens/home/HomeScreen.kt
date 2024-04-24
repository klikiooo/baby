package com.example.zawadiland.ui.theme.screens.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.babycare.R
import com.example.zawadiland.navigation.ROUT_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.a),
            contentScale = ContentScale.FillBounds
        )) {


        var mContext = LocalContext.current

        //TopAppBar
        TopAppBar(
            title = { Text(text = "Guide Newborn Care", color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Blue),
            navigationIcon = {
                IconButton(onClick = {
                    mContext.startActivity(Intent(mContext, ROUT_LOGIN::class.java))
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "ArrowBack",
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(onClick = {

                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share"))


                }) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "PLACE",
                        tint = Color.White
                    )
                }

                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }
            }
        )
        //End of topappbar
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Table Of Contents",
            fontSize = 40.sp,
            modifier = Modifier.padding(start = 15.dp, end = 10.dp),
            fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(10.dp))

Text(text = "Healthy practices",

    fontSize = 40.sp,
    modifier = Modifier.padding(start = 15.dp, end = 10.dp),
    fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(10.dp))



//card1

        Card(modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .height(50.dp)
            .fillMaxWidth()) {
            Row {
                Box(modifier = Modifier.fillMaxWidth(),
                ) {
                    
                    Column {
                        Text(text = "Koda", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(start = 80.dp, top = 4.dp))

                    }
                }



            }
        }
        //end of card1

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}