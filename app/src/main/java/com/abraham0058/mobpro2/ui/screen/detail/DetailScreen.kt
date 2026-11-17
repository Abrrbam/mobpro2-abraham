package com.abraham0058.mobpro2.ui.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abraham0058.mobpro2.R
import com.abraham0058.mobpro2s.model.Mahasiswa
import com.abraham0058.mobpro2s.ui.UserProfileCard

const val KEY_ID_KELAS = "idKelas"
const val KEY_NAMA_KELAS = "namaKelas"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
   navController: NavHostController,
   kelasId: String,
   kelasName: String,
) {
    val factory = DetailViewModelFactory(kelasId)
    val viewModel: DetailViewModel = viewModel(factory = factory)

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            painter = painterResource(com.abraham0058.mobpro2s.R.drawable.ic_arrow_back),
                            contentDescription = stringResource(R.string.kembali),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = { Text(text = kelasName) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { padding ->
        DetailScreenContent(viewModel.dataMahasiswa, Modifier.padding(padding))

    }
}

@Composable
fun DetailScreenContent(
    mahasiswa: List<Mahasiswa>,
    modifier: Modifier = Modifier,
) {
    if (mahasiswa.isEmpty()){
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = stringResource(R.string.list_kosong))
        }
    }

    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(mahasiswa) { mhs ->
            UserProfileCard(
                name = mhs.name,
                email = mhs.email,
                photoUrl = mhs.photoUrl
            )

        }
    }
}

@Composable
fun DetailPane(
    kelasId: String,
    modifier: Modifier = Modifier
) {
    val viewModel: DetailViewModel = viewModel(key = kelasId, factory =  DetailViewModelFactory(kelasId))
    DetailScreenContent(mahasiswa = viewModel.dataMahasiswa, modifier = modifier)
}