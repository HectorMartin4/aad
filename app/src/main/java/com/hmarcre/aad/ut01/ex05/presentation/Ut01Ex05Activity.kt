package com.hmarcre.aad.ut01.ex05.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hmarcre.aad.R
import com.hmarcre.aad.ut01.ex05.data.UsersRepository
import com.hmarcre.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.hmarcre.aad.ut01.ex05.data.remote.UsersRemoteDataSource

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex05)

        init()
    }

    private fun init(){

        val usersRepository = UsersRepository(
            UsersLocalDataSource(this.getPreferences(MODE_PRIVATE)), UsersRemoteDataSource()
        )

        val users = usersRepository.getUsers()
        Log.d("@dev", "Users: $users")

        val userById = usersRepository.getUserById(2)
        Log.d("@dev", "User: $userById")

        usersRepository.removeUser(2)

        val users2 = usersRepository.getUsers()
        Log.d("@dev", "Users: $users2")
    }
}