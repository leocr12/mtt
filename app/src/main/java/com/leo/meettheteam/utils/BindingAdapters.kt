package com.leo.meettheteam.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.leo.meettheteam.R

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("app:layoutManager")
    fun setLayoutManager(recyclerView: RecyclerView, layoutManager: StaggeredGridLayoutManager) {
        recyclerView.layoutManager = layoutManager
    }

    @JvmStatic
    @BindingAdapter("app:adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("app:glide_src")
    fun setImage(imageView: ImageView, url: String?) {
        url?.let {
            Glide.with(imageView.context)
                .load(it)
                .error(R.drawable.ic_no_photo)
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("app:clickListener")
    fun setClicklistener(view: View, clickListener: View.OnClickListener) {
        view.setOnClickListener(clickListener)
    }

    @JvmStatic
    @BindingAdapter("app:isVisible")
    fun setVisibility(view: View, shouldShow: ObservableBoolean) {
        if (shouldShow.get()) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}