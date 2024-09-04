package com.example.nativechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nativechat.ui.ChatListScreen
import com.example.nativechat.ui.LoginScreen
import com.example.nativechat.ui.ProfileScreen
import com.example.nativechat.ui.SignUpScreen
import com.example.nativechat.ui.SingleChatScreen
import com.example.nativechat.ui.SingleStatusScreen
import com.example.nativechat.ui.StatusListScreen
import com.example.nativechat.ui.theme.NativeChatTheme
import dagger.hilt.android.AndroidEntryPoint

sealed class DestinationScreen(val route: String){
    object SignUp : DestinationScreen("signUp")
    object Login : DestinationScreen("login")
    object  Profile : DestinationScreen("profile")
    object  ChatList : DestinationScreen("chatList")
    object SingleChat : DestinationScreen("singleChat/{chatId}"){
        fun createRoute(id:String) = "singleChat/$id"
    }
    object StatusList : DestinationScreen("statusList")
    object SingleStatus : DestinationScreen("singleStatus/{statusId}"){
        fun createRoute(id:String) = "singleStatus/$id"
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NativeChatTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatAppNavigation()
                }
            }
        }
    }
}


@Composable
fun ChatAppNavigation(){
    val navController = rememberNavController()
    val vm = hiltViewModel<ChatAppViewModal>()

    NotificationMessage(vm = vm)

    NavHost(navController = navController, startDestination = DestinationScreen.SignUp.route) {
        composable(DestinationScreen.SignUp.route){
            SignUpScreen(navController, vm)
        }
        composable(DestinationScreen.Login.route){
            LoginScreen(navController, vm)
        }
        composable(DestinationScreen.Profile.route){
            ProfileScreen(navController = navController)
        }
        composable(DestinationScreen.StatusList.route){
            StatusListScreen(navController = navController)
        }
        composable(DestinationScreen.SingleStatus.route){
            SingleStatusScreen(statusId = "123")
        }
        composable(DestinationScreen.ChatList.route){
            ChatListScreen(navController = navController)
        }
        composable(DestinationScreen.SingleChat.route){
            SingleChatScreen(chatId = "123")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    ChatAppNavigation()
}

