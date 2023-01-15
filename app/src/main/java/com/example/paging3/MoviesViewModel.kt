package com.example.paging3

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


const val PAGE_SIZE = 20

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val moviesDatabase: MoviesDatabase,
): ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    fun getPopularMovies(): Flow<PagingData<Movie>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = 10,
                initialLoadSize = PAGE_SIZE,
            ),
            pagingSourceFactory = {
                moviesDatabase.getMoviesDao().getMovies()
            },
            remoteMediator = MoviesRemoteMediator(
                moviesApiService,
                moviesDatabase,
            )
        ).flow


}