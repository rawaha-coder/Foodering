package com.rawaha.foodering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rawaha.foodering.data.PopularFood
import com.rawaha.foodering.databinding.PopularItemBinding

class PopularFoodAdapter(private val foods: List<PopularFood>): RecyclerView.Adapter<PopularFoodAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = foods.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = foods[position]
        holder.bind(item)
    }

    class ViewHolder(private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: PopularFood) {
            binding.tvPopularFoodName.text = item.name
            binding.tvPopularFoodPrice.text = "${item.price} $"
            binding.imageviewPopularFoodName.setImageResource(item.image)
        }

    }
}