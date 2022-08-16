package com.wesamnabeel99.cart.view.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wesamnabeel99.cart.R
import com.wesamnabeel99.cart.databinding.ItemCategoryBinding
import com.wesamnabeel99.cart.model.response.Category
import com.wesamnabeel99.cart.utils.loadImageUrl

class CategoryAdapter(private var categories: List<Category>) :
    RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentCategory = categories[position]

        holder.binding.apply {
            categoryName.text = currentCategory.name
            categoryImage.loadImageUrl(currentCategory.image.toString())
        }
    }

    override fun getItemCount(): Int = categories.size
}


class ItemViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    val binding = ItemCategoryBinding.bind(viewItem)
}