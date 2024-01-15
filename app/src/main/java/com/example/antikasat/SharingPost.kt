package com.example.antikasat

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.antikasat.SharedPost.Companion.convertBitmapToString
import java.io.ByteArrayOutputStream

class SharingPost : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1


    private lateinit var usernameEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var shareButton: Button
    private lateinit var selectedImageView: ImageView
    private lateinit var selectImageButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharing_post)

        usernameEditText = findViewById(R.id.usernameEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)
        shareButton = findViewById(R.id.shareButton)
        selectedImageView = findViewById(R.id.imageView)
        selectImageButton = findViewById(R.id.selectImageButton)

        shareButton.setOnClickListener {
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
            Toast.makeText(this,"Sharing successful",Toast.LENGTH_SHORT).show()


        }

        selectImageButton.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
        }
    }

    private fun savePostLocally(post: SharedPost) {
        val resultIntent = Intent()
        resultIntent.putExtra("username", post.username)
        resultIntent.putExtra("description", post.description)
        resultIntent.putExtra("imageResourceId", post.imageResource)

        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val username = data.getStringExtra("username")
            val description = data.getStringExtra("description")
            val imageResourceId = data.getIntExtra("imageResourceId", 0)

            if (!username.isNullOrEmpty() && !description.isNullOrEmpty() && imageResourceId != 0) {
                val post = SharedPost(username, description, imageResourceId)


            }
        }
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}