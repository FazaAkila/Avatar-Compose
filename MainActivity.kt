package com.example.papbmasyaallah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.papbmasyaallah.ui.screens.AvatarScreen
import com.example.papbmasyaallah.ui.theme.PapbmasyaallahTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PapbmasyaallahTheme {
                AvatarScreen()
            }
        }
    }
}
