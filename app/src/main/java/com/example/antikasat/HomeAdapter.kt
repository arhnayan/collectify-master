// HomeAdapter.kt

package com.example.antikasat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val context: Context, private val posts: List<SharedPost>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val likeButton: ImageView = itemView.findViewById(R.id.likeButton)
        val commentButton: ImageView = itemView.findViewById(R.id.commentButton)

        var liked: Boolean = false // varsayılan olarak false olarak ayarlayın
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]

        // Post verilerini ViewHolder'a bağlama
        holder.usernameTextView.text = post.username
        holder.descriptionTextView.text = post.description
        holder.imageView.setImageResource(post.imageResource)

        // Like butonunu ekleyin ve tıklama işlemini burada gerçekleştirin
        holder.likeButton.setOnClickListener {
            // Like butonuna tıklandığında resmin değişmesi
            holder.liked = !holder.liked
            val newImageResource = if (holder.liked) {
                R.drawable.redheart // Kırmızı kalp
            } else {
                R.drawable.blackheart // Siyah kalp
            }
            holder.likeButton.setImageResource(newImageResource)
        }

        // Comment butonunu ekleyin ve tıklama işlemini burada gerçekleştirin
        holder.commentButton.setOnClickListener {

        }
    }


    override fun getItemCount(): Int {
        return posts.size
    }
}
