package com.example.photogallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class DrawableAdapter(private var drawables: List<Int>) : RecyclerView.Adapter<DrawableAdapter.DrawableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return DrawableViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrawableViewHolder, position: Int) {
        holder.photoImageView.setImageResource(drawables[position])
    }

    override fun getItemCount(): Int = drawables.size

    class DrawableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)
    }
}
