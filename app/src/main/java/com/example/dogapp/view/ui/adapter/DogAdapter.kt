package com.example.dogapp.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogapp.R
import com.example.dogapp.model.data.Dog


class DogAdapter : ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {

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
        val dog = getItem(position)
        holder.bind(dog)

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

    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(dog: Dog) {
            val dogImage = itemView.findViewById<ImageView>(R.id.dog_image)
            //Picasso.get().load(dog.url).fit().centerCrop().into(dogImage)

            Glide.with(itemView.context).load(dog.url).centerCrop().into(dogImage)
        }
    }
}



