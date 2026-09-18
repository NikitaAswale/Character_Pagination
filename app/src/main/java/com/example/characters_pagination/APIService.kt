package com.example.characters_pagination

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("character")
    suspend fun getCharacter(
        @Query("page") page: Int
    ): Character
}