package com.abraham0058.mobpro2.ui.screen.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abraham0058.mobpro2s.R
import com.abraham0058.mobpro2s.ui.AppBarWithLogout
import com.abraham0058.mobpro2s.ui.UserProfileCard
import com.google.firebase.auth.FirebaseUser

@Composable
fun MainScreen(
    user: FirebaseUser
) {
    //pakai uid user yg login
    val factory = ViewModelFactory(user.uid)
    val viewModel: MainViewModel = viewModel(factory = factory)

    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { AppBarWithLogout(com.abraham0058.mobpro2.R.string.app_name) },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(
                    painter = painterResource(R.drawable.ic_add),
                    contentDescription = stringResource(com.abraham0058.mobpro2.R.string.tambah_kelas),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(bottom = 84.dp)
        ) {
            item{
                UserProfileCard(user = user, modifier = Modifier.padding(16.dp))
                HorizontalDivider(modifier = Modifier.padding(horizontal = 24.dp))
            }
            items(viewModel.data) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = it.nama,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
                    )
                }

            }
        }

        if (showDialog) {
            KelasDialog(onDismissRequest = { showDialog = false}) {
                //menambahkan nama kelas
                viewModel.insert(it)
                showDialog = false
            }

        }
    }

}