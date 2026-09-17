package com.example.characters_pagination

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Character_UI() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column() {

                            Text(
                                "Characters",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                color = Color.Black,
                                modifier = Modifier,
                                textAlign = TextAlign.Start
                            )

                            Text(
                                "Showing 20 of 826 characters . Pages 2",
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                color = Color.Gray,
                                modifier = Modifier,
                                textAlign = TextAlign.Start
                            )
                        }

                        Icon(
                            painter = painterResource(android.R.drawable.ic_menu_save),
                            tint = Color.DarkGray,
                            contentDescription = "",
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color(0xFFE3F2FD))
                                .padding(6.dp)
                                .size(20.dp)
                        )

                        Icon(
                            painter = painterResource(android.R.drawable.ic_menu_sort_by_size),
                            tint = Color.DarkGray,
                            contentDescription = "",
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color(0xFFE3F2FD))
                                .padding(6.dp)
                                .size(20.dp).size(20.dp)
                        )

                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar() {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically) {

                    BottomBar(
                        icon = painterResource(android.R.drawable.ic_menu_compass),
                        text = "Character",
                    )

                    BottomBar(
                        icon = painterResource(android.R.drawable.ic_menu_camera),
                        text = "Episodes",
                    )

                    BottomBar(
                        icon = painterResource(android.R.drawable.ic_menu_mylocation),
                        text = "Locations",
                    )

                    BottomBar(
                        icon = painterResource(android.R.drawable.ic_menu_edit),
                        text = "Settings",
                    )


                }
            }
        }
    ) {paddingValues -> paddingValues

        Column(
            modifier = Modifier
                .padding(24.dp)
        ) {

            Spacer(Modifier.height(70.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(
                        "Search characters, species, origins...",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(android.R.drawable.ic_menu_search),
                        tint = Color.DarkGray,
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFE3F2FD),
                    unfocusedContainerColor = Color(0xFFE3F2FD),
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                )
            )

            Spacer(Modifier.height(12.dp))

            Row() {

                Text(
                    text = "All 20",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.Black)
                        .padding(horizontal = 14.dp, vertical = 3.dp)

                )

                Spacer(Modifier.width(8.dp))

                LazyRow(Modifier.fillMaxWidth()) {

                    val names = listOf<String>(
                        "Alive",
                        "Dead",
                        "Unknown",
                        "Human",
                        "Alien"
                    )

                    items(names) { name ->
                        lazyRowAnime(text = name)

                        Spacer(Modifier.width(12.dp))

                    }

                }
            }

            Spacer(Modifier.height(12.dp))

           HorizontalDivider(
               modifier = Modifier.fillMaxWidth(),
               color = Color.LightGray
           )

            Spacer(Modifier.height(16.dp))

//
//    LazyColumn(modifier = Modifier
//        .background(Color.Black)) {
//        items(character.itemCount) { index ->
//            character[index]?.let {
//                Anime(character = it)
//            }
//        }
//
//    }

            LazyColumn() {
                item {
                    Anime()
                }
            }

            Spacer(Modifier.height(20.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(20.dp))

            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {

                Button(onClick = {},
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke
                (1.dp, color = Color.LightGray)) {
                    Icon(painter = painterResource(android.R.drawable.ic_media_previous), contentDescription = "",
                        tint = Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                    Text("Previous",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }

                Text("Page 2 of 42",
                    fontSize = 12.sp
                )

                Button(onClick = {},
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke
                        (1.dp, color = Color.LightGray)) {
                    Icon(
                        painter = painterResource(android.R.drawable.ic_media_previous),
                        tint = Color.Gray,
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )

                    Text("Next",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }

            }
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Anime() {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, color = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .size(80.dp)
                    .background(Color(0xFF0A1F44))

            )

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.Top
                ) {

                    Text(
                        text = "Name",
                        modifier = Modifier.weight(1f),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )


                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color(0xFFB7E4C7))
                            .border(
                                1.dp,
                                shape = RoundedCornerShape(50.dp),
                                color = Color(0xFF004D40)
                            )
                            .padding(horizontal = 10.dp, vertical = 1.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(
                                    color = Color(0xFF004D40),
                                    shape = CircleShape
                                )
                        )

                        Spacer(Modifier.width(4.dp))

                        Text(
                            "ALIVE",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF004D40)
                        )
                    }
                }

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "species",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )

                    //if (character.type.isNotBlank()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .size(5.dp)
                                .background(
                                    color = Color.Gray,
                                    shape = CircleShape
                                )
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = "type",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    // }

                    // if (character.gender.isNotBlank()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .size(5.dp)
                                .background(
                                    color = Color.Gray,
                                    shape = CircleShape
                                )
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = "gender",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    // }
                }

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(10.dp),
                        tint = Color.Gray
                    )

                    Spacer(Modifier.width(6.dp))

                    Text(
                        "location.name",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Icon(
                painter = painterResource(android.R.drawable.ic_menu_sort_by_size),
                tint = Color.Gray,
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun lazyRowAnime(
    text: String
){
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color.DarkGray,
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(Color(0xFFE3F2FD))
            .padding(horizontal = 10.dp, vertical = 3.dp)

    )
}

@Composable
fun BottomBar(
    icon : Painter,
    text: String

){

    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Icon(
            painter = icon,
            contentDescription = text,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.LightGray)
                .padding(1.dp)
                .size(20.dp),
            tint = Color(0xFF7B1FA2),
        )

        Text(
        text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
    }
}

@Preview
@Composable
fun PreviewCharacter(){
    Character_UI()
}