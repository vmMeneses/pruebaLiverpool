package com.meneses.appliverpool.ui.productlist.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.meneses.appliverpool.R
import com.meneses.appliverpool.data.response.liverpool.Record
import com.meneses.appliverpool.databinding.ItemProductBinding

class ProductItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemProductBinding.bind(view)
    fun render(product: Record) {
        binding.TextViewName.text = product.productDisplayName
        product.lgImage.let {
            Glide.with(binding.root)
                .load(it)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.ImageViewProduct)
        }

        binding.TextViewPrecio.text = "$ ${product.promoPrice}"
        binding.TextViewPrecioDescuento.text = "$ ${product.listPrice}"
        val listViewColor = listOf(  binding.color1,  binding.color2,  binding.color3 , binding.color4 , binding.color5 , binding.color6)
        if(product.variantsColor.size > 0){
            binding.LinerarColors.visibility = View.VISIBLE
            val tamano = product.variantsColor.size
            for(color in product.variantsColor){
                Log.e("Colors"," ${color.colorHex}")
                binding.color1.setCardBackgroundColor(R.color.blue_return_arrow)
            }
        }else{
            binding.LinerarColors.visibility = View.GONE
        }
    }




}