package com.example.shopping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GridProductViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup)
            : this(LayoutInflater.from(parent.context).inflate(R.layout.grid_product, parent, false))
}