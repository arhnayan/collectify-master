package com.example.antikasat

// UserAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(
    private val userList: List<UserProfile>,
    private val onItemClickListener: (UserProfile) -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val profilePhotoImageView: ImageView = itemView.findViewById(R.id.profilePhotoImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]

        holder.nameTextView.text = user.name
        holder.profilePhotoImageView.setImageResource(user.profilePhotoResId)

        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(user)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}