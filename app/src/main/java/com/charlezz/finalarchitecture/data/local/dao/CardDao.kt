package com.charlezz.finalarchitecture.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.charlezz.finalarchitecture.data.local.entity.Card

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: Card)

    @Query("SELECT * FROM card")
    fun loadAllCards(): LiveData<List<Card>>

    @Query("SELECT * FROM card")
    fun loadAllCardsSync(): List<Card>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCards(cards: List<Card>)

    @Query("DELETE FROM card")
    fun deleteCards()

    @Query("SELECT * FROM card")
    fun loadCardsAsDataSource(): DataSource.Factory<Int, Card>

    @Query("SELECT * FROM card WHERE name LIKE :name")
    fun getCard(name: String): Card
}