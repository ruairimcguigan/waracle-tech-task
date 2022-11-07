package com.waracle.techtask.ui.cakes

import android.content.Context
import android.view.LayoutInflater.from
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import com.waracle.techtask.databinding.CakeItemViewBinding
import com.waracle.techtask.models.CakesItem

class CakesAdapter(private val clickListener: (CakesItem) -> Unit)
    : RecyclerView.Adapter<CakesViewHolder>() {

    private lateinit var context: Context
    private val cakesItems = mutableListOf<CakesItem>()

    fun populate(cakes: List<CakesItem>) {
        cakesItems.clear()
        cakesItems.addAll(cakes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CakesViewHolder {
        context = parent.context
        val binding = CakeItemViewBinding.inflate(from(parent.context), parent, false)
        return CakesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CakesViewHolder,
        position: Int
    ) = holder.bind(
            context = context,
            onClick = clickListener,
            cake = cakesItems[position]
        )

    override fun getItemCount() = cakesItems.size
}

class CakesViewHolder(val binding: CakeItemViewBinding): ViewHolder(binding.root) {
    fun bind(context: Context, onClick: (CakesItem) -> Unit, cake: CakesItem){
        val cakeImage: ImageView = binding.cakeImage
        binding.cakeTitle.text = cake.title
        Picasso.with(context).load(cake.image).into(cakeImage)
        itemView.setOnClickListener { onClick(cake)}
    }
}
