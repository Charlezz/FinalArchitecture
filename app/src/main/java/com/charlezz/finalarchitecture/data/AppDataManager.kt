package com.charlezz.finalarchitecture.data

import android.arch.paging.DataSource
import android.content.Context
import com.charlezz.finalarchitecture.data.local.dao.DBHelper
import com.charlezz.finalarchitecture.data.local.entity.Person
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.data.remote.Post
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager
@Inject
constructor(val context: Context,
            val dbHelper: DBHelper,
            val preferencesHelper: PreferencesHelper,
            val apiHelper: ApiHelper)
    : DataManager {
    override fun getPosts(start: Long, limit: Int): Call<List<Post>> = apiHelper.getPosts(start,limit)

    override fun getAllPersons(): DataSource.Factory<Int, Person> = dbHelper.getAllPersons()
//    override fun fetchAllPhotos():Observable<Photo> {
//
//        return Observable.create<Photo> { emitter ->
//            val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//            val projection = null
//            val selection = null
//            val selectionArgs = null
//            val sortOrder = null
//            val cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
//
//            while (cursor.moveToNext()) {
//                val name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DISPLAY_NAME))
//                val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA))
//                emitter.onNext(Photo(name, path))
//            }
//            emitter.onComplete()
//        }
//    }

//    override fun setUpDecks(lifecycleOwner: LifecycleOwner) = dbHelper.setUpDecks(lifecycleOwner)
//
//    override fun getCard(name: String) = dbHelper.getCard(name)
//
//    val TAG = AppDataManager::class.java.simpleName
//    override fun insertCards(cards: List<Card>) = dbHelper.insertCards(cards)
//
//    override fun downloadCardIcons(context: Context, cards: List<Card>): Single<Boolean> = apiHelper.downloadCardIcons(context, cards)
//
//    override fun getLatestCardsVersion(): Single<Int> = apiHelper.getLatestCardsVersion()
//
//    override fun getAllCards(): LiveData<List<Card>> = dbHelper.getAllCards()
//
//    override fun getAllCardsFromServer(): Single<List<Card>> = apiHelper.getAllCardsFromServer()
//
//    override fun getAllDecks(): LiveData<List<Deck>> = dbHelper.getAllDecks()
//
//    override fun getCurrentCardsVersion(): Int = preferencesHelper.getCurrentCardsVersion()
//
//    override fun setCurrentCardsVersion(version: Int): Boolean = preferencesHelper.setCurrentCardsVersion(version)
//
//    override fun deleteCards() = dbHelper.deleteCards()
//
//    override fun getCardsAsDataSource() = dbHelper.getCardsAsDataSource()
//
//    override fun insertDeck(deck: Deck) = dbHelper.insertDeck(deck)
//
//    override fun deleteDeck(deck: Deck) = dbHelper.deleteDeck(deck)
//    override fun play(id: Int) = soundHelper.play(id)

}