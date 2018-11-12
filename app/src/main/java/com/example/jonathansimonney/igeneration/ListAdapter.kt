package com.example.jonathansimonney.igeneration

import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_news_detail.*


class ListAdapter// Provide a suitable constructor (depends on the kind of dataset)
(private val mDataset: List<News>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        holder.listText.text = mDataset[holder.adapterPosition].title
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        var listText: TextView

        init {
            listText = v.findViewById(R.id.news_title)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ListAdapter.ViewHolder {
        // create a new view
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_news_detail, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return mDataset.size
    }
}