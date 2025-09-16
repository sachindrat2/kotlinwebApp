package org.example.project.maguchilogic.pages.model

import kotlinx.coroutines.delay


object WarehouseApi {
    private var items = mutableListOf(
        WarehouseItem(1, "Item A", 20, "2025-12-01", "Aisle 1"),
        WarehouseItem(2, "Item B", 5, "2025-09-20", "Aisle 2"),
        WarehouseItem(3, "Item C", 0, "2025-08-15", "Aisle 3")
    )

    suspend fun getItems(): List<WarehouseItem> {
        delay(500)
        return items
    }

    suspend fun addItem(item: WarehouseItem) {
        delay(300)
        items.add(item)
    }

    suspend fun updateItem(item: WarehouseItem) {
        delay(300)
        items = items.map { if (it.id == item.id) item else it }.toMutableList()
    }

    suspend fun deleteItem(itemId: Int) {
        delay(300)
        items.removeAll() { it.id == itemId }
    }
}
