package com.pachchham.photoapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pachchham.photoapi.Model.PhotosItem
import com.pachchham.photoapi.databinding.WallpaperBinding

class WallpaperAdapter : RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder>() {

    var photos = ArrayList<PhotosItem>()
    lateinit var context: Context

    class WallpaperHolder(itemView: WallpaperBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
        context = parent.context
        var binding = WallpaperBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WallpaperHolder(binding)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: WallpaperHolder, position: Int) {

        holder.binding.apply {
            photos.get(position).apply {

                Glide.with(context).load(src?.portrait).into(imgPhoto)

            }
        }

    }

    fun setPhotos(photos: List<PhotosItem?>?) {
        this.photos = photos as ArrayList<PhotosItem>
    }
}