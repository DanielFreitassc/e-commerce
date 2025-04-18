package com.danielfreitassc.store.models

data class ProductEntity (
    val id: Long,
    val name: String,
    val price: Double,
    val validity: String,
    val description: String,
    val image: String
)