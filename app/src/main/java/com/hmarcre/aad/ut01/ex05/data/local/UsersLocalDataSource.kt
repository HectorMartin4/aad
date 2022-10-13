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
        val userList = mutableListOf<User>()
        sharedPref.all.forEach { map ->
            val users = gson.fromJson(map.value as String, User::class.java)
            userList.add(users)
        }
        return userList
    }

    fun findById(userId: Int): User{

        val jsonUsers = sharedPref.getString(userId.toString(), null)

        return gson.fromJson(jsonUsers, User::class.java)

    }

    fun remove(userId: Int) {

        sharedPref.edit().remove(userId.toString()).apply()

    }
}

