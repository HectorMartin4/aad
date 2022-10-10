package com.hmarcre.aad.ut01.ex03

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hmarcre.aad.ut01.ex03.data.NewsLocalSource
import com.hmarcre.aad.ut01.ex03.domain.News
import com.hmarcre.aad.ut01.ex04.SecureSharedPreferences

class UT01Ex03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        initWithList()
    }


    private fun init(){
        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        val news1 = News(1, "titulo1", "subtitulo1", "Summay1")
        val news2 = News(2, "titulo2", "subtitulo2", "Summay2")
        val news3 = News(3, "titulo3", "subtitulo3", "Summay3")

        newsLocalSource.setNews(news1)
        newsLocalSource.setNews(news2)
        newsLocalSource.setNews(news3)

        val newNews1 = newsLocalSource.findById(2)

        Log.d("@dev","News: $newNews1")
    }

    private fun initWithList(){
        val newsList: MutableList<News> = mutableListOf<News>(
            News(1, "titulo1", "subtitulo1", "Summay1"),
            News(2, "titulo2", "subtitulo2", "Summay2"),
            News(3, "titulo3", "subtitulo3", "Summay3")
        )

        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        val newNews1 = newsLocalSource.findAll()

        Log.d("@dev", "News2: $newNews1")

    }

    private fun secure() {
        val secure = SecureSharedPreferences(applicationContext)
        secure.saveNews(News(1,"News1","News1","summary1"))
    }
}