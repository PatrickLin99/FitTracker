package com.patrick.fittracker.data.source

import androidx.lifecycle.MutableLiveData
import com.patrick.fittracker.data.Article
import com.patrick.fittracker.data.RecordSetOrder
import com.patrick.fittracker.data.Result
import com.patrick.fittracker.data.SelectedMuscleGroup
import com.patrick.fittracker.group.MuscleGroupTypeFilter
import com.patrick.fittracker.record.SetOrderFilter

interface FitTrackerDataSource {

    suspend fun getSelectedMuscleGroupMenu (group: MuscleGroupTypeFilter): Result<SelectedMuscleGroup>

    suspend fun getSetOrderNum (group: SetOrderFilter): Result<RecordSetOrder>

//    suspend fun login(id: String): Result<Author>
//
//    suspend fun getArticles(): Result<List<Article>>
//
//    fun getLiveArticles(): MutableLiveData<List<Article>>
//
//    suspend fun publish(article: Article): Result<Boolean>
//
//    suspend fun delete(article: Article): Result<Boolean>
}