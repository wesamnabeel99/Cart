package com.wesamnabeel99.cart.view.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wesamnabeel99.cart.R
import com.wesamnabeel99.cart.databinding.ItemCategoryBinding
import com.wesamnabeel99.cart.model.response.Category
import com.wesamnabeel99.cart.utils.loadImageUrl

class CategoryAdapter(private var categories: List<Category>) :
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
            categoryImage.setOnClickListener {
                Toast.makeText(
                    holder.binding.root.context,
                    "passed ${currentCategory.id} to products fragment",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun getItemCount(): Int = categories.size

}


class CategoryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    val binding = ItemCategoryBinding.bind(viewItem)
}