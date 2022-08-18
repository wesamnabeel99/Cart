package com.wesamnabeel99.cart.view.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.wesamnabeel99.cart.R
import com.wesamnabeel99.cart.databinding.ItemCategoryBinding
import com.wesamnabeel99.cart.model.response.category.Category
import com.wesamnabeel99.cart.utils.loadImageUrl

class CategoryAdapter(
    private var categories: List<Category>,
    private val listener: CategoryInteractionListener
) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory = categories[position]

        holder.binding.apply {
            categoryName.text = currentCategory.name
            categoryImage.loadImageUrl(currentCategory.image.toString())
            root.setOnClickListener {
                listener.onCategoryClick(currentCategory.id!!.toInt())
            }
        }
    }

    override fun getItemCount(): Int = categories.size

}


class CategoryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    val binding = ItemCategoryBinding.bind(viewItem)
}