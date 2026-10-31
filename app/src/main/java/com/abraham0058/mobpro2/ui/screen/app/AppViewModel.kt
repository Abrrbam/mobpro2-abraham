package com.abraham0058.mobpro2.ui.screen.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abraham0058.mobpro2s.util.SharedUtil

class AppViewModel : ViewModel() {
    val userFlow = SharedUtil.getUserFlow(viewModelScope)
}