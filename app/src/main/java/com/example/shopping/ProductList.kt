package com.example.shopping

import Helper.ClickPosInter
import Helper.ProductNewAdapter
import Helper.SharePrefUtils
import Helper.Utils
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
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

class ProductList : AppCompatActivity(),ClickPosInter {

    private var layoutManager: LinearLayoutManager? = null
    private var adapter: ProductNewAdapter? = null
    //private lateinit var recyclerView: RecyclerView
    lateinit var recyclerView : RecyclerView

    //private val list = ArrayList<ProductModel>()
    private val list = ArrayList<ProductModel1>()

    private var isGrid:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        getListFromAssets()
        setAdapter()

        tvMoveToCart.setOnClickListener {
            setValueToPref()
            val intent = Intent(this@ProductList, CartList::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
        tvLogin.setOnClickListener {
            setValueToPref()
            val intent = Intent(this@ProductList, Login::class.java)
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
        var product:String

        var jarr:JSONArray =JSONArray()
        var jsonObject:JSONObject

        for(model in list){
            jsonObject =JSONObject()
            jsonObject.put(SharePrefUtils.productId,model.productId)
            jsonObject.put(SharePrefUtils.productName,model.productName)
            jsonObject.put(SharePrefUtils.productCode,model.productCode)
            jsonObject.put(SharePrefUtils.releaseDate,model.releaseDate)
            jsonObject.put(SharePrefUtils.description,model.description)
            jsonObject.put(SharePrefUtils.price,model.price)
            jsonObject.put(SharePrefUtils.quantityInCart,model.quantityInCart)
            jsonObject.put(SharePrefUtils.maxQuantity,model.maxQuantity)
            jsonObject.put(SharePrefUtils.isAddedToCart,model.isAddedToCart)
            jsonObject.put(SharePrefUtils.isAddedToCart,model.isAddedToCart)
            jsonObject.put(SharePrefUtils.image1,model.image1)
            jsonObject.put(SharePrefUtils.image2,model.image2)
            jarr.put(jsonObject)
        }
        product= jarr.toString()
        println(">>>>>>>>>>>>>>"+product)
        SharePrefUtils.setString(this,SharePrefUtils.PERF_KEY_PRODUCT,product)
    }

    fun getListFromAssets(){

        var product= SharePrefUtils.getString(this,SharePrefUtils.PERF_KEY_PRODUCT,"")

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
        list.addAll(users)
    }

    override fun click(pos: Int, isAdd: Boolean) {
        if(isAdd){
            if(list.get(pos).quantityInCart<100){
                list.get(pos).quantityInCart++
            }
        }else{
            if(list.get(pos).quantityInCart>=1){
                list.get(pos).quantityInCart--
            }
        }
        setAdapter()
    }

    override fun add(pos: Int, model1: ProductModel1)
    {
        if(list.get(pos).isAddedToCart==0){
            list.get(pos).isAddedToCart=1
        }else{
            list.get(pos).isAddedToCart=0
        }
        setAdapter()
    }

}
