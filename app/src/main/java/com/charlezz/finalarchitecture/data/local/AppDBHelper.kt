package com.charlezz.finalarchitecture.data.local

import android.arch.paging.DataSource
import com.charlezz.finalarchitecture.data.local.dao.DBHelper
import com.charlezz.finalarchitecture.data.local.entity.Person
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDBHelper @Inject constructor(private val appDatabase: AppDatabase, val executors: AppExecutors):DBHelper{
    override fun getAllPersons(): DataSource.Factory<Int, Person> {
        return appDatabase.dao().getAllPersons()
    }
//    val TAG = AppDBHelper::class.java.simpleName
//    override fun getCard(name: String): Card = appDatabase.cardDao().getCard(name)
//
//    private val defaultCardList = ArrayList<Card>().apply {
//        add(Card(82, "zap", "1/2", "ui/cards/zap.png"))
//        add(Card(69, "skeletons", "1", "ui/cards/skeletons.png"))
//        add(Card(62, "rage", "2", "ui/cards/rage.png"))
//        add(Card(53, "minions", "3", "ui/cards/minions.png"))
//        add(Card(56, "musketeer", "4", "ui/cards/musketeer.png"))
//        add(Card(78, "witch", "5", "ui/cards/witch.png"))
//        add(Card(70, "sparky", "6", "ui/cards/sparky.png"))
//        add(Card(58, "pekka", "7", "ui/cards/pekka.png"))
//        add(Card(32, "golem", "8", "ui/cards/golem.png"))
//        add(Card(74, "three_musketeers", "9", "ui/cards/three_musketeers.png"))
//        add(Card(54, "mirror", "?", "ui/cards/mirror.png"))
//    }
//
//    private fun insertDefaultDeck() {
//        val defaultDeck = Deck(1, AppConstants.DEFAULT_DECK_NAME, "Default", defaultCardList)
//        insertDeck(defaultDeck)
//    }
//
//    private fun insertDefaultCardsIfNoCards(lifecycleOwner: LifecycleOwner) {
//        getAllCards().observe(lifecycleOwner, Observer {
//            it?.let {
//                if (it.isEmpty()) {
//                    insertCards(defaultCardList)
//                }
//            }
//        })
//    }
//
//    override fun setUpDecks(lifecycleOwner: LifecycleOwner) {
//        Log.e(TAG, "setUpDecks")
//        insertDefaultCardsIfNoCards(lifecycleOwner)
//        insertDefaultDeck()
//    }
//
//    override fun insertDeck(deck: Deck) = executors.diskIO.execute { appDatabase.deckDao().insertDeck(deck) }
//
//    override fun deleteCards() = appDatabase.cardDao().deleteCards()
//
//    override fun insertCards(cards: List<Card>) = executors.diskIO.execute { appDatabase.cardDao().insertCards(cards) }
//
//    override fun getAllDecks(): LiveData<List<Deck>> = appDatabase.deckDao().loadAllDecks()
//
//    override fun getAllCards(): LiveData<List<Card>> = appDatabase.cardDao().loadAllCards()
//
//    override fun getCardsAsDataSource() = appDatabase.cardDao().loadCardsAsDataSource()
//
//    override fun deleteDeck(deck: Deck) = executors.diskIO.execute { appDatabase.deckDao().deleteDeck(deck) }
}