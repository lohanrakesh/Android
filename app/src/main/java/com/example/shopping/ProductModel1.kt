package com.example.shopping

import java.io.Serializable

data class ProductModel1(
    var productId: Int, var productName: String,
    var productCode:String,var releaseDate:String,var description:String,var price:Double,
    var quantityInCart:Int,var maxQuantity:Int,var isAddedToCart:Int,
    var image1:String,var image2:String,
    var images: List<String>
)
