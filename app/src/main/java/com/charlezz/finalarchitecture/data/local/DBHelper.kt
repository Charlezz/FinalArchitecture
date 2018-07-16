package com.charlezz.finalarchitecture.data.local

import android.arch.paging.DataSource
import com.charlezz.finalarchitecture.data.local.entity.Person

interface DBHelper {
    fun getAllPersons(): DataSource.Factory<Int, Person>
//    fun insertDeck(deck: Deck)
//    fun getAllDecks(): LiveData<List<Deck>>
//    fun getAllCards(): LiveData<List<Card>>
//    fun insertCards(cards: List<Card>)
//    fun deleteCards()
//    fun getCardsAsDataSource(): DataSource.Factory<Int, Card>
//    fun getCard(name: String): Card
//    fun deleteDeck(deck: Deck)
//    fun setUpDecks(lifecycleOwner: LifecycleOwner)
}
