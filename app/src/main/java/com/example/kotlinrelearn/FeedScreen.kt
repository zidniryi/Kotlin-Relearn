package com.example.kotlinrelearn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage

import coil3.request.ImageRequest
import coil3.request.crossfade
import kotlinx.coroutines.delay

data class User(
    val profile: String,
    val name: String,
)

data class Post(
    val user: User,
    val post: String,
    val description: String,
    val likesCount: Int,
    val commentsCount: Int
)

@Composable
fun FeedScreen(navController: NavController) {
    Scaffold(topBar = {
        TopBar()
    }, bottomBar = {
        BottomBar()
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            val stories = listOf(
                User(
                    profile = "https://this-person-does-not-exist.com/img/avatar-gen6b3b5faef405b1681627466f154dd5bf.jpg",
                    name = "jarjit",

                    ), User(
                    profile = "https://this-person-does-not-exist.com/img/avatar-gen00380d43e2c008e40f00107f7218d353.jpg",
                    name = "meimei",

                    ), User(
                    profile = "https://this-person-does-not-exist.com/img/avatar-gen1d83cce06b8b962d11071e999b2dcbe0.jpg",
                    name = "mail",

                    ), User(
                    profile = "https://this-person-does-not-exist.com/img/avatar-gen0e0cd8314527878fbf827b7d5d29df45.jpg",
                    name = "jasmine",

                    ), User(
                    profile = "https://this-person-does-not-exist.com/img/avatar-gen61320026076034e2eadc4ff27990e3a7.jpg",
                    name = "ros",

                    ), User(
                    profile = "https://this-person-does-not-exist.com/img/avatar-gene874dcc8deda6553fbfdf6e8b83554f7.jpg",
                    name = "muthu",

                    ), User(
                    profile = "https://this-person-does-not-exist.com/img/avatar-gen5da666603975e9f1c79942579afcfd23.jpg",
                    name = "tokdalang",

                    )
            )
//            Stories(stories = stories)

            val posts = listOf(
                Post(
                    user = stories[0],
                    post = "https://images.unsplash.com/photo-1734366965582-1f5bc9d4e21a?q=80&w=3387&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                    likesCount = (100..10000).random(),
                    commentsCount = (100..10000).random(),
                ),
                Post(
                    user = stories[1],
                    post = "https://www.wwf.org.uk/sites/default/files/styles/hero_s/public/2017-01/Ashley%20cooper%20forest.jpg?h=6f8e8448&itok=o0tpKRWJ",
                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                    likesCount = (100..10000).random(),
                    commentsCount = (100..10000).random(),
                ),
                Post(
                    user = stories[2],
                    post = "https://www.iucn.org/sites/default/files/styles/what_we_do_large/public/images-themes/biodiversity-shutterstock_1477256246.jpg.webp?itok=4i9JdtFu",
                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                    likesCount = (100..10000).random(),
                    commentsCount = (100..10000).random(),
                ),
                Post(
                    user = stories[3],
                    post = "https://www.naturebasedsolutionsinitiative.org/wp-content/uploads/2022/11/chuttersnap-MpxAiNDevjU-unsplash-1-aspect-ratio-1024-768.jpg",
                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                    likesCount = (100..10000).random(),
                    commentsCount = (100..10000).random(),
                ),
                Post(
                    user = stories[4],
                    post = "https://cdn-blob.austria.info/cms-uploads-prod/default/0002/92/thumb_191674_default_teaser.jpeg?cachebuster=1682774670",
                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                    likesCount = (100..10000).random(),
                    commentsCount = (100..10000).random(),
                ),
            )
            Post(stories = stories, posts = posts, navController)
        }

    }
}


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 14.dp, vertical = 28.dp
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
fun Stories(stories: List<User>) {
    val context = LocalContext.current
    LazyRow(
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        itemsIndexed(stories) { index, story ->
            if (index == 0) {
                Spacer(modifier = Modifier.width(10.dp))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .border(
                            2.dp, Brush.horizontalGradient(
                                listOf(
                                    Color(0xffff6f00),
                                    Color(0xffffeb35),
                                    Color(0xffff6f00),
                                    Color(0xffff2b99),
                                    Color(0xffff2bd1),
                                    Color(0xffff2bd1),
                                )
                            ), CircleShape
                        )
                        .size(70.dp), contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context).data(story.profile).crossfade(400)
                            .build(),
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(60.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = story.name, fontSize = 13.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun Post(
    stories: List<User>,
    posts: List<Post>,
    navController: NavController
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Stories(stories = stories)
        }
        items(posts) { post ->
            var liked by remember {
                mutableStateOf(false)
            }
            LaunchedEffect(liked) {
                if (liked) {
                    delay(2000)
                    liked = false
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 1.dp, horizontal = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
                    navController.navigate("profile_screen")
                }) {
                    Box(
                        modifier = Modifier
                            .border(
                                1.dp, Brush.horizontalGradient(
                                    listOf(
                                        Color(0xffff6f00),
                                        Color(0xffffeb35),
                                        Color(0xffff6f00),
                                        Color(0xffff2b99),
                                        Color(0xffff2bd1),
                                        Color(0xffff2bd1),
                                    )
                                ), CircleShape
                            )
                            .size(33.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = ImageRequest
                                .Builder(context)
                                .data(post.user.profile)
                                .crossfade(400)
                                .build(),
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(30.dp),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = post.user.name)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(onDoubleTap = {
                    liked = true
                })
            }, contentAlignment = Alignment.Center) {
                AsyncImage(
                    model = ImageRequest
                        .Builder(context)
                        .data(post.post)
                        .crossfade(400)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                AnimatedVisibility(
                    visible = liked, enter = scaleIn(
                        spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    ), exit = scaleOut()
                ) {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp, horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val iconsModifier = Modifier.size(20.dp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        modifier = iconsModifier,
                        painter = painterResource(id = R.drawable.ic_heart),
                        contentDescription = null
                    )
                    Icon(
                        modifier = iconsModifier,
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = null
                    )
                    Icon(
                        modifier = iconsModifier,
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = null
                    )
                }
                Icon(
                    modifier = iconsModifier,
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(text = "${post.likesCount} likes", fontSize = 13.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = post.description, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "View all ${post.commentsCount} comments",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
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