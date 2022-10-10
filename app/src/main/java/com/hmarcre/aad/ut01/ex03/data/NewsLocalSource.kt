package com.hmarcre.aad.ut01.ex03.data

import com.google.gson.Gson
import android.content.SharedPreferences
import com.hmarcre.aad.ut01.ex03.domain.News

class NewsLocalSource(val sharedPref: SharedPreferences) {

    fun setNews(news: News){

        val gson = Gson()
        val jsonNews = gson.toJson(news, News::class.java)

        val edit = sharedPref.edit()
        edit.putString(news.id.toString(), jsonNews)
        edit.apply()
    }

    fun findById(newsId: Int): News{
        val gson = Gson()

        val jsonNews = sharedPref.getString(newsId.toString(), "")

        return gson.fromJson(jsonNews, News::class.java)
    }

    fun setNewsList(newsList: MutableList<News>){
        newsList.forEach{
            it
        }


        val gson = Gson()
        val jsonNews = gson.toJson(newsList, News::class.java)

        val edit = sharedPref.edit()
        edit.putString(newsList.indices.toString(), jsonNews)
        edit.apply()
    }

    fun findAll(): MutableList<News>{
        return mutableListOf()
    }

}