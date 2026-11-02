package com.abraham0058.mobpro2m.ui.screen.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abraham0058.mobpro2s.util.SharedUtil

class MahasiswaViewModel : ViewModel() {
    val userFlow = SharedUtil.getUserFlow(viewModelScope)
}