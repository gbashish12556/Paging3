package com.example.paging3

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Movie::class, RemoteKeys::class],
    version = 1,
)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
    abstract fun getRemoteKeysDao(): RemoteKeysDao
}