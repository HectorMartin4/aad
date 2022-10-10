package com.hmarcre.aad.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hmarcre.aad.R
import com.hmarcre.aad.ut01.ex02.data.SharedPreferences
import com.hmarcre.aad.ut01.ex02.domain.FirstOpened

class Ut01Ex02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex02)

        setOpened()

    }

    private  fun setOpened(){
        val opened = SharedPreferences(this)
        opened.saveOpened(FirstOpened(false))
    }


}