package com.example.shopping

import Helper.ProductNewAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductList : AppCompatActivity() {

    private var layoutManager: LinearLayoutManager? = null
    private var adapter: ProductNewAdapter? = null
    //private lateinit var recyclerView: RecyclerView
    lateinit var recyclerView : RecyclerView

    private val list = ArrayList<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val p1=ProductModel("name 1","detail")
        val p2=ProductModel("name 2","detail")
        list.add(p1)
        list.add(p2)
        setAdapter()
    }

    private fun setAdapter() {
        recyclerView  =recycler_view
        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(this@ProductList!!)
            // set the custom adapter to the RecyclerView
            recyclerView.adapter = ProductNewAdapter(this@ProductList!!,list!!)
        }
    }
}
