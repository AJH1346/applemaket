package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    //item 클릭시 이동
    private var itemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.itemView.findViewById<TextView>(R.id.textProductName).text = currentItem.name
        holder.itemView.findViewById<TextView>(R.id.textProductPrice).text = currentItem.price
        holder.itemView.findViewById<TextView>(R.id.textProductAddress).text = currentItem.address
        holder.itemView.findViewById<TextView>(R.id.textProductLike).text = currentItem.like
        holder.itemView.findViewById<TextView>(R.id.textProductChat).text = currentItem.chat
        holder.itemView.findViewById<ImageView>(R.id.imageProduct).setImageResource(currentItem.image)

        // 아이템 클릭 시 리스너 호출
        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(currentItem)
        }

    }

    override fun getItemCount() = productList.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}