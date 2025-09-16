package org.example.project.maguchilogic.pages.model


import kotlinx.serialization.Serializable

@Serializable
data class WarehouseItem(
    val id: Int,
    val name: String,
    val quantity: Int,
    val expiryDate: String,
    val location: String
)
