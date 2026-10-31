package com.abraham0058.mobpro2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abraham0058.mobpro2.ui.screen.app.DosenApp
import com.abraham0058.mobpro2.ui.theme.Mobpro2Theme
import com.abraham0058.mobpro2s.ui.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobpro2Theme {
                DosenApp()
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun DosenAppPreview() {
    Mobpro2Theme {
        WelcomeScreen(
            appLogo = R.mipmap.ic_launcher,
            appName = R.string.app_name
        )
    }
}