package com.charlezz.finalarchitecture.data.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper
@Inject constructor() :
        ApiHelper {

    val TAG = AppApiHelper::class.java.simpleName

//
//    override fun getLatestCardsVersion(): Single<Int> {
//        return Single.create { emitter ->
//            val database = FirebaseDatabase.getInstance().reference
//            database.child("cards").addValueEventListener(object : ValueEventListener {
//                override fun onCancelled(p0: DatabaseError) {
//                    emitter.onSuccess(0)
//                }
//
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    val cardVersion = (dataSnapshot.child("cards_version").value as Long).toInt()
//                    emitter.onSuccess(cardVersion)
//                }
//            })
//        }
//    }
//
//    override fun getAllCardsFromServer(): Single<List<Card>> {
//        return Single.create<List<Card>> { emitter ->
//            val database = FirebaseDatabase.getInstance().reference
//            database.child("cards").child("data").addValueEventListener(object : ValueEventListener {
//                override fun onCancelled(error: DatabaseError) {
//                    emitter.onSuccess(ArrayList())
//                }
//
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    val tempCardList = ArrayList<Card>()
//                    for (childDataSnapshot in dataSnapshot.children) {
//                        val card = childDataSnapshot.getValue(Card::class.java) as Card
//                        tempCardList.add(card)
//                    }
//                    emitter.onSuccess(tempCardList)
//                }
//            })
//        }.observeOn(Schedulers.io())
//    }
//
//    override fun downloadCardIcons(context: Context, cards: List<Card>): Single<Boolean> {
//
//        val iconsFolder = AppConstants.getCardsFile(context)
//
//        return cards.toObservable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .flatMap { card ->
//                    Observable.just(card)
//                }
//                .flatMap { card ->
//                    Observable.create<Boolean> { emitter ->
//                        try {
//                            val tempFile = File.createTempFile("temp", ".png", iconsFolder)
//                            val iconFile = File(context.filesDir, card.path)
//                            FirebaseStorage.getInstance().reference.child(card.path).getFile(tempFile)
//                                    .addOnSuccessListener {
//                                        tempFile.renameTo(iconFile)
//                                        emitter.onNext(true)
//                                        emitter.onComplete()
//                                    }.addOnFailureListener {
//                                        emitter.onError(IOException())
//                                    }
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                            emitter.onNext(false)
//                            emitter.onComplete()
//                        }
//                    }
//                }.all {
//                    it
//                }
//    }

}