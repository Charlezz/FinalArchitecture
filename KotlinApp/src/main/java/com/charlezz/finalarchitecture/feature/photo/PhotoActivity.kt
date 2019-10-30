package com.charlezz.finalarchitecture.feature.photo

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.charlezz.finalarchitecture.R
import com.charlezz.finalarchitecture.databinding.ActivityPhotoBinding
import com.charlezz.finalarchitecture.extension.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.toObservable
import javax.inject.Inject

class PhotoActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var binding: ActivityPhotoBinding

    @Inject
    lateinit var viewModel:PhotoActivityViewModel

    private val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

    private val REQUEST_PERMISSION_CODE = 0

    private val disposalBag = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState==null){
            reqPermissions(this, getPermissionList(permissions))
        }
    }

    private fun getPermissionList(permissions:Array<String>): Single<List<String>> {
        return permissions.toObservable()
                .filter { permission ->
                    PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(this, permission)
                }.toList()
    }

    private fun reqPermissions(activity: Activity, list: Single<List<String>>) {
        val disposal = list.subscribe { list ->
            if (list.isNotEmpty()) {
                ActivityCompat.requestPermissions(activity, list.toTypedArray(), REQUEST_PERMISSION_CODE)
            } else {
                replaceFragment(R.id.container, PhotoFragment())
            }
        }
        disposalBag.add(disposal)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_CODE) {
            val disposal = Observables.zip(permissions.toObservable(), grantResults.toObservable())
                    .all {
                        it.second == PackageManager.PERMISSION_GRANTED
                    }.subscribe { t1: Boolean, t2: Throwable? ->
                        if (t2 != null || !t1) {
                            finish()
                        } else {
                            showPhotoFragment()
                        }
                    }
            disposalBag.add(disposal)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposalBag.dispose()
    }

    private fun showPhotoFragment(){
        replaceFragment(R.id.container, PhotoFragment())
    }

}
