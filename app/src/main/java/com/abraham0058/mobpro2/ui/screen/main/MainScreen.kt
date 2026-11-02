package com.abraham0058.mobpro2.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abraham0058.mobpro2s.ui.AppBarWithLogout
import com.abraham0058.mobpro2s.ui.UserProfileCard
import com.google.firebase.auth.FirebaseUser

@Composable
fun MainScreen(
    user: FirebaseUser
) {
    Scaffold(
        topBar = { AppBarWithLogout(com.abraham0058.mobpro2.R.string.app_name) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            UserProfileCard(user)
        }
    }

}