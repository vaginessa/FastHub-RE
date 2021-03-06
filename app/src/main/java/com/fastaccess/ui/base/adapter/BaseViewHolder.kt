package com.fastaccess.ui.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.fastaccess.utils.setOnThrottleClickListener

/**
 * Created by Kosh on 17 May 2016, 7:13 PM
 */
abstract class BaseViewHolder<T>(
    itemView: View,
    pAdapter: BaseRecyclerAdapter<T, *, OnItemClickListener<T>>?
) : RecyclerView.ViewHolder(itemView), View.OnClickListener, OnLongClickListener {
    interface OnItemClickListener<T> {
        fun onItemClick(position: Int, v: View?, item: T)
        fun onItemLongClick(position: Int, v: View?, item: T)
    }

    protected val adapter: BaseRecyclerAdapter<T, *, OnItemClickListener<T>>? = pAdapter

    protected constructor(itemView: View) : this(itemView, null)

    override fun onClick(v: View) {
        if (adapter?.listener != null) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION && position < adapter.itemCount) adapter.listener!!
                .onItemClick(position, v, adapter.getItem(position)!!)
        }
    }

    override fun onLongClick(v: View): Boolean {
        if (adapter?.listener != null) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION && position < adapter.itemCount) adapter.listener!!
                .onItemLongClick(position, v, adapter.getItem(position)!!)
        }
        return true
    }

    abstract fun bind(t: T)
    open fun onViewIsDetaching() {}

    companion object {
        fun getView(parent: ViewGroup, @LayoutRes layoutRes: Int): View {
            return LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        }
    }

    init {
        itemView.setOnThrottleClickListener {
            onClick(it)
        }
        itemView.setOnLongClickListener {
            onLongClick(it)
        }
    }
}