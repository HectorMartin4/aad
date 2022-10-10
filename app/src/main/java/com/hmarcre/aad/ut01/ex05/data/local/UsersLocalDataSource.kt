package com.hmarcre.aad.ut01.ex05.data.local

import android.content.SharedPreferences
import com.google.gson.Gson
import com.hmarcre.aad.ut01.ex05.domain.User

class UsersLocalDataSource(val sharedPref:SharedPreferences) {

    private val gson = Gson()

    fun saveUsers(users: List<User>){
        users.forEach {
            saveUsers(it)
        }

    }

    private fun saveUsers(user: User){
        val jsonUser = gson.toJson(user, User::class.java)

        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
    }

    fun getUsers(): List<User>{
        //TODO
        return emptyList()
    }

    fun findById(userId: Int): User{
        val gson = Gson()

        val jsonUsers = sharedPref.getString(userId.toString(), "")

        return gson.fromJson(jsonUsers, User::class.java)

    }

    fun remove(userId: Int) {

        val User = sharedPref.getString(userId.toString(), "")


    }
}

