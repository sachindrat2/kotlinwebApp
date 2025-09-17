package org.example.project.maguchilogic.pages.generateCSV

import androidx.compose.runtime.NoLiveLiterals
import kotlinx.browser.document
import org.example.project.maguchilogic.pages.model.WarehouseItem
import org.w3c.files.Blob
import org.w3c.files.BlobPropertyBag
import org.w3c.dom.HTMLAnchorElement

fun generateCSV(warehouseItems: List<WarehouseItem>): String {
    val header = "ID,Name,Quantity,ExpiryDate\n"
    val rows = warehouseItems.joinToString("\n") { item ->
        "${item.id},${item.name},${item.quantity},${item.expiryDate}"
    }
    return header + rows
}

fun downloadCSV(warehouseItems: List<WarehouseItem>) {
    val csvContent = generateCSV(warehouseItems) // convert list to CSV string
    val blob = Blob(arrayOf(csvContent), BlobPropertyBag("text/csv"))
    val url = js("URL.createObjectURL(blob)") as String
    val link = document.createElement("a") as HTMLAnchorElement
    link.href = url
    link.download = "stock_report.csv"
    link.click()
    js("URL.revokeObjectURL(url)")
}
@NoLiveLiterals
fun generatePDF(warehouseItems: List<WarehouseItem>) {
    val jsPDF = js("window.jspdf.jsPDF")
    val doc = jsPDF()

    doc.setFontSize(16)
    doc.text("Stock Report", 14, 20)

    val headers = arrayOf("ID", "Name", "Quantity", "ExpiryDate")
    val rows = warehouseItems.map { arrayOf(it.id, it.name, it.quantity.toString(), it.expiryDate) }

    doc.autoTable(jsObject {
        head = arrayOf(headers)
        body = rows.toTypedArray()
        startY = 30
    })

    doc.save("stock_report.pdf")
}
fun jsObject(builder: dynamic.() -> Unit): dynamic {
    val obj = js("{}")
    builder(obj)
    return obj
}
