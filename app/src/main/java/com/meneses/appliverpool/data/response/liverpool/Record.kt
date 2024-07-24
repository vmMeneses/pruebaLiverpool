package com.meneses.appliverpool.data.response.liverpool

data class Record(
    val brand: String,
    val category: String,
    val dwPromotionInfo: DwPromotionInfo,
    val groupType: String,
    val isExpressFavoriteStore: Boolean,
    val isExpressNearByStore: Boolean,
    val isHybrid: Boolean,
    val isImportationProduct: Boolean,
    val isMarketPlace: Boolean,
    val lgImage: String,
    val listPrice: Double,
    val maximumListPrice: Double,
    val maximumPromoPrice: Double,
    val minimumListPrice: Double,
    val minimumPromoPrice: Double,
    val plpFlags: List<Any>,
    val productAvgRating: Double,
    val productDisplayName: String,
    val productId: String,
    val productRatingCount: Int,
    val productType: String,
    val promoPrice: Double,
    val promotionalGiftMessage: String,
    val seller: String,
    val skuRepositoryId: String,
    val smImage: String,
    val variantsColor: List<VariantsColor>,
    val xlImage: String
)