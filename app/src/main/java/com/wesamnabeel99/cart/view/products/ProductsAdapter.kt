package com.wesamnabeel99.cart.view.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wesamnabeel99.cart.R
import com.wesamnabeel99.cart.databinding.ItemProductBinding
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.utils.Constants
import com.wesamnabeel99.cart.utils.extensions.loadImageUrl

class ProductsAdapter(
    private var products: List<Product>,
    private val listener: ProductInteractionListener
) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = products[position]

        holder.binding.apply {
            productName.text = currentProduct.title
            productPrice.text = currentProduct.price.toString() + "$"
            currentProduct.images?.let {
                productImage.loadImageUrl(it[Constants.FIRST_IMAGE])
            }

            root.setOnClickListener {
                currentProduct.id?.let { id -> listener.onProductClick(id) }
            }
        }
    }

    override fun getItemCount(): Int = products.size
}


class ProductViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    val binding = ItemProductBinding.bind(viewItem)
}