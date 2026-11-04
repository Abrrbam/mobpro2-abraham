package com.abraham0058.mobpro2.navigation

import com.abraham0058.mobpro2.ui.screen.detail.KEY_ID_KELAS
import com.abraham0058.mobpro2.ui.screen.detail.KEY_NAMA_KELAS

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object Detail: Screen(
        "detailScreen/{$KEY_ID_KELAS}/{$KEY_NAMA_KELAS}"
    ) {
        fun withData( id: String, nama: String ) = "detailScreen/$id/$nama"
    }
}