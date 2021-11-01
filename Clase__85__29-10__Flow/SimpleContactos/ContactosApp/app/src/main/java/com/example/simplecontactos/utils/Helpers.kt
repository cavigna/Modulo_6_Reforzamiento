package com.example.simplecontactos.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment

fun dialPhoneNumber(phoneNumber: String, context: Context) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    if (intent.resolveActivity(context.packageManager) == null) {
        context.startActivity(intent)
    }
    else{
        Toast.makeText(context, "No salió", Toast.LENGTH_SHORT).show()
    }
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}