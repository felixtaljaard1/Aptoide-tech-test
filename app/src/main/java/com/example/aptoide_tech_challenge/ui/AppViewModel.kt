package com.example.aptoide_tech_challenge.ui

import androidx.lifecycle.ViewModel
import com.example.aptoide_tech_challenge.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    repository: AppRepository
): ViewModel(){
    val repository = repository.getAllApps()
}