package com.waracle.techtask.ext

import android.content.Context
import android.view.View
import android.view.View.*
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

fun View.visible() : View {
  if (visibility != VISIBLE) {
    visibility = VISIBLE
  }
  return this
}

fun View.gone() : View {
  if (visibility != GONE) {
    visibility = GONE
  }
  return this
}

fun View.snack(
  message: String,
  length: Int = Snackbar.LENGTH_LONG) {
  val snack = Snackbar.make(this, message, length)
  snack.show()
}

fun Context.toast(message: String) {
  Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
  itemView.setOnClickListener {
    event.invoke(adapterPosition, itemViewType)
  }
  return this
}