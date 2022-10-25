package com.example.doit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.doit.ui.theme.DoItTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoItTheme {
                ScaffoldSample()
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldSample(){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(

        scaffoldState= scaffoldState,
        topBar = { TopBar(scaffoldState, scope) },

        drawerContent = {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            imageVector = Icons.Default.Person,
                            contentDescription = "",
                            )
            Text( modifier = Modifier.padding(16.dp), text = "First Line")
            Text( modifier = Modifier.padding(16.dp), text = "Second Line")
            Text( modifier = Modifier.padding(16.dp), text = "Third Line")
            Text( modifier = Modifier.padding(16.dp), text = "Fourth Line")

        },




        bottomBar = { SimpleBottomBar() },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = { /*TODO*/ },
        content = {
            Icon(imageVector = Icons.Default.Favorite,contentDescription = "")
        }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "This is static content",
            )
        }

    }

}
@Composable
fun TopBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    TopAppBar(
        title = {
            Text(
                text = "ScaffoldSample",
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "menu"
                )
            }
        },
        elevation = 8.dp
    )
}

@Composable
fun DrawerContent() {

}

@Composable
fun SimpleBottomBar() {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favourite,
        NavigationItem.Search,
        NavigationItem.Profile
    )

    BottomNavigation(

        elevation = 5.dp,
        contentColor = Color.White
    ){

        items.map {
            BottomNavigationItem(
                icon= {
                    Icon(painter = painterResource(id = it.icon),
                        contentDescription = it.title
                    )
                },
                label= {
                    Text(
                        text = it.title
                    )
                },
                selected = true,
                selectedContentColor= Color.White,
                unselectedContentColor= Color.White.copy(alpha = 0.4f),
                onClick = {

                }
            )
        }

    }
}





