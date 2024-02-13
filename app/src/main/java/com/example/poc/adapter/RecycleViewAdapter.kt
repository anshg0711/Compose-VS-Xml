package com.example.poc.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.poc.R
import com.example.poc.model.Contact
import com.example.poc.viewModel.ContactViewModel

class RecycleViewAdapter(private val contactViewModel: ContactViewModel) :
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
    private var contactList: List<Contact> = contactViewModel.list.value


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("qwerty", contactList.size.toString())
        var view: View
        when (viewType) {
            0 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout1, parent, false)
                return ViewHolder1(view = view)
            }

            1 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout2, parent, false)
                return ViewHolder2(view = view)
            }

            2 -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout3, parent, false)
                return ViewHolder3(view = view)

            }

            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout4, parent, false)
                return ViewHolder4(view = view)

            }
        }
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: Contact = contactList[position]
        val requestOptions = RequestOptions().error(R.drawable.contact)
        when (holder) {
            is ViewHolder1 -> {
                holder.textView.text = "${contact.first_name} ${contact.last_name}"
                Glide.with(holder.itemView.context)
                    .load(contact.avatar)
                    .apply(requestOptions)
                    .into(holder.imageView)
            }

            is ViewHolder2 -> {
                holder.textView1.text = "${contact.first_name}"
                holder.textView2.text = "${contact.last_name}"
                Glide.with(holder.itemView.context)
                    .load(contact.avatar)
                    .apply(requestOptions)
                    .into(holder.imageView)
            }

            is ViewHolder3 -> {
                holder.textView1.text = "${contact.first_name}"
                holder.textView2.text = "${contact.last_name}"
                Glide.with(holder.itemView.context)
                    .load(contact.avatar)
                    .apply(requestOptions)
                    .into(holder.imageView)
            }

            is ViewHolder4 -> {
                holder.textView.text = "${contact.first_name} ${contact.last_name}"
                Glide.with(holder.itemView.context)
                    .load(contact.avatar)
                    .apply(requestOptions)
                    .into(holder.imageView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position % 4
    }

    sealed class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    class ViewHolder1(view: View) : ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView1)
        val textView: TextView = view.findViewById(R.id.textView1)
    }

    class ViewHolder2(view: View) : ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView2)
        val textView1: TextView = view.findViewById(R.id.textView21)
        val textView2: TextView = view.findViewById(R.id.textView22)
    }

    class ViewHolder3(view: View) : ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView3)
        val textView1: TextView = view.findViewById(R.id.textView31)
        val textView2: TextView = view.findViewById(R.id.textView32)
    }

    class ViewHolder4(view: View) : ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView4)
        val textView: TextView = view.findViewById(R.id.textView4)
    }

    init {
        Log.d("jsdhafkjdaskljfldsjafds", "jsdhafkjdaskljfldsjafdsa")
        Log.d("jsdhafkjdaskljfldsjafds", "jsdhafkjdaskljfldsjafds  " + contactList.size.toString())

        contactViewModel.list.asLiveData().observeForever { contacts ->
            contactList = contacts
            notifyDataSetChanged() // Notify RecyclerView of the data change
        }
    }

}