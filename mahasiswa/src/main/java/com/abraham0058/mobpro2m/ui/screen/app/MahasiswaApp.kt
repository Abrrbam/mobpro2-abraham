package com.abraham0058.mobpro2m.ui.screen.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abraham0058.mobpro2m.R
import com.abraham0058.mobpro2s.ui.WelcomeScreen


@Composable
fun MahasiswaApp() {
    val viewModel: MahasiswaViewModel = viewModel()
    val userFlow by viewModel.userFlow.collectAsState()

    if (userFlow == null) {
        Scaffold { innerPadding ->
            WelcomeScreen(
                appLogo = R.mipmap.ic_launcher,
                appName = R.string.app_name,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}