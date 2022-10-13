package com.hmarcre.aad.ut01.ex06.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hmarcre.aad.R

import com.hmarcre.aad.ut01.ex06.data.local.LocalDataSource
import com.hmarcre.aad.ut01.ex06.domain.Address
import com.hmarcre.aad.ut01.ex06.domain.Company
import com.hmarcre.aad.ut01.ex06.domain.Geo
import com.hmarcre.aad.ut01.ex06.domain.UserEx6

class Ut01Ex06Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex06)
    }

    private fun init(){
        val localDataSource = LocalDataSource(
            getPreferences(Context.MODE_PRIVATE)
        )
        val user1 = UserEx6(1, "User1", "Username1", "1111@email.com", Address("street1", "suite1","city1","zipcode1", Geo(1,1)),"phone1","website1", Company("Company1","Phrase1","bs1"))
        val user2 = UserEx6(2, "User2", "Username2", "2222@email.com", Address("street2", "suite2","city2","zipcode2", Geo(2,2)),"phone2","website2", Company("Company2","Phrase2","bs2"))
        localDataSource.createUser(user1)
        localDataSource.createUser(user2)

    }
}