package com.example.android.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.EditText
import android.text.TextWatcher
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

// ---------- Logging ----------
fun Any.logD(message: String) {
    Log.d(this::class.java.simpleName, message)
}

fun AppCompatActivity.logLifecycle() {
    logD("onCreate")
    lifecycle.addObserver(LifecycleEventObserver { _: LifecycleOwner, event ->
        logD(event.name)
    })
}

// ---------- Navigation ----------
inline fun <reified T : Activity> Context.navigate(vararg extras: Pair<String, Any?>) {
    val intent = Intent(this, T::class.java)
    if (extras.isNotEmpty()) intent.putExtras(bundleOf(*extras))
    startActivity(intent)
}

// ---------- Share Intent ----------
fun Context.shareText(text: String, chooserTitle: String? = null) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    val chooser = Intent.createChooser(sendIntent, chooserTitle ?: "")
    startActivity(chooser)
}

// ---------- Views Helpers ----------
inline fun View.onClick(crossinline block: () -> Unit) {
    setOnClickListener { block() }
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if (value) View.VISIBLE else View.GONE }

fun EditText.afterTextChanged(onChanged: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) { onChanged(s?.toString().orEmpty()) }
    })
}
