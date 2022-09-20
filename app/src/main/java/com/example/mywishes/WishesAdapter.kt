package com.example.mywishes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishesAdapter(private val wishes: List<Wish>): RecyclerView.Adapter<WishesAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val ItemName = itemView.findViewById<TextView>(R.id.ItemNameDisplay)
        val Price = itemView.findViewById<TextView>(R.id.PriceDisplay)
        val ItemLink = itemView.findViewById<TextView>(R.id.ItemLinkDisplay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        //Inflating the custom layout
        val wishView = inflater.inflate(R.layout.single_item,parent,false)
        //Return a new holder instance
        return ViewHolder(wishView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishes.get(position)
        // Set item views based on views and data model
        holder.ItemName.text = wish.name
        holder.Price.text = wish.price.toString()
        holder.ItemLink.text = wish.link
    }

    override fun getItemCount(): Int {
        return wishes.size
    }
}