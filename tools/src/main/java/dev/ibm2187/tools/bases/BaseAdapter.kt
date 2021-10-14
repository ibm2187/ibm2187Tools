package dev.ibm2187.tools.bases

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : BaseAdapter.BaseViewHolder<T>> :
    RecyclerView.Adapter<VH>() {

    protected val items = arrayListOf<T>()

    open fun areItemsTheSame(oldItem: T, newItem: T) = oldItem === newItem
    open fun areContentsTheSame(oldItem: T, newItem: T) = oldItem === newItem

    fun setItems(newItems: List<T>?) {
        if (newItems == null) return
        val diffUtilCallback = BaseDiffUtilCallback(newItems)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    fun setItemsWithoutNotify(newItems: List<T>?) {
        if (newItems == null) return
        items.clear()
        items.addAll(newItems)
    }

    override fun getItemId(position: Int): Long = position.hashCode().toLong()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        items[position].let { data -> holder.bindData(data) }
    }

    abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bindData(data: T)
    }

    inner class BaseDiffUtilCallback(private val newItems: List<T>) : DiffUtil.Callback() {
        override fun getOldListSize() = items.size

        override fun getNewListSize() = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            areItemsTheSame(items[oldItemPosition], newItems[newItemPosition])

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            areContentsTheSame(items[oldItemPosition], newItems[newItemPosition])

    }

}
