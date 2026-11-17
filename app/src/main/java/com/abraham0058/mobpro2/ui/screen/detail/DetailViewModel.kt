package com.abraham0058.mobpro2.ui.screen.detail

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abraham0058.mobpro2s.model.Kelas
import com.abraham0058.mobpro2s.model.Mahasiswa
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class DetailViewModel(private val kelasId: String): ViewModel() {
        private val db = Firebase.firestore

        var dataMahasiswa = mutableStateListOf<Mahasiswa>()
            private set


        init {
            db.collection(Kelas.COLLECTION)
                .document(kelasId)
                .collection(Mahasiswa.COLLECTION)
                .get()
                .addOnSuccessListener { value ->
                    value.documents.forEach { docSnapshot ->
                        docSnapshot.toObject<Mahasiswa>()?.let {
                            dataMahasiswa.add(it)
                        }
                    }
                }
                .addOnFailureListener {
                    Log.e("MainViewModel", "getMahasiswaBasedKelas:error", it)
                }
        }
    }
class DetailViewModelFactory(private val kelasId: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return DetailViewModel(kelasId) as T
    }
}
