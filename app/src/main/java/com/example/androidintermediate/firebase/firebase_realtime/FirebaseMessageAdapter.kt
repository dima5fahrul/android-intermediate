package com.example.androidintermediate.firebase.firebase_realtime

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidintermediate.R
import com.example.androidintermediate.databinding.ItemMessageBinding
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class FirebaseMessageAdapter(
    options: FirebaseRecyclerOptions<Message>,
    private val currentUserName: String?
) : FirebaseRecyclerAdapter<Message, FirebaseMessageAdapter.MessageViewHolder>(options) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirebaseMessageAdapter.MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_message, parent, false)
        val binding = ItemMessageBinding.bind(view)
        return MessageViewHolder(binding)
    }

    inner class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {
            binding.tvMessage.text = item.text
            setTextColor(item.name, binding.tvMessage)
            binding.tvMessenger.text = item.name
            Glide.with(itemView.context)
                .load(item.photoUrl)
                .circleCrop()
                .into(binding.ivMessenger)
            if (item.timestamp != null) {
                binding.tvTimestamp.text = DateUtils.getRelativeTimeSpanString(item.timestamp)
            }
        }
    }

    private fun setTextColor(name: String?, tvMessage: TextView) {
        if (currentUserName == name && name != null) {
            tvMessage.setBackgroundResource(R.drawable.rounded_message_blue)
        } else {
            tvMessage.setBackgroundResource(R.drawable.rounded_message_yellow)
        }
    }

    override fun onBindViewHolder(
        holder: MessageViewHolder,
        position: Int,
        model: Message
    ) {
        holder.bind(model)
    }
}