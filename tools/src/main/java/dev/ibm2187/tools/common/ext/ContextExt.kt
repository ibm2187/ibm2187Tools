package dev.ibm2187.tools.common.ext

import android.view.View
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding

fun ViewBinding.getString(res: Int) = this.root.context.getString(res)
fun ViewBinding.getColor(res: Int) = ContextCompat.getColor(this.root.context, res)
fun ViewBinding.getDrawable(res: Int) = ContextCompat.getDrawable(this.root.context, res)

fun View.getString(res: Int) = this.context.getString(res)
fun View.getColor(res: Int) = ContextCompat.getColor(this.context, res)
fun View.getDrawable(res: Int) = ContextCompat.getDrawable(this.context, res)
