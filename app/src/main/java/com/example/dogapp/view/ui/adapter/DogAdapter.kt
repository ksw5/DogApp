package com.example.dogapp.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dogapp.R
import com.example.dogapp.model.data.Dog
import com.example.dogapp.view.ui.OnDogClickListener

class DogAdapter(private var onItemClick : OnDogClickListener) : ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback){
    class DogViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val dogImage : ImageView = view.findViewById(R.id.dog_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val holder = DogViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.previous_dog_item, parent, false))
        holder.dogImage.setOnClickListener {
            val position = holder.adapterPosition
            onItemClick.onClick(getItem(position))
        }
        return holder
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.adapterPosition
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
}