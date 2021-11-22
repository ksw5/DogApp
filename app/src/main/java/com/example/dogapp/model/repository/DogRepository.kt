package com.example.dogapp.model.repository

import com.example.dogapp.model.data.Dog
import com.example.dogapp.model.data.DogDatabase

class DogRepository(
    val database: DogDatabase
) {

        /*suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
            RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

        suspend fun searchNews(searchQuery: String, pageNumber: Int) =
            RetrofitInstance.api.searchForNews(searchQuery, pageNumber)*/

    suspend fun insert(dog: List<Dog>) = database.dogDao().insert(dog)

       /* fun getSavedNews() = db.getArticleDao().getAllArticles()

        suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)*/

}