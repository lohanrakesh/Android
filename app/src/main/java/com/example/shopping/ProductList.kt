package com.example.shopping

import Helper.ProductNewAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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
        val p3=ProductModel("name 3","detail")
        val p4=ProductModel("name 4","detail")
        val p5=ProductModel("name 5","detail")
        list.add(p1)
        list.add(p2)
        list.add(p3)
        list.add(p4)
        list.add(p5)
        setAdapter(false)


        toggleBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                setAdapter(isChecked)
            } else {
                setAdapter(isChecked)
            }
        }
    }

    private fun setAdapter(isGrid: Boolean) {
        recyclerView  =recycler_view
        if(isGrid){
            recyclerView.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = GridLayoutManager(this@ProductList!!,2)
                // set the custom adapter to the RecyclerView
                recyclerView.adapter = ProductNewAdapter(this@ProductList!!,list!!)
            }
        }else{
            recyclerView.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(this@ProductList!!)
                // set the custom adapter to the RecyclerView
                recyclerView.adapter = ProductNewAdapter(this@ProductList!!,list!!)
            }
        }


    }
}
