package com.meneses.appliverpool.ui.productlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.meneses.appliverpool.data.response.liverpool.Record
import com.meneses.appliverpool.databinding.ItemProductBinding

class ProductItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemProductBinding.bind(view)


    fun render(product: Record) {
        binding.TextViewName.text = product.productDisplayName
    }




}