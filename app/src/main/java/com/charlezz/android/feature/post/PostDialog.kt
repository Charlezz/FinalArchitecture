package com.charlezz.android.feature.post

import android.app.Dialog
import android.content.*
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.charlezz.android.R
import com.charlezz.android.util.extension.DeviceUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class PostDialog
constructor(private val listener: Listener) :
        BottomSheetDialogFragment(),
        DialogInterface.OnClickListener {

    companion object {
        private const val ITEMS = R.array.post_dialog_items
        private const val KAKAO_TALK_PACKAGE = "com.kakao.talk"
    }

    lateinit var itemArray :Array<out String>
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return context?.let {
            itemArray = it.resources.getStringArray(ITEMS)

            if(!DeviceUtil.isPackageInstalled(KAKAO_TALK_PACKAGE, it.packageManager)){
                val itemList = itemArray.toMutableList()
                itemList.remove(it.getString(R.string.share_via_kakaotalk))
                itemArray = itemList.toTypedArray()
            }
            AlertDialog.Builder(it)
                    .setItems(itemArray, this)
                    .create()
        } ?: super.onCreateDialog(savedInstanceState)
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        context?.let {
            when (itemArray[which]) {
                it.getString(R.string.show_from_webview) -> listener.startWebView()
                it.getString(R.string.share_via_email) -> listener.shareViaEmail()
                it.getString(R.string.share_via_kakaotalk) -> listener.shareViaKakaoTalk()
                it.getString(R.string.share_via_sms) -> listener.shareViaSMS()
                it.getString(R.string.copy_to_clipboard) -> listener.copyToClipboard()
            }
        }
    }

    fun show(manager: FragmentManager) {
        super.show(manager, PostDialog::class.java.simpleName)
    }

    interface Listener {
        fun startWebView()
        fun shareViaEmail()
        fun shareViaKakaoTalk()
        fun shareViaSMS()
        fun copyToClipboard()
    }

    class SimpleListener constructor(val fragment: Fragment, val url: String?) : Listener {

        override fun startWebView() {
            try {
                fragment.startActivity(
                        Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(url)
                        }
                )
            }catch (e:Exception){
                e.printStackTrace()
                showNoApp()
            }

        }

        override fun shareViaEmail() {
            try{
                val email = Intent(Intent.ACTION_SEND)
                email.type = "plain/Text"
                email.putExtra(Intent.EXTRA_SUBJECT, "<${fragment.context?.getString(R.string.app_name)}>")
                email.putExtra(Intent.EXTRA_TEXT, url)
                email.type = "message/rfc822"
                fragment.startActivity(Intent.createChooser(email, ""))
            }catch (e:Exception){
                e.printStackTrace()
                showNoApp()
            }

        }

        override fun shareViaKakaoTalk() {
            try {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, url)
                intent.setPackage(KAKAO_TALK_PACKAGE)
                fragment.startActivity(intent)
            }catch (e:Exception){
                e.printStackTrace()
                showNoApp()
            }
        }

        override fun shareViaSMS() {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.putExtra("sms_body", url)
                intent.type = "vnd.android-dir/mms-sms"
                fragment.startActivity(intent)
            }catch (e:Exception){
                e.printStackTrace()
                showNoApp()
            }


        }

        override fun copyToClipboard() {
            val context = fragment.context
            context?.let {
                val clipboard = it.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip: ClipData = ClipData.newPlainText(
                        it.getString(R.string.app_name),
                        url
                )
                clipboard.setPrimaryClip(clip)
                if(!DeviceUtil.isLGDevice()){
                    Toast.makeText(it, R.string.complete_to_copy_to_clipboard, Toast.LENGTH_SHORT).show()
                }
            }

        }

        private fun showNoApp(){
            fragment.context?.let {
                Toast.makeText(it, R.string.no_app, Toast.LENGTH_SHORT).show()
            }
        }

    }

}