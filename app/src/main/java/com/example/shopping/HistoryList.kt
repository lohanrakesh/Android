package com.example.shopping

import Helper.*
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_product_list.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

class HistoryList : AppCompatActivity(),ClickPosInter {

    private var layoutManager: LinearLayoutManager? = null
    private var adapter: ProductNewAdapter? = null
    //private lateinit var recyclerView: RecyclerView
    lateinit var recyclerView : RecyclerView

    //private val list = ArrayList<ProductModel>()
    private val list = ArrayList<HistroyModel>()

    private var isGrid:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        llTop.visibility=View.GONE
        toggleBtn.visibility=View.GONE
        getListFromAssets()
        setAdapter()

        tvMoveToCart.setOnClickListener {
            setValueToPref()
            val intent = Intent(this@HistoryList, CartList::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
        tvLogin.setOnClickListener {
            setValueToPref()
            val intent = Intent(this@HistoryList, Login::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        toggleBtn.setOnCheckedChangeListener { _, isChecked ->
            isGrid=isChecked
            if (isChecked) {
                setAdapter()
            } else {
                setAdapter()
            }
        }
    }

    private fun setAdapter() {
        recyclerView  =recycler_view
        if(isGrid){
            recyclerView.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = GridLayoutManager(this@HistoryList!!,2)
                // set the custom adapter to the RecyclerView
                recyclerView.adapter = HistoryAdapter(this@HistoryList!!,list!!)
            }
        }else{
            recyclerView.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(this@HistoryList!!)
                // set the custom adapter to the RecyclerView
                recyclerView.adapter = HistoryAdapter(this@HistoryList!!,list!!)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        var product= SharePrefUtils.getString(this,SharePrefUtils.PERF_KEY_PRODUCT,"")

        if(TextUtils.isEmpty(product)){
            product =
                Utils.getJsonFromAssets(applicationContext, "Product.json")
            Log.i("data", product)
        }
        SharePrefUtils.setString(this,SharePrefUtils.PERF_KEY_PRODUCT,product)
    }

    override fun onDestroy() {
        setValueToPref()
        super.onDestroy()
    }

    fun setValueToPref(){

    }

    fun getListFromAssets(){

        list.add(HistroyModel(12345,Date().toString(),"address 1"))
        list.add(HistroyModel(12346,Date().toString(),"address 1"))
        list.add(HistroyModel(12347,Date().toString(),"address 1"))
        list.add(HistroyModel(12348,Date().toString(),"address 1"))
        list.add(HistroyModel(12349,Date().toString(),"address 1"))

        /*var product= SharePrefUtils.getString(this,SharePrefUtils.PERF_KEY_PRODUCT,"")

        if(TextUtils.isEmpty(product)){
            product =
                Utils.getJsonFromAssets(applicationContext, "Product.json")
            Log.i("data", product)
        }

        SharePrefUtils.setString(this,SharePrefUtils.PERF_KEY_PRODUCT,product)

        val gson = Gson()
        val listUserType: Type = object : TypeToken<List<ProductModel1?>?>() {}.type

        val users: List<ProductModel1> =
            gson.fromJson<List<ProductModel1>>(product, listUserType)
        for (i in users.indices) {
            Log.i(
                "data", """
     > Item $i
     ${users[i]}
     """.trimIndent()
            )
        }

        list.clear()
        list.addAll(users)*/
    }


    override fun click(pos: Int, isAdd: Boolean, model1: ProductModel1)
    {
        TODO("Not yet implemented")
    }

    override fun add(pos: Int, model1: ProductModel1)
    {

    }

}
