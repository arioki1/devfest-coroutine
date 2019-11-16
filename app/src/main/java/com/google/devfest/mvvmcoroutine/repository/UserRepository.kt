package com.google.devfest.mvvmcoroutine.repository

import com.google.devfest.mvvmcoroutine.model.response.Data
import com.google.devfest.mvvmcoroutine.repository.remote.UserRemoteDataSource
import kotlinx.coroutines.*

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

class UserRepository(private val userRemoteDataSource: UserRemoteDataSource) {

    suspend fun getAllUsers(scope: CoroutineScope, result: suspend (List<Data>) -> Unit) {
        val job = Job()
        scope.launch(Dispatchers.IO){
            result.invoke(userRemoteDataSource.getAllUsers())
        }
    }

}