package com.example.easyjobs.network.model.admodel

data class Catalogue(
    val id: Int,
    val key: Int,
    val positions: List<Position>,
    val title: String
)