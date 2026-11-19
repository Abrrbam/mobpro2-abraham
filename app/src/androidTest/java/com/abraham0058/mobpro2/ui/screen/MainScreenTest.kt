package com.abraham0058.mobpro2.ui.screen

import androidx.activity.ComponentActivity
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.abraham0058.mobpro2.R
import org.junit.Rule
import org.junit.Test

class MainScreenTest {
    companion object {
        private const val NAMA = "Abraham"
        private const val UMUR = "22"
    }

    @get:Rule
    val testRule = createAndroidComposeRule<ComponentActivity>()

    private val inputNama by lazy {
        testRule.onNodeWithText(testRule.activity.getString(R.string.nama))
    }

    private val inputUmur by lazy {
        testRule.onNodeWithText(testRule.activity.getString(R.string.umur))
    }

    private val button by lazy {
        testRule.onNodeWithText(testRule.activity.getString(R.string.cari_tahu))
    }

    @Test
    fun mainScreen_correct() {
        // persiapan
        testRule.setContent { MainScreen(Modifier) }

        // aksi
        inputNama.performTextInput(NAMA)
        inputUmur.performTextInput(UMUR)
        button.performClick()

        // cek hasil
        testRule.onNode(
            hasText(NAMA, true) and
            hasText(Kategori.DEWASA.toString(), true)
        ).assertExists()
    }

}