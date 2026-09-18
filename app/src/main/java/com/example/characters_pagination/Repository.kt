package com.example.characters_pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class Repository {

    private val api = RetrofitService.api

    fun getCharacter() : Flow<PagingData<Result>>{
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPaging(api)
            }
        ).flow
    }
}