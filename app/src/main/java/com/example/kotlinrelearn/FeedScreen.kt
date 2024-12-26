package com.example.kotlinrelearn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade

data class User(
    val profile: String,
    val name: String,
    val description: String,
    val likeCount: Int,
    val commentCount: Int
)

@Composable
fun FeedScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

        }
    }
}


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 14.dp,
                vertical = 28.dp
            ),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.height(40.dp),
            painter = painterResource(id = R.drawable.instagram1),
            contentDescription = "instagram1"
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = "Like"
            )
            Spacer(Modifier.width(12.dp))
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = "Send"
            )
        }
    }
}

@Composable
fun BottomBar() {
    val context = LocalContext.current
    val bottomBarItems = listOf(
        R.drawable.ic_home,
        R.drawable.ic_search,
        R.drawable.ic_add,
        R.drawable.ic_ig,
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        bottomBarItems.forEach {
            Icon(
                modifier = Modifier.size(22.dp),
                painter = painterResource(id = it),
                contentDescription = null
            )
        }

        // Use Coil to load the profile image
        AsyncImage(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(context)
                .data("https://this-person-does-not-exist.com/img/avatar-gen33bee3a1294b4710ea71d170820cc2b8.jpg")
                .crossfade(true) // Enable crossfade for better transitions
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}