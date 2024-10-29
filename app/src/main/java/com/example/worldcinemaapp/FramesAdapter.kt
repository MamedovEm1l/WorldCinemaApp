package com.example.worldcinemaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class FramesAdapter(
    private val frames: List<Int>
) : RecyclerView.Adapter<FramesAdapter.FrameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_frame, parent, false)
        return FrameViewHolder(view)
    }

    override fun onBindViewHolder(holder: FrameViewHolder, position: Int) {
        holder.bind(frames[position])
    }

    override fun getItemCount(): Int = frames.size

    class FrameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val frameImageView: ImageView = itemView.findViewById(R.id.frameImageView)

        fun bind(frameResId: Int) {
            frameImageView.setImageResource(frameResId)
        }
    }
}
