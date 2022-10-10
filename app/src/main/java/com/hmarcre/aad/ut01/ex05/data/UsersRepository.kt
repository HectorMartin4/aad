package com.hmarcre.aad.ut01.ex05.data


import com.hmarcre.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.hmarcre.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.hmarcre.aad.ut01.ex05.domain.User

class UsersRepository(
    val localSource: UsersLocalDataSource,
    val remoteSource: UsersRemoteDataSource
) {

    fun getUsers(): List<User>{

        var users = localSource.getUsers()
        if (users.isEmpty()){
            users = remoteSource.getUser()
            localSource.saveUsers(users)
        }
        return users
    }

    fun getUserById (userId : Int) : User {

        var user = localSource.findById(userId)
        if(user == null){
            user = remoteSource.getUser(userId)
        }
        return user
    }

    fun removeUser (userId: Int){

        var user = localSource.findById(userId)

    }

}

