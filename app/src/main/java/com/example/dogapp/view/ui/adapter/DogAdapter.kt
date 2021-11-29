package com.example.dogapp.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.example.dogapp.R
import com.example.dogapp.model.data.Dog

class DogAdapter: ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        //val holder = DogViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.previous_dog_item, parent, false))
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.previous_dog_item, parent, false)
        return DogViewHolder(view)

        /*.apply {
            itemView.setOnClickListener {
                onClick(dogImage, it.toString()) }
        }*/
        /*holder.dogImage.setOnClickListener {
            val position = holder.adapterPosition
            onItemClick.onClick(getItem(position))
        }
        return holder*/
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(position)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Dog>() {
            override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogImage: ImageView = itemView.findViewById(R.id.dog_image)
        fun bind(position: Int) {
            val photoUrl = getItem(position)
            dogImage.transitionName = photoUrl.url
            photoUrl.url?.let { loadImage(it) }
        }

    private fun loadImage(photoUrl: String) {
        Glide.with(itemView)
            .load(photoUrl)
            .override(200, 200)
            .transform(RoundedCorners(4))
            .transition(withCrossFade())
            .into(dogImage)

    }
    }

}

