package com.hmarcre.aad.ut01.ex02.data

import android.app.Activity
import android.content.Context
import com.hmarcre.aad.ut01.ex02.domain.FirstOpened

class SharedPreferences(private val activity: Activity) {
    val sharedPref = activity.getPreferences(
        Context.MODE_PRIVATE
    )

    fun saveOpened(firstOpened: FirstOpened){
        val editor = sharedPref.edit()

        editor.apply{
            putBoolean("firstTime", firstOpened.firstTime)
            apply()
        }

    }

    fun getOpened(): FirstOpened{
        return FirstOpened(
            sharedPref.getBoolean("firstTime", true)
        )

    }
}