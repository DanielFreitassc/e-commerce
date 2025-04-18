package com.danielfreitassc.store.network

import com.danielfreitassc.store.models.ProductEntity
import retrofit2.http.GET


interface ProductService {

    @GET("products")
    suspend fun getProducts(): List<ProductEntity>
}