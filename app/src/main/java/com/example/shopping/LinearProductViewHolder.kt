package com.example.shopping

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LinearProductViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup)
            : this(LayoutInflater.from(parent.context).inflate(R.layout.linear_product, parent, false))
}