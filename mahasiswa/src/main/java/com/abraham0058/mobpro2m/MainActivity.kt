package com.abraham0058.mobpro2m

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.abraham0058.mobpro2m.notify.FcmService
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
        handleExtraData(intent)
    }

    private fun handleExtraData(intent: Intent) {
        if (!intent.hasExtra(FcmService.KEY_URL)) return
        val url = intent.getStringExtra(FcmService.KEY_URL) ?: return
        val tabsIntent = CustomTabsIntent.Builder().build()
        tabsIntent.launchUrl(this, url.toUri())
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