package com.example.shopping

import Helper.ProductAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ProductList : AppCompatActivity() {

    private var layoutManager: GridLayoutManager? = null
    private var adapter: ProductAdapter? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        layoutManager = GridLayoutManager(this, 3)
        adapter = ProductAdapter(layoutManager)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = layoutManager

            // specify an viewAdapter (see also next example)
            adapter = adapter

        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
//            R.id.change_layout -> {
//                if (layoutManager?.spanCount == 1) {
//                    layoutManager?.spanCount = 3
//                    item.title = "list"
//                } else {
//                    layoutManager?.spanCount = 1
//                    item.title = "grid"
//                }
//                adapter?.notifyItemRangeChanged(0, adapter?.itemCount ?: 0)
//            }
        }
        return super.onOptionsItemSelected(item)
    }
}