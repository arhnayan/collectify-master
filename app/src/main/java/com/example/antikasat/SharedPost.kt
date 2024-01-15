package com.example.antikasat

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

data class SharedPost(val username: String, val description: String, val imageResource: Int) {

    companion object {
        fun convertStringToBitmap(string: String): Bitmap {
            val decodedByteArray = android.util.Base64.decode(string, android.util.Base64.DEFAULT)
            return android.graphics.BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.size)
        }

        fun convertBitmapToString(bitmap: Bitmap): String {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            val byteArray = byteArrayOutputStream.toByteArray()
            return android.util.Base64.encodeToString(byteArray, android.util.Base64.DEFAULT)
        }
    }
}
