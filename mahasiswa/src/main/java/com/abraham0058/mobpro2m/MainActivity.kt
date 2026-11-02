package com.abraham0058.mobpro2m

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abraham0058.mobpro2m.ui.screen.app.MahasiswaApp
import com.abraham0058.mobpro2m.ui.theme.Mobpro2Theme
import com.abraham0058.mobpro2s.ui.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobpro2Theme {
                MahasiswaApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MahasiswaAppReview() {
    Mobpro2Theme {
        WelcomeScreen(
            appLogo = R.mipmap.ic_launcher,
            appName = R.string.app_name
        )
    }
}