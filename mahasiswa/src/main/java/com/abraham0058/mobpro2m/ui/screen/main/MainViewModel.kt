package com.abraham0058.mobpro2m.ui.screen.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.abraham0058.mobpro2s.model.Kelas
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.firestore

class MainViewModel: ViewModel() {

    private val db = Firebase.firestore

    private val dataKelasId = mutableStateListOf<String>()
    val dataKelas = mutableStateListOf<String>()

    fun getDataKelas() {
        db.collection(Kelas.COLLECTION)
            .orderBy(Kelas.NAMA)
            .get()
            .addOnCompleteListener { handleKelas(it) }
    }

    private fun handleKelas(task: Task<QuerySnapshot>) {
        dataKelas.clear()
        dataKelasId.clear()

        if (task.isSuccessful) {
            task.result.documents.forEach { kelas ->
                val nama = kelas.getString(Kelas.NAMA) ?: return@forEach
                dataKelas.add(nama)
                dataKelasId.add(kelas.id)
            }
        }
    }

}