package dev.ibm2187.tools.common.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun ViewGroup.inflateView(layoutRes: Int): View =
    LayoutInflater.from(this.context).inflate(layoutRes, this, false)

fun <T : RecyclerView.Adapter<*>> RecyclerView.init(
    adp: T,
    isHorizontal: Boolean = false,
    layoutManager: LinearLayoutManager? = null
) {
    val orientation = if (isHorizontal) RecyclerView.HORIZONTAL else RecyclerView.VERTICAL
    val lm = layoutManager
        ?: LinearLayoutManager(context, orientation, false)

    this.adapter = adp
    this.layoutManager = lm
    this.setHasFixedSize(true)
}
