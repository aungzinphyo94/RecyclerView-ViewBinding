package com.myanmaritc.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myanmaritc.recyclerview.databinding.ItemFlowerBinding

class FlowerAdapter(val flowerList: ArrayList<Flower>,
                    private val listener: (Flower) -> Unit
) : RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {

//    var onItemClickListener: OnItemClickListener? = null
//
//    fun setOnClickListener(clickListener: OnItemClickListener) {
//        this.onItemClickListener = clickListener
//    }

    inner class FlowerViewHolder(val binding: ItemFlowerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val binding = ItemFlowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.binding.txtFlower.text = flowerList.get(position).flowerName
        holder.binding.image.setImageResource(flowerList.get(position).image)

        val item = flowerList[position]
        holder.itemView.setOnClickListener {
//            onItemClickListener!!.onItemClick(item)
            listener(item)
        }
    }

    override fun getItemCount(): Int = flowerList.size

//    interface OnItemClickListener {
//        fun onItemClick(flower: Flower)
//    }
}