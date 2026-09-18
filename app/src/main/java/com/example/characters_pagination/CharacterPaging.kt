package com.example.characters_pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState

class CharacterPaging(private val apiService: APIService
) : PagingSource<Int, Result>(){
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getCharacter(page)

            LoadResult.Page(
                data = response.result,
                prevKey = if (response.info.prev == null) null else page - 1,
                nextKey = if (response.info.next != null) page + 1 else null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}