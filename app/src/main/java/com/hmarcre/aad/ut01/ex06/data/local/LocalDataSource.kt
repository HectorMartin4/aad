package com.hmarcre.aad.ut01.ex06.data.local

import android.content.SharedPreferences
import com.google.gson.Gson
import com.hmarcre.aad.ut01.ex06.domain.UserEx6

class LocalDataSource(val sharedPref: SharedPreferences) {

    private val gson = Gson()

    fun createUsers(users: List<UserEx6>){
        users.forEach {
            createUser(it)
        }
    }

    fun createUser(user: UserEx6){
        val jsonUser = gson.toJson(user, UserEx6::class.java)

        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
    }


    fun readUser():  List<UserEx6>{
        val userList = mutableListOf<UserEx6>()
        sharedPref.all.forEach { map ->
            val users = gson.fromJson(map.value as String, UserEx6::class.java)
            userList.add(users)
        }
        return userList
    }



    fun updateUser(userId: Int){
        val jsonUser = sharedPref.getString(userId.toString(), null)



    }

    fun deleteUser(userId: Int){

        sharedPref.edit().remove(userId.toString()).apply()

    }
}