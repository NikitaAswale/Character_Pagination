package com.example.characters_pagination

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlin.Result

class Character_ViewModel : ViewModel() {

    private val repository = Repository()

    val character : Flow<PagingData<com.example.characters_pagination.Result>> = repository.getCharacter()
}