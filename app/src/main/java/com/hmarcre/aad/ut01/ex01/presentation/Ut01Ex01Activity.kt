package com.hmarcre.aad.ut01.ex01.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.hmarcre.aad.R
import com.hmarcre.aad.ut01.ex01.data.PreferenceLocalSource
import com.hmarcre.aad.ut01.ex01.data.SharedPrecefenceLocalSource
import com.hmarcre.aad.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity() {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
        initPreferences()

    }

    private fun initSharedPreferences(){
        //val spCustomer: SharedPrecefenceLocalSource = SharedPrecefenceLocalSource(this)
        val spCustomer = SharedPrecefenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1,"Customer1", "Surname1", true))

        ContextCompat.getColor(this, R.color.black)

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "customer $newCustomer")
    }

    private fun initPreferences(){
        //val spCustomer: PrecefenceLocalSource = PrecefenceLocalSource(this)
        val spCustomer = PreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(2,"Customer2", "Surname2", true))

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "customer $newCustomer")
    }

}