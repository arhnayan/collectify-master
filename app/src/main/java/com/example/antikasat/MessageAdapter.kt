package com.example.antikasat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.antikasat.Messagea
import com.example.antikasat.R
import de.hdodenhof.circleimageview.CircleImageView

class MessageAdapter(private val messageList: List<Messagea>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profilePhotoImageView: CircleImageView = itemView.findViewById(R.id.profilePhotoImageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val messageContentTextView: TextView = itemView.findViewById(R.id.messageContentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messageList[position]

        // Veriyi ViewHolder'a bağla
        holder.profilePhotoImageView.setImageResource(message.profilePhotoResId)
        holder.nameTextView.text = message.sender
        holder.messageContentTextView.text = message.message
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
}