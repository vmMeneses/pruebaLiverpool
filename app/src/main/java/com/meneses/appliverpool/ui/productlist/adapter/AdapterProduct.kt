package com.meneses.appliverpool.ui.productlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meneses.appliverpool.R
import com.meneses.appliverpool.data.response.liverpool.Record

class AdapterProduct (
    private var productList : List<Record> = emptyList()
): RecyclerView.Adapter<ProductItemViewHolder>() {

    override fun getItemCount(): Int = productList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
       return ProductItemViewHolder(
           LayoutInflater.from(parent.context)
               .inflate(R.layout.item_product, parent, false)
       )
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        var product = productList[position]
       holder.render(product)
    }

    fun updateListProducts(listProducts : List<Record>){
        productList = listProducts
        notifyDataSetChanged()
    }

}